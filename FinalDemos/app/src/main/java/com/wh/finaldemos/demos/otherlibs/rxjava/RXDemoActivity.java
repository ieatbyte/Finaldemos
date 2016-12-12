package com.wh.finaldemos.demos.otherlibs.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.otherlibs.rxbus.Main2Activity;
import com.wh.finaldemos.demos.otherlibs.rxbus.RxBus;
import com.wh.finaldemos.demos.otherlibs.rxbus.TabEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RXDemoActivity extends AppCompatActivity {

    public static final String TAG = "RxDemo1";
    public static final String TAG2 = "RxDemo2";

    private Observer<Object> mObserver1;
    private Subscriber<Object> mSub1;
    private Subscription mSubscription1;

    private CompositeSubscription mComSubscription;

    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public interface RXGitHubService {
        @GET("users/{user}/repos")
        Observable<List<Repo>> listRepos(@Path("user") String user);
    }

    public static class Repo {
        public long id;
        public String name;
        public String full_name;
    }

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxdemo);
        ButterKnife.bind(this);

//        testRetrofitOnly();
//        testRx();
//        testRxJavaSimple();
//        testRXFlatmap();
//
//        mSubscription1 = RxBus.RxBusHolder.INSTANCE.toObserverable().subscribe(new Action1<Object>() {
//            @Override
//            public void call(Object o) {
//                if (o instanceof TabEvent) {
//                    Log.e("rx_bus", "i get it tabevnt");
//                }
//            }
//        });

        mComSubscription = new CompositeSubscription();

        Observable<ResultItem> observable = Observable.create(new Observable.OnSubscribe<ResultItem>() {

            @Override
            public void call(Subscriber<? super ResultItem> subscriber) {

            }
        });
        observable.subscribe(new Action1<ResultItem>() {
            @Override
            public void call(ResultItem resultItem) {
                Log.e("wh_debug", "ResultItem:" + resultItem);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSub1 != null && !mSub1.isUnsubscribed()) {
            mSub1.unsubscribe();
        }
        if (mSubscription1 != null && !mSubscription1.isUnsubscribed()) {
            mSubscription1.unsubscribe();
        }
        mComSubscription.clear();
    }

    @OnClick(R.id.but1)
    void onButClick() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    private void testRx() {
        Log.e(TAG, "testRx");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RXGitHubService service = retrofit.create(RXGitHubService.class);
        service.listRepos("ieatbyte")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        Log.e(TAG, "onNext");
                        if (repos != null) {
                            for (Repo e : repos) {
                                Log.e(TAG, "RX:" + e.full_name);
                            }
                        }
                    }
                });
    }

    private void testRetrofitOnly() {
        Log.e(TAG, "testRetrofitOnly");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos("ieatbyte");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.e(TAG, "onResponse");
                List<Repo> result = response.body();
                if (result != null) {
                    for (Repo e : result) {
                        Log.e(TAG, e.full_name);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e(TAG, "onFailure");
            }
        });
    }

    private void testRxJavaSimple() {
        Log.e(TAG2, "testRxJavaSimple");
        Observable<String> demoObservable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.e(TAG2, "call:" + Thread.currentThread());
                subscriber.onNext("hello world!");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> demoSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG2, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG2, "onError");
            }

            @Override
            public void onNext(String s) {

                Log.e(TAG2, "onNext " + s + ", " + Thread.currentThread());
            }
        };
        demoObservable1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(demoSubscriber);

        Observable<String> ob2 = Observable.just("hello2");
        ob2.map(new Func1<String, String>() {
            @Override
            public String call(String s) {

                return s + "_tail";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG2, "onNextAction " + s);
            }
        });
    }

    private void testRXFlatmap() {
        final String tag = "testRXFlatmap";
        Person p = new Person();
        Subscriber<Cover> demoSubscriber = new Subscriber<Cover>() {
            @Override
            public void onCompleted() {
                Log.e(tag, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(tag, "onError");
            }

            @Override
            public void onNext(Cover s) {

                Log.e(tag, "onNext " + s + ", " + Thread.currentThread());
            }
        };
        Observable<Person> ob1 = Observable.create(new Observable.OnSubscribe<Person>() {

            @Override
            public void call(Subscriber<? super Person> subscriber) {
                Log.e(tag, "in call sleep start..." + ", " + Thread.currentThread());
                try {
                    Thread.sleep(2500);
                } catch (Exception e) {

                }
                Log.e(tag, "in call sleep end..." + ", " + Thread.currentThread());
                Person p = new Person();
                p.games = new ArrayList<Game>();
                for (int i = 0; i < 5; ++i) {
                    p.games.add(new Game("game:" + i, new Cover("http://www.img.com" + i)));
                }
                subscriber.onNext(p);
                subscriber.onCompleted();
            }
        });
        ob1.flatMap(new Func1<Person, Observable<Game>>() {
            @Override
            public Observable<Game> call(Person person) {
                Log.e(tag, "flatMap1 " + person + ", " + Thread.currentThread());
                Observable ob = Observable.from(person.games);
                ob.subscribe(new Action1<Game>() {
                    @Override
                    public void call(Game game) {
                        Log.e(tag, "flatMap1 INNER " + game + ", " + Thread.currentThread());
                    }
                });
                return ob;
            }
        })

                .flatMap(new Func1<Game, Observable<Cover>>() {
                    @Override
                    public Observable<Cover> call(Game game) {
                        Log.e(tag, "flatMap2 " + game + ", " + Thread.currentThread());
                        Observable ob = Observable.just(game.cover, null);
                        ob.subscribe(new Action1<Cover>() {
                            @Override
                            public void call(Cover gameCover) {
                                Log.e(tag, "flatMap2 INNER " + gameCover + ", " + Thread.currentThread());
                            }
                        });
                        return ob;
                    }
                })
                .map(new Func1<Cover, Cover>() {
                    @Override
                    public Cover call(Cover gameCover) {
                        Log.e(tag, "map " + gameCover + ", " + Thread.currentThread());
                        return gameCover;
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(demoSubscriber);


        //ob1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(demoSubscriber);
    }

    public static class Person {
        ArrayList<Game> games;

        @Override
        public String toString() {
            return "Person{" +
                    "games=" + games +
                    '}';
        }
    }

    public static class Game {
        String name;
        Cover cover;

        public Game(String name, Cover cover) {
            this.name = name;
            this.cover = cover;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "name='" + name + '\'' +
                    ", cover=" + cover +
                    '}';
        }
    }

    public static class Cover {

        String url;

        public Cover(String url) {
            this.url = url;
        }

        String getCoverImgUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Cover{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }
}
