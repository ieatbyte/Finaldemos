package com.whlib.alib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by wanghui5-s on 2015/11/26.
 */
public class CustomShapeImageView extends ImageView {

    private Paint mPaint;
    private Path mPath;
    private RectF mBitmapRectF;
    private Xfermode mXfermodeSrcIn;
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private BuildPathCallbackAfterMeasure mBuildPathCallbackAfterMeasure;

    public CustomShapeImageView(Context context) {
        super(context);
        init();
    }

    public CustomShapeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomShapeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        this.setScaleType(ScaleType.CENTER_CROP);
        mXfermodeSrcIn = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
                | Paint.FILTER_BITMAP_FLAG);
        mBitmapRectF = new RectF();
        mPath = new Path();
    }

    public interface BuildPathCallbackAfterMeasure {
        void buildPath(Path path);
    }

    public void setBuildPathCallbackAfterMeasure(BuildPathCallbackAfterMeasure callbackAfterMeasure) {
        mBuildPathCallbackAfterMeasure = callbackAfterMeasure;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mBitmapRectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        mPath.reset();
        if (mBuildPathCallbackAfterMeasure != null) {
            mBuildPathCallbackAfterMeasure.buildPath(mPath);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null
                || !(getDrawable() instanceof BitmapDrawable)
                || ((BitmapDrawable)getDrawable()).getBitmap() == null) {
            super.onDraw(canvas);
            return;
        }
        canvas.setDrawFilter(mPaintFlagsDrawFilter);
        if (!mPath.isEmpty()) {
            canvas.saveLayer(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
            mPaint.setColor(Color.WHITE);
            canvas.drawPath(mPath, mPaint);
            mPaint.setXfermode(mXfermodeSrcIn);
        }
        if (getImageMatrix() == null) {
            canvas.drawBitmap(((BitmapDrawable)getDrawable()).getBitmap(), null, mBitmapRectF, mPaint);
        } else {
            canvas.drawBitmap(((BitmapDrawable) getDrawable()).getBitmap(), getImageMatrix(), mPaint);
        }
        if (mPath.isEmpty()) {
            canvas.restore();
        }
        mPaint.reset();
    }
}
