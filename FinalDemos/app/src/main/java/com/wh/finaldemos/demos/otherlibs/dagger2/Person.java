package com.wh.finaldemos.demos.otherlibs.dagger2;

import javax.inject.Inject;

/**
 * Created by wanghui5-s on 2016/8/3.
 * <p/>
 * Conclusion:
 * #1:
 */
public class Person {

    private Car mCar;

    private String mName;

    @Inject
    public Person(Car car) {
        mCar = car;
        mName = "name";
    }

    public Car getCar() {
        return mCar;
    }
}
