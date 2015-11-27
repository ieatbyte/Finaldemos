package com.whlib.alib.widget;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by wanghui5-s on 2015/11/26.
 */
public class CircelImageView extends CustomShapeImageView {

    public CircelImageView(Context context) {
        super(context);
    }

    public CircelImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircelImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        this.setBuildPathCallbackAfterMeasure(new CustomShapeImageView.BuildPathCallbackAfterMeasure() {

            RectF rectF = new RectF();

            @Override
            public void buildPath(Path path) {
                rectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
                path.addRoundRect(rectF, getMeasuredWidth() / 2, getMeasuredHeight() / 2, Path.Direction.CW);
            }
        });
    }
}
