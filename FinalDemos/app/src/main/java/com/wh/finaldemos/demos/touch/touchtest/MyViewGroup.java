package com.wh.finaldemos.demos.touch.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by wanghui5-s on 2015/11/12.
 */
public class MyViewGroup extends RelativeLayout {

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        TouchTestDemo.logger.d("MyViewGroup onInterceptTouchEvent action:" + ev.getAction() + ", tag:" + getTag());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchTestDemo.logger.d("MyViewGroup onTouchEvent action:" + event.getAction() + ", tag:" + getTag());
        return super.onTouchEvent(event);
    }
}
