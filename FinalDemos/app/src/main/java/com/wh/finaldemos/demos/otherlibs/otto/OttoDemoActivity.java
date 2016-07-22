package com.wh.finaldemos.demos.otherlibs.otto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.otto.Subscribe;
import com.wh.finaldemos.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OttoDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_demo);
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
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    @Subscribe
    public void onMyEvent(Activity2.MyEvent event) {
        Log.e("otto_demo", "event:" + event.a);
    }
}
