package com.wh.finaldemos.demos.androidviews.recycleview.checkreachtargetviewborder;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewScrollReachChecker {

    private RecyclerView mListView;

    private Rect mTmpRect;

    private ViewGroup mListItemView;

    private View mTargetView;

    public interface Callback {

        void onFirstTargetCompletelyShow(View listItemView, View targetView);

        void onTargetViewReachTopMost();

        void onTargetViewReachBottomMost();
    }

    private Callback mCallback;

    public RecyclerViewScrollReachChecker(RecyclerView listView, Callback callback) {
        this(listView);
        mCallback = callback;
    }

    public RecyclerViewScrollReachChecker(RecyclerView listView) {
        mTmpRect = new Rect();
        mListView = listView;
        mListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (isEnableScrollCheck()) {
                        findFirstTargetCompletelyShow();
                    }
                } else {
                    // do nothing
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isEnableScrollCheck() && mListItemView != null && mTargetView != null) {
                    // not detached
                    if (mListItemView.getParent() != null) {
                        mTmpRect.setEmpty();
                        mTargetView.getDrawingRect(mTmpRect);
                        mListItemView.offsetDescendantRectToMyCoords(mTargetView, mTmpRect);
                        Log.e("", "onScrolled offsetDescendantRectToMyCoords drawing rect:" + mTmpRect);
                        int videoTopY = (int) mListItemView.getY() + mTmpRect.top;
                        int videoBottomY = videoTopY + mTmpRect.height();
                        Log.e("", "getBottomAnchorY:" + getBottomAnchorY()
                                + ", getTopAnchorY:" + getTopAnchorY()
                                + ", videoTopY:" + videoTopY
                                + ", videoBottomY:" + videoBottomY
                                + ", mTmpRect.height:" + mTmpRect.height());
                        if (videoTopY < getTopAnchorY()) {
                            if (mCallback != null) {
                                Log.e("", "onTargetViewReachTopMost");
                                mCallback.onTargetViewReachTopMost();
                            }
                        }
                        if (videoBottomY > getBottomAnchorY()) {
                            Log.e("", "onTargetViewReachBottomMost");
                            mCallback.onTargetViewReachBottomMost();
                        }
                    } else {
                        // do nothing
                    }
                } else {
                    // detached
                }
            }
        });
    }

    public void startTrack(ViewGroup listItemView, View targetView) {
        mListItemView = listItemView;
        mTargetView = targetView;
    }

    private void findFirstTargetCompletelyShow() {
        View itemView = null;
        LinearLayoutManager llManager = (LinearLayoutManager) mListView.getLayoutManager();
        int firstVisPos = llManager.findFirstVisibleItemPosition();
        int lastVisPos = llManager.findLastVisibleItemPosition();
        for (int i = firstVisPos; i <= lastVisPos; ++i) {
            itemView = llManager.findViewByPosition(i);
            if (itemView != null && itemView instanceof ViewGroup) {
                View targetView = getTargetViewInListItemView((ViewGroup)itemView);
                if (targetView != null) {
                    if (checkIsTargetViewCompletelyShowing((ViewGroup)itemView, targetView) && mCallback != null) {
                        Log.e("", "findFirstTargetCompletelyShow: GOT targetView:" + targetView);
                        mCallback.onFirstTargetCompletelyShow(itemView, targetView);
                        break;
                    } else {
                        Log.e("", "findFirstTargetCompletelyShow: target view is NOT completely showing");
                        continue;
                    }
                } else {
                    Log.e("", "findFirstTargetCompletelyShow: target view is null");
                    continue;
                }
            } else {
                Log.e("", "findFirstTargetCompletelyShow: item view is null");
                continue;
            }
        }
    }

    // for findFirstTargetCompletelyShow
    private boolean checkIsTargetViewCompletelyShowing(ViewGroup listItemView, View targetView) {
        boolean result = false;
        mTmpRect.setEmpty();
        targetView.getDrawingRect(mTmpRect);
        listItemView.offsetDescendantRectToMyCoords(targetView, mTmpRect);
        int videoTopY = (int) targetView.getY() + mTmpRect.top;
        int videoBottomY = videoTopY + mTmpRect.height();
        int topAnchorY = getTopAnchorY();
        if (videoTopY > topAnchorY && videoBottomY < getBottomAnchorY()) {
            result = true;
        }
        Log.e("", "findFirstTargetCompletelyShow: checkIsTargetViewCompletelyShowing result:" + result + ", videoTopY:" + videoTopY + ", videoBottomY:" + videoBottomY + ", topAnchorY:" + topAnchorY + ", mh:" + getBottomAnchorY());
        return result;
    }

    protected View getTargetViewInListItemView(ViewGroup listItemView) {
        return listItemView;
    }

    protected int getTopAnchorY() {
        return 0;
    }

    protected int getBottomAnchorY() {
        return mListView.getMeasuredHeight();
    }

    protected boolean isEnableScrollCheck() {
        return true;
    }
}
