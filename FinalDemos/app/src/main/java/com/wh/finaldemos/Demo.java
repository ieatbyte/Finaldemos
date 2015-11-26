package com.wh.finaldemos;

import android.content.Intent;

import com.whlib.alib.Log.XLog;

public abstract class Demo {

    XLog logger = new XLog(Demo.class, true, true);

    public void start() {
        Intent intent = new Intent();
        intent.setClass(App.context, getLaunchActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.context.startActivity(intent);
        logger.d("start demo:" + getTitle());
    }

    public String getTitle() {
        return getClass().getSimpleName();
    }

    public abstract Class getLaunchActivityClass();
}
