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

    public static String[] DEBUG_IMAGES_URL = {
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
}
