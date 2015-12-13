package com.wh.finaldemos.demos.touch.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wanghui5-s on 2015/11/12.
 */
public class MyView extends View {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchTestDemo.logger.d("MyView onTouchEvent action:" + event.getAction() + ", tag:" + getTag());
        return true;
    }
}
