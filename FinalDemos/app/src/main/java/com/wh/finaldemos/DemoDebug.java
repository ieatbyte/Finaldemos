package com.wh.finaldemos;

import android.util.Log;

/**
 * Created by wanghui5-s on 2016/3/29.
 * <p/>
 * Conclusion:
 * #1:
 */
public class DemoDebug {

    public static final boolean DEBUG = true;

    public static void log(String msg) {
        log(msg, null);
    }

    public static void log(String msg, Exception e) {
        if (DEBUG) {
            if (e != null) {
                Log.e("DemoDebug", msg, e);
            } else {
                Log.e("DemoDebug", msg);
            }
        }
    }
}
