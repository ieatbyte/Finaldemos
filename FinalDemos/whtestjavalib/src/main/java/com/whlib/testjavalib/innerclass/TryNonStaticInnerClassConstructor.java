package com.whlib.testjavalib.innerclass;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;
import com.whlib.testjavalib.UtilClasses.DemoClassWithInnerClassA;

/**
 * Created by wanghui5-s on 2015/11/26.
 *
 * Conclusion:
 * #1: non-static class will not new if you dont new it
 * #2: non-static class will call default constructor will new it
 */
public class TryNonStaticInnerClassConstructor extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();
        Loger.d("build outer:");
        DemoClassWithInnerClassA dOuterObject = new DemoClassWithInnerClassA(); // #1
        Loger.d("build inner:");
        DemoClassWithInnerClassA.Inner dInnerObject = (new DemoClassWithInnerClassA()).new Inner(); // #2
        Loger.d("done.");
    }
}
