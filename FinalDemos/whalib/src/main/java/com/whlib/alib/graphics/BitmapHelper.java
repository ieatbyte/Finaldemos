package com.whlib.alib.graphics;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/**
 * Created by wanghui5-s on 2015/11/12.
 */
public class BitmapHelper {

    public static int[] getBitmapPixels(@NonNull Bitmap bitmap, int x, int y, int width, int height) {
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), x, y,
                width, height);
        final int[] subsetPixels = new int[width * height];
        for (int row = 0; row < height; row++) {
            System.arraycopy(pixels, (row * bitmap.getWidth()),
                    subsetPixels, row * width, width);
        }
        return subsetPixels;
    }
}
