package com.wh.finaldemos;

import android.app.Application;
import android.content.Context;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
