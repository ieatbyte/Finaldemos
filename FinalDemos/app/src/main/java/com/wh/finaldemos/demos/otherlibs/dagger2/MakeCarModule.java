package com.wh.finaldemos.demos.otherlibs.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wanghui5-s on 2016/8/3.
 * <p/>
 * Conclusion:
 * #1:
 */
@Module
public class MakeCarModule {

    private String mName;

    public MakeCarModule(String carName) {
        mName = carName;
    }

    @Provides
    Car provideCar() {
        return new Car(mName);
    }
}
