package com.wh.finaldemos.demos.customview.testupcoverlayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

/**
 * Created by wanghui5-s on 2015/12/11.
 * <p/>
 * Conclusion:
 * #1:
 */
public class UpCoverLayout extends FrameLayout{

    XLog logger = new XLog(UpCoverLayout.class);

    private final static int STATE_NO_COVERED = 0;
    private final static int STATE_COVERED = 1;
    private final static int STATE_ANIMATING_TO_TARGET_POS = 2;
    private final static int STATE_DRAGGING = 3;

    private View mToCoverView;
    private View mCoverView;
    private View mActionView;

    private int mState = STATE_NO_COVERED;

    private int mTouchSlop;

    private int mInitialDownY;

    private int mLastTouchY;

    private int mDraggingDeltaY;
    private int mDraggingAnchorY;

    private boolean mSupportNestedScroll;

    private NestedScrollViewWrapper mNestedScrollViewWrapper;

    private int mRedefineTopAnchor;
    private int mRedefineTopMostEdge;
    private int mAnimateAnchor;
    private int mAnimatingTopValue;

    public UpCoverLayout(Context context) {
        this(context, null);
    }

    public UpCoverLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UpCoverLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        //mSupportNestedScroll = true;
        logger.d("mTouchSlop:" + mTouchSlop);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mToCoverView = findViewById(R.id.upcover_tocover);
        mCoverView = findViewById(R.id.upcover_cover);
        mActionView = findViewById(R.id.upcover_actionlayout);
        View nestedScrollView = findViewById(R.id.upcover_nested_scrollivew);
        mNestedScrollViewWrapper = new NestedScrollViewWrapper(nestedScrollView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mRedefineTopAnchor = mToCoverView.getMeasuredHeight();
        mRedefineTopMostEdge = mActionView.getMeasuredHeight();
        mAnimateAnchor = mToCoverView.getMeasuredHeight() / 3 * 2;

        // remeasure coverview
        int redefinedCoverViewHeight = mCoverView.getMeasuredHeight();
        if (mState == STATE_NO_COVERED) {
            redefinedCoverViewHeight = getMeasuredHeight() - mRedefineTopAnchor;
        } else if (mState == STATE_COVERED) {
            redefinedCoverViewHeight = getMeasuredHeight() - mRedefineTopMostEdge;
        } else if (mState == STATE_DRAGGING) {
            int rTop = getRedeinedTopWhenDraagging();
            redefinedCoverViewHeight = getMeasuredHeight() - rTop;
        } else if (mState == STATE_ANIMATING_TO_TARGET_POS) {
            redefinedCoverViewHeight = getMeasuredHeight() - mAnimatingTopValue;
        }
        mCoverView.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(redefinedCoverViewHeight, MeasureSpec.EXACTLY));
    }

    private int getRedeinedTopWhenDraagging() {
        int redefinedTop = mDraggingAnchorY + mDraggingDeltaY;
        if (redefinedTop <= mRedefineTopMostEdge) {
            redefinedTop = mRedefineTopMostEdge;
        } else if (redefinedTop >= mRedefineTopAnchor) {
            redefinedTop = mRedefineTopAnchor;
        }
        return redefinedTop;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        int coverLeft = 0; //mCoverView.getLeft();
        int coverRight = getMeasuredWidth(); //mCoverView.getRight();
        if (mState == STATE_NO_COVERED) {
            mActionView.setVisibility(View.GONE);
            int redefineCoverViewLeft = coverLeft;
            int redefineCoverViewTop = mRedefineTopAnchor;
            int redefineCoverViewRight = coverRight;
            int redefineCoverViewBottom = getMeasuredHeight();
            mCoverView.layout(redefineCoverViewLeft, redefineCoverViewTop, redefineCoverViewRight, redefineCoverViewBottom);
        } else if (mState == STATE_COVERED) {
            mActionView.setVisibility(View.VISIBLE);
            mActionView.setAlpha(1f);
            mCoverView.layout(coverLeft, mRedefineTopMostEdge, coverRight, getMeasuredHeight());
        } else if (mState == STATE_DRAGGING) {
            mActionView.setVisibility(View.VISIBLE);
            int redefinedTop = getRedeinedTopWhenDraagging();
            mActionView.setAlpha(1f * ((float)(mRedefineTopAnchor - redefinedTop) / (float)(mRedefineTopAnchor - mRedefineTopMostEdge)));
            mCoverView.layout(coverLeft, redefinedTop, coverRight, getMeasuredHeight());
        } else if (mState == STATE_ANIMATING_TO_TARGET_POS) {
            mActionView.setVisibility(View.VISIBLE);
            mActionView.setAlpha(1f * ((float)(mRedefineTopAnchor - mAnimatingTopValue) / (float)(mRedefineTopAnchor - mRedefineTopMostEdge)));
            mCoverView.layout(coverLeft, mAnimatingTopValue, coverRight, getMeasuredHeight());
        }
        logger.d("layoutx top:" + mCoverView.getTop());
    }

    private boolean isCoverReachToTopEdge() {
        return mCoverView.getTop() == mRedefineTopMostEdge;
    }

    private boolean isCoverStayOriginPos() {
        return mCoverView.getTop() == mRedefineTopAnchor;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        logger.d("onInterceptTouchEvent:" + ev);
        if (mState == STATE_ANIMATING_TO_TARGET_POS) {
            return true;
        }
        int x = (int)ev.getX();
        int y = (int)ev.getY();
        int action = ev.getAction();
        boolean intercepted = false;
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                logger.d("onInterceptTouchEvent ACTION_DOWN y:" + y);
                mInitialDownY = y;
                mLastTouchY = y;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaY = y - mInitialDownY;
                logger.d("onInterceptTouchEvent ACTION_MOVE deltaY:" + deltaY);
                if(mState == STATE_NO_COVERED && Math.abs(deltaY) >= mTouchSlop) {
                    intercepted = true;
                } else if (deltaY > 0 && mState == STATE_COVERED && Math.abs(deltaY) >= mTouchSlop) {
                    boolean canSV = ViewCompat.canScrollVertically(mNestedScrollViewWrapper.getView(), -deltaY);
                    logger.d("onInterceptTouchEvent ACTION_MOVE canSV:" + canSV);
                    if (!canSV) {
                        intercepted = true;
                    }
                }
                break;
            }
            // child call requestDisallowInterceptTouchEvent
            // will cause we can not receive up and cancel
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                logger.d("onInterceptTouchEvent up or cancel y:" + y);
                mInitialDownY = 0;
                break;
            }
        }
        logger.d("onInterceptTouchEvent intercepted:" + intercepted);
        return intercepted;
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (mState != STATE_NO_COVERED) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        logger.d("onTouchEvent:" + event);
        if (mState == STATE_ANIMATING_TO_TARGET_POS) {
            return true;
        }
        int x = (int)event.getX();
        int y = (int)event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                logger.d("onTouchEvent y:" + y);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (mState != STATE_DRAGGING) {
                    if (mState == STATE_COVERED) {
                        mDraggingAnchorY = mRedefineTopMostEdge;
                    } else if (mState == STATE_NO_COVERED) {
                        mDraggingAnchorY = mRedefineTopAnchor;
                    }
                }
                mState = STATE_DRAGGING;

                // nested scroll support
                int deltaY = y - mLastTouchY;
                logger.d("onTouchEvent deltaY:" + deltaY);
                if (mSupportNestedScroll && isCoverReachToTopEdge()) {
                    mNestedScrollViewWrapper.scrollBy(-deltaY);
                }

                mDraggingDeltaY = y - mInitialDownY;
                requestLayout();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                logger.d("onTouchEvent up or cancel y:" + y);
                mInitialDownY = 0;
                if (isCoverReachToTopEdge()) {
                    mState = STATE_COVERED;
                    requestLayout();
                } else if (isCoverStayOriginPos()) {
                    mState = STATE_NO_COVERED;
                    requestLayout();
                } else {
                    mState = STATE_ANIMATING_TO_TARGET_POS;
                    animateToTargetPos();
                }
                break;
            }
        }
        mLastTouchY = y;
        return true;
    }

    private void animateToTargetPos() {
        final int endState = mCoverView.getTop() >= mAnimateAnchor ? STATE_NO_COVERED : STATE_COVERED;
        int targetPos = mCoverView.getTop() >= mAnimateAnchor ? mRedefineTopAnchor : mRedefineTopMostEdge;
        ValueAnimator va = ValueAnimator.ofInt(mCoverView.getTop(), targetPos);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatingTopValue = (int)animation.getAnimatedValue();
                requestLayout();
            }
        });
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mState = endState;
                requestLayout();
            }
        });
        va.start();
    }

    // if we have a nested scroll view(ListView and RecyclerView currently supported)
    // we can continue scroll if we touch the edge
    private class NestedScrollViewWrapper {
        View mWrapperView;

        NestedScrollViewWrapper(View scrollView) {
            mWrapperView = scrollView;
        }

        void scrollBy(int y) {
            if (mWrapperView != null) {
                mWrapperView.scrollBy(0, y);
            }
        }

        View getView() {
            return mWrapperView;
        }
    }
}
