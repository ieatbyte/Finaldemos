package com.whlib.alib.widget;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by wanghui5-s on 2015/11/26.
 * <p/>
 * Conclusion:
 * #1:
 */
public class RoundRectImageView extends CustomShapeImageView {

    private final static float DEFAULT_RX = 10;
    private final static float DEFAULT_RY = 10;

    private float rx;
    private float ry;

    public RoundRectImageView(Context context) {
        super(context);
    }

    public RoundRectImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        rx = DEFAULT_RX;
        ry = DEFAULT_RY;
        this.setBuildPathCallbackAfterMeasure(new CustomShapeImageView.BuildPathCallbackAfterMeasure() {

            RectF rectF = new RectF();

            @Override
            public void buildPath(Path path) {
                rectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
                path.addRoundRect(rectF, rx, ry, Path.Direction.CW);
            }
        });
    }

    public float getRx() {
        return rx;
    }

    public void setRx(float rx) {
        this.rx = rx;
    }

    public float getRy() {
        return ry;
    }

    public void setRy(float ry) {
        this.ry = ry;
    }

    public void setRxRy(float rx, float ry) {
        this.rx = rx;
        this.ry = ry;
    }
}
