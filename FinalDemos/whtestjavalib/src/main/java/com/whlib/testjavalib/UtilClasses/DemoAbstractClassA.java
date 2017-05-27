package com.whlib.testjavalib.UtilClasses;

import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui on 17-5-23.
 */

public abstract class DemoAbstractClassA {

    private int a;

    public DemoAbstractClassA() {
        a = 10;
        Loger.d("in DemoAbstractClassA");
    }

    public int getA() {
        return a;
    }


}
