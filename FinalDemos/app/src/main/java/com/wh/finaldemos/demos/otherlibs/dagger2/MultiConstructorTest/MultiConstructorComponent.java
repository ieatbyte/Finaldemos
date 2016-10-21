package com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest;

import com.wh.finaldemos.demos.otherlibs.dagger2.Dagger2DemoActivity;

import dagger.Component;

/**
 * Created by wanghui5-s on 2016/10/21.
 * <p>
 * Conclusion:
 * #1:
 */

@Component(modules = TestModule.class)
public interface MultiConstructorComponent {

    void inject(Dagger2DemoActivity activity);
}
