package com.wh.finaldemos;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;

/**
 * Created by wanghui5-s on 2015/12/7.
 * <p/>
 * Conclusion:
 * #1:
 */
public class Utils {

    public static final Uri PUBLIC_MP4_URI = Uri.parse("android.resource://com.wh.finaldemos/" + R.raw.gen_sliders);

    public static int convertDpToPixel(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }
}
