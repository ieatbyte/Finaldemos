package com.wh.finaldemos.demos.activity.lifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.WindowManager;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class ActivityLifeCycleDemoActivity extends BaseDemoActivity {

    public int mLastOrientation = Integer.MIN_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_cycle_demo);
        ActivityLifeCycleDemo.logger.d("onCreate");
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                int ori = getResources().getConfiguration().orientation;
                if (ori != mLastOrientation) {
                    Log.e("test_orientation2", ", get:" + ori + ", last:" + mLastOrientation + ", time:" + System.currentTimeMillis() + ", this:" + ActivityLifeCycleDemoActivity.this);
                }
                mLastOrientation = ori;
                if (!isFinishing()) {
                    getWindow().getDecorView().post(this);
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ActivityLifeCycleDemo.logger.d("onRestart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        ActivityLifeCycleDemo.logger.d("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ActivityLifeCycleDemo.logger.d("onRestoreInstanceState");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityLifeCycleDemo.logger.d("onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityLifeCycleDemo.logger.d("onDetachedFromWindow");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ActivityLifeCycleDemo.logger.d("onWindowFocusChanged");
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
        ActivityLifeCycleDemo.logger.d("onWindowAttributesChanged");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActivityLifeCycleDemo.logger.d("onStart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ActivityLifeCycleDemo.logger.d("onNewIntent");
        // Conclusion: onNewIntent will not update getIntent
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityLifeCycleDemo.logger.d("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityLifeCycleDemo.logger.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityLifeCycleDemo.logger.d("onStop");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ActivityLifeCycleDemo.logger.d("onConfigurationChanged");
        Log.e("test_orientation", "ori:" + newConfig.orientation + ", get:" + getResources().getConfiguration().orientation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityLifeCycleDemo.logger.d("onDestroy");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        ActivityLifeCycleDemo.logger.d("onUserLeaveHint");
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        ActivityLifeCycleDemo.logger.d("onUserInteraction");
    }
}
