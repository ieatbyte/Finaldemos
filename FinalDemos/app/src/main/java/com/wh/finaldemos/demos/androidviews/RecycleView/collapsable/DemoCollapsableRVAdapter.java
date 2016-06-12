package com.wh.finaldemos.demos.androidviews.RecycleView.collapsable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wh.finaldemos.Item;
import com.wh.finaldemos.R;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/6/6.
 * <p/>
 * Conclusion:
 * #1:
 */
public class DemoCollapsableRVAdapter extends CollapsableRVAdapter{

    public final static int VIEW_TYPE_COLLAPSABLE = 0;
    public final static int VIEW_TYPE_COLLAPSED_TEXT = 1;
    public final static int VIEW_TYPE_COLLAPSED_IMAGE = 2;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Item item = mData.get(position);
        if (holder instanceof CollapsableItemViewHolder) {
            final DemoCollapsableItem realItem = (DemoCollapsableItem)item;
            ((CollapsableItemViewHolder) holder).titleView.setText("DemoCollapsableItem" + position + ", " + realItem.title + ", expanded:" + realItem.expanded);
            ((CollapsableItemViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (realItem.expanded) {
                        collapseItem(realItem);
                    } else {
                        expandItem(realItem);
                    }
                }
            });
        } else if (holder instanceof CollapsedTextItemViewHolder) {
            DemoCollapsedItemText realItem = (DemoCollapsedItemText)item;
            ((CollapsedTextItemViewHolder) holder).titleView.setText("DemoCollapsedItemText" + position + ", " + realItem.title);
        } else if (holder instanceof CollapsedImageItemViewHolder) {
            DemoCollapsedItemImage realItem = (DemoCollapsedItemImage)item;
            ((CollapsedImageItemViewHolder) holder).titleView.setText("DemoCollapsedItemImage" + position + ", " + realItem.title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_COLLAPSABLE) {
            return new CollapsableItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsable_item_layout, parent, false));
        } else if (viewType == VIEW_TYPE_COLLAPSED_TEXT) {
            return new CollapsedTextItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsed_item_text, parent, false));
        } else if (viewType == VIEW_TYPE_COLLAPSED_IMAGE) {
            return new CollapsedImageItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_collapsable_rv_adapter_collapsed_item_image, parent, false));
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int getItemViewType(int position) {
        Item item = mData.get(position);
        if (item instanceof CollapsableItem) {
            return VIEW_TYPE_COLLAPSABLE;
        } else if (item instanceof DemoCollapsedItemText) {
            return VIEW_TYPE_COLLAPSED_TEXT;
        } else if (item instanceof DemoCollapsedItemImage) {
            return VIEW_TYPE_COLLAPSED_IMAGE;
        } else {
            throw new RuntimeException();
        }
    }

    public static class CollapsableItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsableItemViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public static class CollapsedTextItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsedTextItemViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public static class CollapsedImageItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public CollapsedImageItemViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void buildDummyData() {
        mData.clear();
        DemoCollapsableItem item1 = new DemoCollapsableItem(0, "DCS1");
        ArrayList<CollapsedItem> item1Sub = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            if (i != 5) {
                if (i == 0) {
                    item1Sub.add(new DemoCollapsedItemImage(i, "image " + i));
                } else {
                    item1Sub.add(new DemoCollapsedItemText(i, "text " + i));
                }
            } else {
                item1Sub.add(new DemoCollapsedItemImage(i, "image " + i));
            }
        }
        item1.addSubItems(item1Sub, true);
        mData.add(item1);
        DemoCollapsableItem item2 = new DemoCollapsableItem(0, "DCS2");
        mData.add(item2);
        DemoCollapsableItem item3 = new DemoCollapsableItem(0, "DCS3");
        mData.add(item3);
        ArrayList<CollapsedItem> item3Sub = new ArrayList<>();
        item3Sub.add(new DemoCollapsedItemImage(0, "image " + 0));
        item3.addSubItems(item3Sub, true);
        DemoCollapsableItem item4 = new DemoCollapsableItem(0, "DCS4");
        mData.add(item4);
        DemoCollapsableItem item5 = new DemoCollapsableItem(0, "DCS5");
        mData.add(item5);
        ArrayList<CollapsedItem> item5Sub = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            if (i != 5) {
                item5Sub.add(new DemoCollapsedItemText(i, "text " + i));
            } else {
                item5Sub.add(new DemoCollapsedItemImage(i, "image " + i));
            }
        }
        item5.addSubItems(item5Sub, true);

        for (int i = 0; i < 200; ++i) {
            DemoCollapsableItem itemH = new DemoCollapsableItem(0, "DCS" + (i + 6));
            mData.add(itemH);
        }

        notifyDataSetChanged();
    }
}
