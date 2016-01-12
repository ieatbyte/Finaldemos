package com.wh.finaldemos.demos.animation.normal;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class NormalAnimationDemoActivity extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_animation_demo);

        ImageView loadingImage = (ImageView) findViewById(R.id.video_mask_loading_img);
        final ObjectAnimator oa = ObjectAnimator.ofFloat(loadingImage, "rotation", 0, 360);
//        final ObjectAnimator oa = ObjectAnimator.ofFloat(loadingImage, "scaleX", 1, 3);
        oa.setDuration(20000);
        oa.setInterpolator(new LinearInterpolator());
        //oa.setRepeatCount(ObjectAnimator.INFINITE);
        //oa.setRepeatMode(ObjectAnimator.INFINITE);
//        oa.start();
//        oa.setRepeatCount(-1);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                oa.start();
            }
        }, 1500);
    }
}
