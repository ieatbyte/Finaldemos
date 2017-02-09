package com.whlib.testjavalib.algorithms;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui on 17-1-9.
 */

public class TryFabonacci extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        Loger.d("start TryFabonacci");
        test1();
    }

    private void test1() {
        Loger.d("result is:" + fn1(6));
    }

    private int fn1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fn1(n - 1) + fn1(n - 2);
        }
    }
}
