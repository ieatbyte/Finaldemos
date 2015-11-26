package com.whlib.testjavalib.UtilClasses;

import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui5-s on 2015/11/25.
 */
public class DemoClassWithoutDefaultConstructor {

    int num;

    public DemoClassWithoutDefaultConstructor(int num) {
        Loger.d("in DemoClassWithoutDefaultConstructor(int num) Constructor");
        this.num = num;
    }

    public void out() {
        Loger.d("in out num:" + num);
    }
}
