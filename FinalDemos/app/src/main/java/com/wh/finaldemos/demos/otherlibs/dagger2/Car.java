package com.wh.finaldemos.demos.otherlibs.dagger2;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by wanghui5-s on 2016/8/3.
 * <p/>
 * Conclusion:
 * #1:
 */
public class Car {

    private String mName;

    @Inject
    public Car(String name) {
        Log.e("dagger2", "construct car name:" + name);
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
