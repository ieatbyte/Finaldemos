package com.wh.finaldemos;

import android.content.Intent;
import android.util.Log;

public abstract class Demo {

    public void start() {
        Intent intent = new Intent();
        intent.setClass(App.context, getLaunchActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.context.startActivity(intent);
        Log.d("Demo", "start demo:" + getTitle());
    }

    public String getTitle() {
        return getClass().getSimpleName();
    }

    public abstract Class getLaunchActivityClass();
}
