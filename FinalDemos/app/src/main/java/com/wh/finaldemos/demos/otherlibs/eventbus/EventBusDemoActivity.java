package com.wh.finaldemos.demos.otherlibs.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.otherlibs.otto.Activity2;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_demo);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.but1)
    void onBut1Click() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    @org.greenrobot.eventbus.Subscribe
    public void onMyEvent(Activity2.MyEvent event) {
        Log.e("eventbus_demo", "event:" + event.a);
    }
}
