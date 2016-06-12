package com.wh.finaldemos.demos.androidviews.RecycleView.collapsable;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wh.finaldemos.Item;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class DockItemRecyclerView extends RecyclerView {

    private FrameLayout mDockItemViewWrapper;

    public DockItemRecyclerView(Context context) {
        super(context);
        init();
    }

    public DockItemRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void showDockForItem(int pos) {
        if (mDockItemViewWrapper.getVisibility() == VISIBLE) {
            if (mDockItemViewWrapper.getTag() != null) {
                int showingPos = (Integer) mDockItemViewWrapper.getTag();
                if (showingPos == pos) {
                    // is showing right and current collapsable item
                    mDockItemViewWrapper.setY(0);
                    Log.e("DockItemRecyclerView", "showDockForItem pos:" + pos + ", and is SHOWING" + mDockItemViewWrapper.getChildCount());
                    return;
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
        }
        Log.e("DockItemRecyclerView", "showDockForItem pos:" + pos + ", and add view");
        ViewHolder vh = getAdapter().onCreateViewHolder(mDockItemViewWrapper, DemoCollapsableRVAdapter.VIEW_TYPE_COLLAPSABLE);
        getAdapter().onBindViewHolder(vh, pos);
        mDockItemViewWrapper.setVisibility(View.VISIBLE);
        mDockItemViewWrapper.removeAllViews();
        mDockItemViewWrapper.setY(0);
        mDockItemViewWrapper.setTag(pos);
        ViewGroup.LayoutParams dockLp = vh.itemView.getLayoutParams();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(dockLp.width, dockLp.height);
        Log.e("DockItemRecyclerView", "showDockForItem pos:" + pos + ", and add view width:" + dockLp.width + ", height:" + dockLp.height);
        mDockItemViewWrapper.addView(vh.itemView, lp);
        mDockItemViewWrapper.setBackgroundDrawable(vh.itemView.getBackground());
        mDockItemViewWrapper.post(new Runnable() {
            @Override
            public void run() {
                mDockItemViewWrapper.requestLayout();
            }
        });
    }

    private void hideDock() {
        mDockItemViewWrapper.setY(0);
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
    }

    private void fixPosByNextCollapsable(int currentPos) {
        Log.e("DockItemRecyclerView", "fixPosByNextCollapsable currentPos:" + currentPos);
        int dockViewBottom = mDockItemViewWrapper.getTop() + mDockItemViewWrapper.getMeasuredHeight();
        DemoCollapsableRVAdapter adapter = (DemoCollapsableRVAdapter) getAdapter();
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        int nextCollapsableItemPos = adapter.findNextCollapsableItemPos(currentPos);
        Log.e("DockItemRecyclerView", "fixPosByNextCollapsable currentPos:" + currentPos + ", nextCollapsableItemPos:" + nextCollapsableItemPos + ", currentY:" + mDockItemViewWrapper.getY() + ", dockViewBottom:" + dockViewBottom);
        if (nextCollapsableItemPos != NO_POSITION) {
            View nextCollapsableItemView = layoutManager.findViewByPosition(nextCollapsableItemPos);
            if (nextCollapsableItemView != null) {
                if (nextCollapsableItemView.getY() <= dockViewBottom) {
                    mDockItemViewWrapper.setY(nextCollapsableItemView.getY() - dockViewBottom);
                    Log.e("DockItemRecyclerView", "fixPosByNextCollapsable currentPos:" + currentPos + ", toY:" + mDockItemViewWrapper.getY());
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

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        DemoCollapsableRVAdapter realAdapter = (DemoCollapsableRVAdapter) adapter;
        realAdapter.setCallback(new CollapsableRVAdapter.Callback() {
            @Override
            public void onExpand(CollapsableItem ci) {
                checkAndFixDock();
            }

            @Override
            public void onPreCollapse(CollapsableItem ci, int pos) {
//                int topItemPos = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
//                int prevCollapsablePos = ((DemoCollapsableRVAdapter)getAdapter()).findPreviousCollapsableItemPos(topItemPos);
                if (mDockItemViewWrapper.getVisibility() == View.VISIBLE) {
                    int showingPos = (int)mDockItemViewWrapper.getTag();
                    if (showingPos == pos) {
                        DockItemRecyclerView.this.scrollToPosition(pos);
                        Log.e("DockItemRecyclerView", "onCollapse scrollToPosition:" + pos);
                    }
                }
            }

            @Override
            public void onCollapse(CollapsableItem ci) {
                checkAndFixDock();
            }
        });
    }

    private void init() {
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("DockItemRecyclerView", "onScrollStateChanged newState:" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("DockItemRecyclerView", "onScrolled dy:" + dy);
                checkAndFixDock();
            }
        });
    }

    private void checkAndFixDock() {
        int topItemPos = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        int topItemType = getAdapter().getItemViewType(topItemPos);
        DemoCollapsableRVAdapter adapter = (DemoCollapsableRVAdapter) getAdapter();
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        Log.e("DockItemRecyclerView", "onScrolled topItemPos:" + topItemPos);

        // if top item changed and is collapsable item
        if (topItemType == DemoCollapsableRVAdapter.VIEW_TYPE_COLLAPSABLE) {
            Item topitem = ((DemoCollapsableRVAdapter) getAdapter()).getItemAtPos(topItemPos);
            if (topitem instanceof CollapsableItem) {
                if (((CollapsableItem) topitem).expanded
                        && ((CollapsableItem) topitem).getSubItems() != null
                        && ((CollapsableItem) topitem).getSubItems().size() > 0) {
                    View topCollapsableItemView = layoutManager.findViewByPosition(topItemPos);
                    if (topCollapsableItemView.getY() != 0) {
                        showDockForItem(topItemPos);
                        fixPosByNextCollapsable(topItemPos);
                    } else {
                        hideDock();
                    }
                } else {
                    // if top is collapsable item or not expanded or no subitems
                    // dock view should hide
                    hideDock();
                }
            } else {
                // type is VIEW_TYPE_COLLAPSABLE but is not CollapsableItem
                // should not reach here
            }
        } else {
            // is collapsed item
            // top is collapsed, next is collapsable item, dock to this collapsed item y
            int prevCollapsablePos = adapter.findPreviousCollapsableItemPos(topItemPos);
            showDockForItem(prevCollapsablePos);
            fixPosByNextCollapsable(topItemPos);
        }
    }

    public void setDockItemViewWrapper(FrameLayout wrapper) {
        mDockItemViewWrapper = wrapper;

        // initial
        mDockItemViewWrapper.setVisibility(View.INVISIBLE);
        mDockItemViewWrapper.setTag(-1);
    }


}
