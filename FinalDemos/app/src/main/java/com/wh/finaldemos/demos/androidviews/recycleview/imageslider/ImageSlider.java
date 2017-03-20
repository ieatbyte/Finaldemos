package com.wh.finaldemos.demos.androidviews.recycleview.imageslider;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;
import com.whlib.alib.Utils.VersionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ImageSlider extends RecyclerView {

    XLog logger = new XLog(ImageSlider.class);

    public ImageSlider(Context context) {
        super(context);
        init(context);
    }

    public ImageSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageSlider(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setLayoutManager(new ImageSliderLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        ImageSliderAdapter isa = new ImageSliderAdapter();
        isa.setItemCount(6);
        setAdapter(isa);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        logger.d("velocityX:" + velocityX + ", velocityY:" + velocityY);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        logger.d("onTouchEvent:" + e.getAction());
        return super.onTouchEvent(e);
    }

    private static class ImageSliderLayoutManager extends LinearLayoutManager {

        public ImageSliderLayoutManager(Context context) {
            super(context);
        }

        public ImageSliderLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public ImageSliderLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }
    }

    private static class ImageSliderAdapter extends RecyclerView.Adapter {

        private ArrayList<ImageItem> mData;

        private AdapterView.OnItemClickListener mOnItemClickListener;

        public ImageSliderAdapter() {
            mData = new ArrayList<ImageItem>();
        }

        public void setItemCount(int count) {
            mData.clear();
            mData.addAll(generateDummyData(count));

            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            mOnItemClickListener = onItemClickListener;
        }

        private void onItemHolderClick(ImageItemViewHolder itemHolder) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                        itemHolder.getAdapterPosition(), itemHolder.getItemId());
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageItem item = mData.get(position);
            ImageItemViewHolder realHolder = (ImageItemViewHolder)holder;
            realHolder.mTitleTextView.setText(item.title);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ImageItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item, parent, false), this);
        }

        public static class ImageItem {
            public String title;

            public ImageItem(String title) {
                this.title = title;
            }
        }

        public static class ImageItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            ImageSliderAdapter mAdapter;
            TextView mTitleTextView;

            public ImageItemViewHolder(View itemView, ImageSliderAdapter adapter) {
                super(itemView);
                mTitleTextView = (TextView)itemView.findViewById(R.id.image_slider_txt);
                mAdapter = adapter;
                itemView.setOnClickListener(this);
                if (VersionHelper.isEAbove(21)) {
                    itemView.setElevation(5f);
                }
            }

            @Override
            public void onClick(View v) {
                mAdapter.onItemHolderClick(this);
            }
        }

        public static ImageItem generateDummyItem() {
            Random random = new Random();
            return new ImageItem("Random" +
                    random.nextInt(Integer.MAX_VALUE));
        }

        public static List<ImageItem> generateDummyData(int count) {
            ArrayList<ImageSliderAdapter.ImageItem> items = new ArrayList<ImageSliderAdapter.ImageItem>();

            for (int i=0; i < count; i++) {
                items.add(new ImageSliderAdapter.ImageItem("Gen" + i));
            }

            return items;
        }
    }
}
