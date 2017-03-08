package com.whlib.testjavalib.rxjava;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by wanghui on 16-11-18.
 */

public class RxJAVATry extends ABaseTry {

    private Subject<CA, CA> mPublishSubject;

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

        //try1();
        //try2();
        //try3();

        //try4();

        //tryRetryWhen();

        //try5();

        //tryRetry();

        //try6();



        try {
            Loger.d("sleeping start...");
            Thread.sleep(10 * 1000);
            Loger.d("sleeping end...");
        } catch (Exception e) {

        }
    }

    private void try7() {
        mPublishSubject = new SerializedSubject(PublishSubject.create());

//        mPublishSubject

    }

    private void try6() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("helloOne");
                subscriber.onNext("helloTwo");
                subscriber.onNext("helloThree");
                subscriber.onNext("helloFour");
                subscriber.onNext("helloFive");
                subscriber.onCompleted();
            }
        }).zipWith(Observable.range(1, 3), new Func2<String, Integer, String>() {
            @Override
            public String call(String s, Integer integer) {
                return s + integer;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("in onCompleted.");
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("in onError.");
            }

            @Override
            public void onNext(String integer) {
                Loger.d("in onNext." + integer);
            }
        });
    }

    private void tryRetry() {
//        Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                System.out.println("in call, " + "subscribing");
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//
//                }
//                subscriber.onError(new RuntimeException("always fails"));
//            }
//        }).retry(3).subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Loger.d("in onCompleted.");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Loger.d("in onError.");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Loger.d("in onNext.");
//            }
//        });

        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("in call2, " + "subscribing");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                subscriber.onError(new RuntimeException("always fails"));
            }
        }).retry(new Func2<Integer, Throwable, Boolean>() {
            @Override
            public Boolean call(Integer integer, Throwable throwable) {
                System.out.println("in retry call2, " + integer);
                return integer <= 3;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("in onCompleted2.");
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("in onError2.");
            }

            @Override
            public void onNext(String s) {
                Loger.d("in onNext2.");
            }
        });

    }


    private void try5() {
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Loger.d("in call, " + aLong);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Loger.d("in error" + throwable);
            }
        }, new Action0() {
            @Override
            public void call() {
                Loger.d("in completed.");
            }
        });
    }

    private void tryRetryWhen() {
//        Observable.create((Subscriber s) -> {
//            System.out.println("subscribing");
//            s.onError(new RuntimeException("always fails"));
//        }).retryWhen(attempts -> {
//            return attempts.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
//                System.out.println("delay retry by " + i + " second(s)");
//                return Observable.timer(i, TimeUnit.SECONDS);
//            });
//        }).toBlocking().forEach(System.out::println);

        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("in call, " + "subscribing");
                subscriber.onError(new RuntimeException("always fails"));
            }
        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Throwable> observable) {

                return observable.zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Integer>() {
                    @Override
                    public Integer call(Throwable throwable, Integer integer) {
                        return integer;
                    }
                }).flatMap(new Func1<Integer, Observable<?>>() {
                    @Override
                    public Observable<?> call(Integer integer) {
                        System.out.println("delay retry by " + integer + " second(s)");
                        return Observable.timer(integer, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("in onCompleted.");
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("in onError.");
            }

            @Override
            public void onNext(String s) {
                Loger.d("in onNext.");
            }
        });
//                .toBlocking().forEach(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("in foreach, " + s);
//            }
//        });

//        Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                System.out.println("in call, " + "subscribing");
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//
//                }
//                subscriber.onError(new RuntimeException("always fails"));
//            }
//        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
//            @Override
//            public Observable<?> call(Observable<? extends Throwable> observable) {
//
//                return observable;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Loger.d("in onCompleted.");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Loger.d("in onError.");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Loger.d("in onNext.");
//            }
//        });
    }

    private void try4() {
        Observable.create(new Observable.OnSubscribe<CA>() {

            @Override
            public void call(Subscriber<? super CA> subscriber) {
                subscriber.onNext(new CA("hello 123"));
                subscriber.onNext(new CA("hello 456"));
                subscriber.onCompleted();
                Loger.d("in OnSubscribe call tid:" + getTid());
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).map(new Func1<CA, String>() {

            @Override
            public String call(CA ca) {
                Loger.d("in Observer map call tid:" + getTid() + ", ca:" + ca.name);
                return ca.name;
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("in Observer onCompleted call tid:" + getTid());
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("in Observer onError call tid:" + getTid());
            }

            @Override
            public void onNext(String caStr) {
                Loger.d("in Observer onNext call tid:" + getTid() + ", str:" + caStr);
            }
        });
    }

    private void try3() {
        String[] a = new String[]{"hello1", "hello2", "hello3s"};
        Observable.from(a).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s).map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        if (s.equals("hello2")) {
                            String dc = null;
                            dc.length();
                        }
                        return s;
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends String>>() {
                    @Override
                    public Observable<String> call(Throwable throwable) {
                        return Observable.just("error");
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("wh_debug onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("wh_debug onError: " + e.toString());
            }

            @Override
            public void onNext(String aBoolean) {
                Loger.d("wh_debug onNext: " + aBoolean);
            }
        });
    }

    private void try2() {
        String[] a = new String[]{"hello1", "hello2", "hello3s"};
        Observable.from(a).map(new Func1<String, String>() {

            @Override
            public String call(String s) {
                if (s.equals("hello2")) {
                    String dc = null;
                    dc.length();
                }
                return s;
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends String>>() {
            @Override
            public Observable<? extends String> call(Throwable throwable) {
                return Observable.just("error");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Loger.d("wh_debug onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Loger.d("wh_debug onError: " + e.toString());
            }

            @Override
            public void onNext(String aBoolean) {
                Loger.d("wh_debug onNext: " + aBoolean);
            }
        });
    }


    private long getTid() {
        return Thread.currentThread().getId();
    }

    private void try1() {

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
                subscriber.onNext(new ResultItem("333"));
            }
        });
//        observable.subscribeOn(Schedulers.io()).subscribe(new Action1<ResultItem>() {
//            @Override
//            public void call(ResultItem resultItem) {
//                Loger.d("wh_debug ResultItem:" + resultItem);
//            }
//        });
        observable.observeOn(Schedulers.newThread()/*.from(exe3)*/).map(new Func1<ResultItem, CA>() {

            @Override
            public CA call(ResultItem resultItem) {
                Loger.d("wh_debug map call:" + resultItem.name + ", tid:" + getTid());
                try {
                    Thread.sleep(5 * 1000);
                } catch (Exception e) {

                }
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


}
