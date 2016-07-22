package com.wh.finaldemos.demos.otherlibs.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

public class Main2Activity extends AppCompatActivity {

    private Subscription mSubscription1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_bus_activity_main2);
        ButterKnife.bind(this);

        mSubscription1 = RxBus.RxBusHolder.INSTANCE.toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                if (o instanceof TabEvent) {
                    Log.e("rx_bus", "i get it tabevnt Main2Activity");
                }
            }
        });
    }

    @OnClick(R.id.but1)
    void onButClick() {
        RxBus.RxBusHolder.INSTANCE.send(new TabEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscription1.unsubscribe();
    }
}
