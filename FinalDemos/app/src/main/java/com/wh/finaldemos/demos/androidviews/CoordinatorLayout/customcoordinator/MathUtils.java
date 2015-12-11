package com.wh.finaldemos.demos.androidviews.CoordinatorLayout.customcoordinator;

/**
 * Created by wanghui5-s on 2015/12/10.
 * <p/>
 * Conclusion:
 * #1:
 */
class MathUtils {

    static int constrain(int amount, int low, int high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    static float constrain(float amount, float low, float high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

}