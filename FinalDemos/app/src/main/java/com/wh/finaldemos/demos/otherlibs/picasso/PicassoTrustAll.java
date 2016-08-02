package com.wh.finaldemos.demos.otherlibs.picasso;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.wh.finaldemos.demos.otherlibs.okhttp3.CustomTrust;

import okhttp3.OkHttpClient;

/**
 * Created by wanghui5-s on 2016/7/28.
 * <p/>
 * Conclusion:
 * #1:
 */
public class PicassoTrustAll {

    private static Picasso mInstance = null;

    private PicassoTrustAll(Context context) {
        CustomTrust ct = new CustomTrust();
        OkHttpClient client = ct.getClient();

        mInstance = new Picasso.Builder(context)
                .downloader(new CustomOkHttp3Downloader(client))
                .listener(new Picasso.Listener() {

                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.e("PICASSO", "" + exception);
                    }
                }).build();

    }

    public static Picasso getInstance(Context context) {
        if (mInstance == null) {
            new PicassoTrustAll(context);
        }
        mInstance.setLoggingEnabled(true);
        return mInstance;
    }
}