package com.wh.finaldemos.demos.resource.BitmapScaleLoad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.wh.finaldemos.DemoDebug;
import com.wh.finaldemos.R;

import java.io.File;
import java.lang.ref.WeakReference;

public class BitmapScaleLoadDemoActivity extends AppCompatActivity {

    private ImageButton mImageContainer;

    private ImageView mImageViewContainer;

    private BitmapFactory.Options mBitmapLoadOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_scale_load_demo);

        mImageContainer = (ImageButton) findViewById(R.id.image_container);
        mImageViewContainer = (ImageView) findViewById(R.id.image_view_container);

        mBitmapLoadOption = new BitmapFactory.Options();
        mBitmapLoadOption.inDensity = getResources().getDisplayMetrics().densityDpi * 6;//DisplayMetrics.DENSITY_XXHIGH;
        mBitmapLoadOption.inTargetDensity = getResources().getDisplayMetrics().densityDpi; //getResources().getDisplayMetrics().densityDpi;
        //mBitmapLoadOption = null;
        new LikeImgsCacheReader(BitmapScaleLoadDemoActivity.this, mBitmapLoadOption).execute();
    }

    void onCacheLoaded(Bitmap bitmap) {
        DemoDebug.log("onCacheLoaded w:" + bitmap.getWidth() + ", h:" + bitmap.getHeight() + ", density:" + bitmap.getDensity());
        if (bitmap != null) {
            mImageContainer.setImageBitmap(bitmap);
            mImageViewContainer.setImageBitmap(bitmap);
        }
    }

    public static class LikeImgsCacheReader extends AsyncTask<Void, Void, Bitmap> {

        public WeakReference<BitmapScaleLoadDemoActivity> mHost;

        private BitmapFactory.Options mOps;

        LikeImgsCacheReader(BitmapScaleLoadDemoActivity host, BitmapFactory.Options ops) {
            mHost = new WeakReference<BitmapScaleLoadDemoActivity>(host);
            mOps = ops;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap result = null;
            try {
                String cachePath = getCachePath();
                if (!TextUtils.isEmpty(cachePath)) {
                    File cacheDirFile = new File(cachePath);
                    if (cacheDirFile.exists()) {
                        if (mOps != null) {
                            result = BitmapFactory.decodeFile(cacheDirFile.getAbsolutePath(), mOps);
                        } else {
                            result = BitmapFactory.decodeFile(cacheDirFile.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                DemoDebug.log("LikeImgsCacheReader doInBackground error." + e.toString());
            }
            DemoDebug.log("LikeImgsCacheReader end");
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            BitmapScaleLoadDemoActivity host = mHost.get();
            if (host != null) {
                host.onCacheLoaded(result);
            }
        }

        public static String getCachePath() {
            //return "/mnt/sdcard/Download/live_v2_default_1.png";
            return "/storage/emulated/0/Download/live_v2_default_1.png";
        }
    }
}
