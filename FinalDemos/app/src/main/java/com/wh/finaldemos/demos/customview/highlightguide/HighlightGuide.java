package com.wh.finaldemos.demos.customview.highlightguide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wh.finaldemos.DemoDebug;

/**
 * Created by wanghui5-s on 2016/5/26.
 * <p/>
 * Conclusion:
 * #1:
 */
public class HighlightGuide extends FrameLayout{

    public final static int ANCHOR_TOP = 0;
    public final static int ANCHOR_BOTTOM = 1;
    public final static int ANCHOR_AUTO = 2;

    private Paint mPaint;

    private View mGuideTextView;

    private int mAnchorTo = ANCHOR_AUTO;

    private int mOffsetX;
    private int mOffsetY;

    public interface HighlightGuideInfoProvider {
        public RectF getInfo();
        public View getGuideTextView();
    }

    public interface HighlightGuideHost {

        // call when measured
        public void setAnchorView(View view);

        public void onGuideHide();
    }

    private HighlightGuideInfoProvider mInfoProvider;

    private HighlightGuideHost mHost;

    public HighlightGuide(Context context) {
        super(context);
        init();
    }

    public HighlightGuide(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        mPaint = new Paint();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setClickable(true);
    }

    public void setAnchorTo(int anchorTo) {
        mAnchorTo = anchorTo;
    }

    public void setOffsetXY(int ox, int oy) {
        mOffsetX = ox;
        mOffsetY = oy;
    }

    public void setHighlightGuideInfoProvider(HighlightGuideInfoProvider provider) {
        mInfoProvider = provider;
    }

    public void setHighlightGuideHost(HighlightGuideHost host) {
        mHost = host;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DemoDebug.log("HighlightGuide onDraw");

        if (mInfoProvider != null && mInfoProvider.getInfo() != null) {
            DemoDebug.log("HighlightGuide onDraw rect:" + mInfoProvider.getInfo());
            canvas.save();
            canvas.drawColor(Color.parseColor("#7F000000"));
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawRoundRect(mInfoProvider.getInfo(), 10f, 10f, mPaint);
            mPaint.setXfermode(null);
            canvas.restore();
            if ((mGuideTextView == null && mInfoProvider.getGuideTextView() != null)) {
                mGuideTextView = mInfoProvider.getGuideTextView();
                addGuideTextView();
            }
        }
    }

    private void addGuideTextView() {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.addView(mGuideTextView, lp);
// TODO
//        if (mAnchorTo == ANCHOR_TOP) {
//
//        } else if (mAnchorTo == ANCHOR_BOTTOM) {
//
//        } else {
//            RectF guideTargetRectF = mInfoProvider.getInfo();
//            if (guideTargetRectF.top > getMeasuredHeight() / 2) {
//
//            } else {
//
//            }
//        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (mGuideTextView != null) {
            RectF guideTargetRectF = mInfoProvider.getInfo();
            int x = (int)guideTargetRectF.left + mOffsetX;
            int y = (int)(guideTargetRectF.top - mGuideTextView.getMeasuredHeight()) + mOffsetY;
            int r = (int)(x + mGuideTextView.getMeasuredWidth());
            int b = (int)guideTargetRectF.top + mOffsetY;
            mGuideTextView.layout(x, y, r,
                    b);
            DemoDebug.log("HighlightGuide onLayout X:" + mGuideTextView.getLeft() + ", Y:" + mGuideTextView.getTop() + ", mh:" + mGuideTextView.getMeasuredHeight());
        }
    }

    private void setTop() {
        RectF guideTargetRectF = mInfoProvider.getInfo();
    }

    private void setBottom() {
        RectF guideTargetRectF = mInfoProvider.getInfo();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.getVisibility() == View.VISIBLE) {
            this.setVisibility(View.GONE);
            if (mHost != null) {
                mHost.onGuideHide();
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
