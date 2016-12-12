package com.whlib.testjavalib.rxjava;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import sun.rmi.runtime.Log;

/**
 * Created by wanghui on 16-11-18.
 */

public class RxJAVATry extends ABaseTry {

    public static class ResultItem {
        public String name;

        public ResultItem(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ResultItem{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class CA {
        public String name;

        public CA(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "CA{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public void startTry() {
        super.startTry();

        Loger.d("wh_debug startTry tid:" + Thread.currentThread().getId());

        Executor exe1 = Executors.newFixedThreadPool(1);
        exe1.execute(new Runnable() {
            @Override
            public void run() {
                Loger.d("wh_debug Executor1:" + getTid());
            }
        });
        Executor exe2 = Executors.newFixedThreadPool(1);
        exe2.execute(new Runnable() {
            @Override
            public void run() {
                Loger.d("wh_debug Executor2:" + getTid());
            }
        });
        Executor exe3 = Executors.newFixedThreadPool(1);
        exe3.execute(new Runnable() {
            @Override
            public void run() {
                Loger.d("wh_debug Executor2:" + getTid());
            }
        });

        final ResultItem ri = new ResultItem("hello i");
        Observable<ResultItem> observable = Observable.create(new Observable.OnSubscribe<ResultItem>() {

            @Override
            public void call(Subscriber<? super ResultItem> subscriber) {
                Loger.d("wh_debug in call tid:" + getTid());
                subscriber.onNext(ri);
                subscriber.onNext(new ResultItem("222"));
            }
        });
//        observable.subscribeOn(Schedulers.io()).subscribe(new Action1<ResultItem>() {
//            @Override
//            public void call(ResultItem resultItem) {
//                Loger.d("wh_debug ResultItem:" + resultItem);
//            }
//        });
        observable.observeOn(Schedulers.from(exe3)).map(new Func1<ResultItem, CA>() {

            @Override
            public CA call(ResultItem resultItem) {
                Loger.d("wh_debug map call:" + resultItem.name + ", tid:" + getTid());
                return new CA(resultItem.name);
            }
        }).observeOn(Schedulers.from(exe1)).subscribeOn(Schedulers.from(exe2)).subscribe(new Action1<CA>() {
            @Override
            public void call(CA ca) {
                Loger.d("wh_debug CA:" + ca + ", tid:" + getTid());
            }
        });

//        Loger.d("wh_debug RxJAVATry tid:" + getTid());
        try {
            Thread.sleep(10 * 1000);
        } catch (Exception e) {

        }
    }

    private long getTid() {
        return Thread.currentThread().getId();
    }
}
