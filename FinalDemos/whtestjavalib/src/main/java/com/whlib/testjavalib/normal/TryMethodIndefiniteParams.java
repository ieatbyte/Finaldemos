package com.whlib.testjavalib.normal;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui5-s on 2015/11/26.
 *
 * Conclusion:
 * #1: indefinite params must be last one or will can not compile
 * #2: give nothing, nums length is 0 but not null
 * #3: give null, nums will be null
 */
public class TryMethodIndefiniteParams extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();
        demoMethodWithIndefiniteParams("hello"); // #2 nums length is 0 but not null
        demoMethodWithIndefiniteParams("hello2", null); // #3 nums is null
    }

    private void demoMethodWithIndefiniteParams(String a, int... nums) {
        Loger.d("in demoMethodWithIndefiniteParams a:" + a + ", nums:" + (nums == null ? "null" : nums.length));
    }

    // #1 error, can not compile, indefinite params must be last one
//    private void demoMethodWithIndefiniteParams(int... nums, String a) {
//
//    }
}
