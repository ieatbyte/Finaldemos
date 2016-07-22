package com.wh.finaldemos.demos.otherlibs.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.wh.finaldemos.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ButterKnife.bind(this);
        BusProvider.getInstance().register(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.but1)
    void onBut1Click() {
        BusProvider.getInstance().post(new MyEvent());
        EventBus.getDefault().post(new MyEvent());
    }

    @org.greenrobot.eventbus.Subscribe
    public void onMyEvent2(Activity2.MyEvent event) {
        Log.e("eventbus_demo", "event:" + event.a);
    }

    @Subscribe public void onMyEvent(MyEvent event) {
        Log.e("otto_demo", "event:" + event.a);
    }

    @Produce public MyEvent initialGetMyEvent() {
        MyEvent me = new MyEvent();
        me.a = 10;
        return me;
    }

    public static class MyEvent {
        public int a = 2;
    }
}
