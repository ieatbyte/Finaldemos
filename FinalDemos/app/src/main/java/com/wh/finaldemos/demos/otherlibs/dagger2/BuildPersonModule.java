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
public class BuildPersonModule {

    String mName;

    public BuildPersonModule(String name) {
        mName = name;
    }

    @Provides
    String name() {
        return mName;
    }
}
