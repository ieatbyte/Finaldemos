package com.whlib.testjavalib.normal;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;
import com.whlib.testjavalib.UtilClasses.DemoClassA;
import com.whlib.testjavalib.UtilClasses.DemoClassExA;

/**
 * Created by wanghui on 17-3-24.
 */

public class TryInstanceOf extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        DemoClassExA exa = new DemoClassExA();

        Loger.d("TryInstanceOf " + (exa instanceof DemoClassA));
    }
}
