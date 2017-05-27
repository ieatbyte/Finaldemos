package com.wh.finaldemos.demos.customview.highlightguide;

import android.content.Context;
import android.graphics.Bitmap;
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

// TODO:
//  1. multiple targets
//  2. NOT in post delayed runnable show
public class HighlightGuideV2 extends FrameLayout {

    private Paint mPaint;

    private View mGuideContentView;

    private View mGuideTargetStubView;

    private View mContentRootView;

    private View mGuideTargetView;

    private Bitmap mBitmap;

    private Canvas mBitmapCanvas;

    private int mLastMeasuredWidth;

    private int mLastMeasuredHeight;

    private RectF mTargetRectF = new RectF();

    public interface HighlightGuideV2Host {

        public void onGuideHide();

    }

    private HighlightGuideV2Host mHost;

    public HighlightGuideV2(Context context) {
        super(context);
        init();
    }

    public HighlightGuideV2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        mPaint = new Paint();
        setClickable(true);
        setVisibility(View.GONE);
    }

    public void setHighlightGuideHost(HighlightGuideV2Host host) {
        mHost = host;
    }

    public void setAnchorView(View contentRootView, View anchorView) {
        mContentRootView = contentRootView;
        mGuideTargetView = anchorView;
    }

    public void show() {
        setVisibility(View.VISIBLE);
        invalidate();
        requestLayout();
    }

//        <x.highlightguide.HighlightGuideV2
//    android:id="@+id/h_guide_v2"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent">
//
//        <LinearLayout
//    android:id="@+id/guide_content"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:orientation="vertical">
//
//            <ImageView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:src="@drawable/smart_push_guide_text"
//    android:layout_gravity="center_horizontal"/>
//
//            <View
//    android:id="@+id/guide_target_stub"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"/>
//
//            <ImageView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:src="@drawable/util_ok_guide"
//    android:layout_gravity="center_horizontal"
//    android:layout_marginTop="20dp"/>
//        </LinearLayout>
//    </x.highlightguide.HighlightGuideV2>

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        boolean needRelayout = false;
        if (mGuideTargetStubView == null) {
            mGuideTargetStubView = null;//TODO //findViewById(R.id.guide_target_stub);
        }
        if (mGuideContentView == null) {
            mGuideContentView = null; // TODO findViewById(R.id.guide_content);
        }
        if (mGuideTargetView != null) {
            ViewGroup.LayoutParams lp = mGuideTargetStubView.getLayoutParams();
            if (lp.height != mGuideTargetView.getMeasuredHeight()) {
                lp.height = mGuideTargetView.getMeasuredHeight();
                needRelayout = true;
            }
            if (lp.width != mGuideTargetView.getMeasuredWidth()) {
                lp.width = mGuideTargetView.getMeasuredWidth();
                needRelayout = true;
            }
        }
        if (mLastMeasuredWidth != getMeasuredWidth() || mLastMeasuredHeight != getMeasuredHeight()) {
            mBitmap = Bitmap.createBitmap(getMeasuredWidth() > 0 ? getMeasuredWidth() : 1, getMeasuredHeight() > 0 ? getMeasuredHeight() : 1, Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mBitmap);
        }
        mLastMeasuredWidth = getMeasuredWidth();
        mLastMeasuredHeight = getMeasuredHeight();
        if (needRelayout) {
            post(new Runnable() {
                @Override
                public void run() {
                    requestLayout();
                }
            });
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mGuideTargetView != null && mContentRootView != null) {
            int[] loc = new int[2];
            mGuideTargetView.getLocationOnScreen(loc);
            int[] parentloc = new int[2];
            mContentRootView.getLocationOnScreen(parentloc);
            int x = loc[0] - parentloc[0];
            int y = loc[1] - parentloc[1];
            mTargetRectF.set(x, y, x + mGuideTargetView.getMeasuredWidth(), y + mGuideTargetView.getMeasuredHeight());
        }

        canvas.save();

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(getMeasuredWidth() > 0 ? getMeasuredWidth() : 1, getMeasuredHeight() > 0 ? getMeasuredHeight() : 1, Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mBitmap);
        }

        mBitmap.eraseColor(Color.TRANSPARENT);
        mBitmapCanvas.drawColor(Color.parseColor("#9F000000"));
        mBitmapCanvas.drawRoundRect(mTargetRectF, 10f, 10f, mPaint);
        canvas.drawBitmap(mBitmap, 0, 0, null);

        mPaint.setXfermode(null);
        canvas.restore();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (mGuideTargetView != null) {
            int[] loc = new int[2];
            mGuideTargetView.getLocationOnScreen(loc);
            int[] targetStubloc = new int[2];
            mGuideTargetStubView.getLocationOnScreen(targetStubloc);
            int x = loc[0] - targetStubloc[0];
            int y = loc[1] - targetStubloc[1];
            mGuideContentView.layout(x, y, x + mGuideContentView.getMeasuredWidth(), y + mGuideContentView.getMeasuredHeight());
        }
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
