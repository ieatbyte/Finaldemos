package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.docktop;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class DockTopRecyclerView extends RecyclerView {

    private boolean mDockTopEnabled = false;

    private FrameLayout mDockItemViewWrapper;

    private IDockTopRecyclerViewAdapter mIDockTopRecyclerViewAdapter;

    public DockTopRecyclerView(Context context) {
        super(context);
        init();
    }

    public DockTopRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.addOnScrollListener(new OnScrollListener() {
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
                    if (getAdapter().getItemCount() > 0) {
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

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof IDockTopRecyclerViewAdapter) {
            mIDockTopRecyclerViewAdapter = (IDockTopRecyclerViewAdapter) adapter;
        } else {
            throw new IllegalArgumentException("Need adapter to be IDockTopRecyclerViewAdapter type");
        }
    }

    public void setDockItemViewWrapper(FrameLayout wrapper) {
        mDockTopEnabled = true;
        mDockItemViewWrapper = wrapper;
        // initial
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
        mDockItemViewWrapper.setTag(-1);
    }

    public void setFNDockItemViewWrapper(FrameLayout wrapper) {
        mDockTopEnabled = true;
        mDockItemViewWrapper = wrapper;

        // initial
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
        mDockItemViewWrapper.setTag(-1);
    }

    public View getDockView() {
        return mDockItemViewWrapper;
    }

    public void setDockTopEnabled(boolean enabled) {
        mDockTopEnabled = enabled;
    }

    private void showDockForItem(int pos) {
        if (mDockItemViewWrapper.getVisibility() == VISIBLE) {
            if (mDockItemViewWrapper.getTag() != null) {
                int showingPos = (Integer) mDockItemViewWrapper.getTag();
                if (showingPos == pos) {
                    // is showing right and current collapsable item
                    mDockItemViewWrapper.setY(0);
                    Log.e("DockTopRecyclerView", "DockItemRecyclerView, showDockForItem pos:" + pos + ", and is SHOWING" + mDockItemViewWrapper.getChildCount());
                    // do not return for refresh dock item ui; fix bug button states not match
                    //return;
                } else {
                    // is showing invaidcollapsable item
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
                    Log.e("DockTopRecyclerView", "DockItemRecyclerView, showDockForItem pos:" + pos + ", and is TURN SHOWING" + mDockItemViewWrapper.getChildCount());
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
        //final ViewHolder vh = getAdapter().onCreateViewHolder(mDockItemViewWrapper, FNExpandableRVAdapter.VIEW_TYPE_EXPANDABLE_DAY);
        final ViewHolder vh = mIDockTopRecyclerViewAdapter.onCreateDockForPos(mDockItemViewWrapper, pos);
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
//        if (vh instanceof FNExpandableRVAdapter.ExpandableDayItemViewHolder) {
//            final ImageButton imgBut = (ImageButton) vh.itemView.findViewById(R.id.filter_menu_but);
//            imgBut.setVisibility(View.VISIBLE);
//            View dayZone = vh.itemView.findViewById(R.id.day_zone);
//            dayZone.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mFNListWrapper != null) {
//                        imgBut.setScaleY(imgBut.getScaleY() == 1 ? -1 : 1);
//                        mFNListWrapper.showDayPicker(vh.itemView);
//                    }
//                }
//            });
//        }
        mIDockTopRecyclerViewAdapter.onBindDockViewHolder(vh);
    }

    private void hideDock() {
        mDockItemViewWrapper.setY(0);
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
    }

    private void fixPosByNextCollapsable(int currentPos) {
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextCollapsable currentPos:" + currentPos);
        int dockViewBottom = mDockItemViewWrapper.getTop() + mDockItemViewWrapper.getMeasuredHeight();
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        int nextCollapsableItemPos = mIDockTopRecyclerViewAdapter.findNextDockItemPosExclude(currentPos);
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextCollapsable currentPos:" + currentPos + ", nextCollapsableItemPos:" + nextCollapsableItemPos + ", currentY:" + mDockItemViewWrapper.getY() + ", dockViewBottom:" + dockViewBottom);
        if (nextCollapsableItemPos != NO_POSITION) {
            View nextCollapsableItemView = layoutManager.findViewByPosition(nextCollapsableItemPos);
            if (nextCollapsableItemView != null) {
                if (nextCollapsableItemView.getY() <= dockViewBottom) {
                    mDockItemViewWrapper.setY(nextCollapsableItemView.getY() - dockViewBottom);
                    Log.e("DockTopRecyclerView", "DockItemRecyclerView, fixPosByNextCollapsable currentPos:" + currentPos + ", toY:" + mDockItemViewWrapper.getY());
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

    public void forceCheckAndFixDock() {
        if (mDockItemViewWrapper != null) {
            mDockItemViewWrapper.setTag(null);
            checkAndFixDock();
        }
    }

    public void checkAndFixDock() {
        int topItemPos = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        if (topItemPos < 0 || getAdapter().getItemCount() <= topItemPos) {
            return;
        }
        Log.e("DockTopRecyclerView", "DockItemRecyclerView, onScrolled checkAndFixDock topItemPos:" + topItemPos);

        // if top item changed and is collapsable item
        if (mIDockTopRecyclerViewAdapter.isDockAtPos(topItemPos)) {
                showDockForItem(topItemPos);
                fixPosByNextCollapsable(topItemPos);
        } else {
            // is collapsed item
            // top is collapsed, next is collapsable item, dock to this collapsed item y
            int prevCollapsablePos = mIDockTopRecyclerViewAdapter.findCurrentDockItemPosInclude(topItemPos);
            if (prevCollapsablePos >= 0) {
                showDockForItem(prevCollapsablePos);
                fixPosByNextCollapsable(topItemPos);
            } else {
                // view is not ready
            }
        }
    }
}
