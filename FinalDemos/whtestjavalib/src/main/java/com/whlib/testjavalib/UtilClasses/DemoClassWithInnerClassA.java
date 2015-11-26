package com.whlib.testjavalib.UtilClasses;

import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui5-s on 2015/11/26.
 */
public class DemoClassWithInnerClassA {

    public DemoClassWithInnerClassA() {
        Loger.d("in DemoClassWithInnerClassA default constructor");
    }

    public class Inner {

        public Inner() {
            Loger.d("in DemoClassWithInnerClassA$Inner default constructor");
        }
    }
}
