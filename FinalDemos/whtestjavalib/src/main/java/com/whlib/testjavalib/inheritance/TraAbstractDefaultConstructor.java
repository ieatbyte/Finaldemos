package com.whlib.testjavalib.inheritance;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;
import com.whlib.testjavalib.UtilClasses.DemoImpClassA;

/**
 * Created by wanghui on 17-5-23.
 */

public class TraAbstractDefaultConstructor extends ABaseTry{

    @Override
    public void startTry() {
        super.startTry();

        DemoImpClassA a = new DemoImpClassA();
        Loger.d("TraAbstractDefaultConstructor a:" + a.getA());
    }
}
