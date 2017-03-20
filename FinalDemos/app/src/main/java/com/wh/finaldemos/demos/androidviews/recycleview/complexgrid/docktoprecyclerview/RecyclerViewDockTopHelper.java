package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktoprecyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by wanghui on 17-3-20.
 */

public class RecyclerViewDockTopHelper {

    private boolean mDockTopEnabled = false;

    private FrameLayout mDockItemViewWrapper;

    private IDockTopRecyclerViewAdapterContract mIDockTopRecyclerViewAdapter;

    private RecyclerView mRecyclerView;

    public RecyclerViewDockTopHelper(RecyclerView recyclerView, IDockTopRecyclerViewAdapterContract iDockTopRecyclerViewAdapter) {
        mRecyclerView = recyclerView;
        if (!(iDockTopRecyclerViewAdapter instanceof RecyclerView.Adapter)) {
            throw new IllegalArgumentException("Need adapter to be RecyclerView.Adapter type");
        }
        mIDockTopRecyclerViewAdapter = iDockTopRecyclerViewAdapter;
        init();
    }

    public void setDockItemViewWrapper(FrameLayout wrapper) {
        mDockTopEnabled = true;
        mDockItemViewWrapper = wrapper;
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
        mDockItemViewWrapper.setTag(RecyclerView.NO_POSITION);
    }

    public View getDockViewWrapper() {
        return mDockItemViewWrapper;
    }

    public void setDockTopEnabled(boolean enabled) {
        mDockTopEnabled = enabled;
    }

    private void init() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //Log.e("DockItemRecyclerView", "onScrollStateChanged newState:" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //Log.e("DockItemRecyclerView", "onScrolled dy:" + dy);
                if (mDockTopEnabled) {
                    if (((RecyclerView.Adapter)mIDockTopRecyclerViewAdapter).getItemCount() > 0) {
                        recyclerView.post(new Runnable() {
                            @Override
                            public void run() {
                                checkAndFixDock();
                            }
                        });
                    }
                }
            }
        });
    }


    public void forceCheckAndFixDock() {
        if (mDockItemViewWrapper != null) {
            mDockItemViewWrapper.setTag(null);
            checkAndFixDock();
        }
    }

    public void checkAndFixDock() {
        int topItemPos = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (topItemPos < 0 || ((RecyclerView.Adapter)mIDockTopRecyclerViewAdapter).getItemCount() <= topItemPos) {
            return;
        }
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, onScrolled checkAndFixDock topItemPos:" + topItemPos);
        if (mIDockTopRecyclerViewAdapter.isDockItemAtPosition(topItemPos)) {
            showDockForItem(topItemPos);
            fixPosByNextDockItem(topItemPos);
        } else {
            int currentDockPos = mIDockTopRecyclerViewAdapter.findCurrentDockItemPositionInclude(topItemPos);
            if (currentDockPos >= 0) {
                showDockForItem(currentDockPos);
                fixPosByNextDockItem(topItemPos);
            } else {
                // view is not ready
            }
        }
    }

    private void showDockForItem(int pos) {
        if (mDockItemViewWrapper.getVisibility() == View.VISIBLE) {
            if (mDockItemViewWrapper.getTag() != null) {
                int showingPos = (Integer) mDockItemViewWrapper.getTag();
                if (showingPos == pos) {
                    // is showing right and current dock item
                    mDockItemViewWrapper.setY(0);
                    Log.e("DockTopRecyclerView", "VISIBLE DockItemRecyclerView, showDockForItem pos:" + pos + ", and is SHOWING, " + mDockItemViewWrapper.getChildCount());
                    // do not return for refresh dock item ui; fix bug button states not match
                    //return;
                } else {
                    // is showing invaid dock item
                    // update
                    // do showDockForItem
                }
            } else {
                // visible but withou tag?
                // should not reach here
            }
        } else {
            // do showDockForItem
            if (mDockItemViewWrapper.getTag() != null) {
                int showingPos = (Integer) mDockItemViewWrapper.getTag();
                if (showingPos == pos) {
                    // is showing right and current collapsable item
                    mDockItemViewWrapper.setY(0);
                    mDockItemViewWrapper.setVisibility(View.VISIBLE);
                    Log.e("DockTopRecyclerView", "DockItemRecyclerView, showDockForItem pos:" + pos + ", and is TURN SHOWING, " + mDockItemViewWrapper.getChildCount());
                    // do not return for refresh dock item ui; fix bug button states not match
                    //return;
                } else {
                    // need create and add view
                }
            } else {
                // need create and add view
            }
        }
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, showDockForItem pos:" + pos + ", and add view");
        final RecyclerView.ViewHolder vh = mIDockTopRecyclerViewAdapter.onCreateDockForPosition(mDockItemViewWrapper, pos);
        ((RecyclerView.Adapter)mIDockTopRecyclerViewAdapter).onBindViewHolder(vh, pos);
        mDockItemViewWrapper.setVisibility(View.VISIBLE);
        mDockItemViewWrapper.removeAllViews();
        mDockItemViewWrapper.setY(0);
        mDockItemViewWrapper.setTag(pos);
        ViewGroup.LayoutParams dockLp = vh.itemView.getLayoutParams();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(dockLp.width, dockLp.height);
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, showDockForItem pos:" + pos + ", and add view width:" + dockLp.width + ", height:" + dockLp.height);
        mDockItemViewWrapper.addView(vh.itemView, lp);
        mDockItemViewWrapper.setBackgroundDrawable(vh.itemView.getBackground());
        mDockItemViewWrapper.post(new Runnable() {
            @Override
            public void run() {
                mDockItemViewWrapper.requestLayout();
            }
        });
        mIDockTopRecyclerViewAdapter.onBindDockViewHolder(vh);
    }

    private void fixPosByNextDockItem(int currentPos) {
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextDockItem currentPos:" + currentPos);
        int dockViewBottom = mDockItemViewWrapper.getTop() + mDockItemViewWrapper.getMeasuredHeight();
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        int nextDockItemPos = mIDockTopRecyclerViewAdapter.findNextDockItemPositionExclude(currentPos);
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextDockItem currentPos:" + currentPos + ", nextDockItemPos:" + nextDockItemPos + ", currentY:" + mDockItemViewWrapper.getY() + ", dockViewBottom:" + dockViewBottom);
        if (nextDockItemPos != RecyclerView.NO_POSITION) {
            View nextCollapsableItemView = layoutManager.findViewByPosition(nextDockItemPos);
            if (nextCollapsableItemView != null) {
                if (nextCollapsableItemView.getY() <= dockViewBottom) {
                    mDockItemViewWrapper.setY(nextCollapsableItemView.getY() - dockViewBottom);
                    Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextDockItem currentPos:" + currentPos + ", toY:" + mDockItemViewWrapper.getY());
                } else {
                    mDockItemViewWrapper.setY(0);
                }
            } else {
                mDockItemViewWrapper.setY(0);
            }
        } else {
            mDockItemViewWrapper.setY(0);
        }
    }

    private void hideDock() {
        mDockItemViewWrapper.setY(0);
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
    }

}
