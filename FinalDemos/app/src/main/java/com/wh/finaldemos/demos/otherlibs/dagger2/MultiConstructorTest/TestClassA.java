package com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest;

/**
 * Created by wanghui5-s on 2016/10/21.
 * <p>
 * Conclusion:
 * #1:
 */

public class TestClassA {

    public int a;

    public int b;

    public int c;

    public TestClassA(int a) {
        this.a = a;
    }

    public TestClassA(int b, int c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "TestClassA{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
