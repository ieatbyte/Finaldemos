package com.wh.finaldemos.demos.otherlibs.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.otto.Subscribe;
import com.wh.finaldemos.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ButterKnife.bind(this);
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @OnClick(R.id.but1)
    void onBut1Click() {
        BusProvider.getInstance().post(new MyEvent());
    }

    @Subscribe public void onMyEvent(MyEvent event) {
        Log.e("otto_demo", "event:" + event.a);
    }

    public static class MyEvent {
        int a = 2;
    }
}
