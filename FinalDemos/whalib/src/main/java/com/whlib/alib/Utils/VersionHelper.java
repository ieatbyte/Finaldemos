package com.whlib.alib.Utils;

import android.os.Build;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class VersionHelper {

    public static boolean isEAbove(int apiLevel) {
        return Build.VERSION.SDK_INT >= apiLevel;
    }
}
