package com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wanghui5-s on 2016/10/21.
 * <p>
 * Conclusion:
 * #1:
 */
@Module
public class TestModule {

    private int mA;

    private int mB;

    private int mC;

    public TestModule(int a, int b, int c) {
        mA = a;
        mB = b;
        mC = c;
    }

    @Provides
    @Named("one")
    public TestClassA provideTestClassA1() {
        return new TestClassA(mA);
    }

    @Provides
    @Named("two")
    public TestClassA provideTestClassA2() {
        return new TestClassA(mB, mC);
    }
}
