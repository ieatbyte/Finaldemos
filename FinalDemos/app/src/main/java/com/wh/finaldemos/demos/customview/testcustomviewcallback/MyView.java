package com.wh.finaldemos.demos.customview.testcustomviewcallback;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class MyView extends View {

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                TestCustomViewCallbackDemo.logger.d("onPreDraw");
                getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TestCustomViewCallbackDemo.logger.d("onDraw");
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        TestCustomViewCallbackDemo.logger.d("dispatchDraw");
        super.dispatchDraw(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        TestCustomViewCallbackDemo.logger.d("draw");
        super.draw(canvas);
    }


}
