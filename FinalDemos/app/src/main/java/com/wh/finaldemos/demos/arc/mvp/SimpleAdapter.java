package com.wh.finaldemos.demos.arc.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;
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
public class SimpleAdapter extends RecyclerView.Adapter {

    private ArrayList<SimpleItem> mData;

    private AdapterView.OnItemClickListener mOnItemClickListener;

    private Context mContext;

    public SimpleAdapter(Context context) {
        mData = new ArrayList<SimpleItem>();
        mContext = context;
    }

    public void setItemCount(int count) {
        mData.clear();
        //mData.addAll(generateDummyData(count));

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(SimpleItemViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SimpleItem item = mData.get(position);
        SimpleItemViewHolder realHolder = (SimpleItemViewHolder)holder;
        realHolder.mTitleTextView.setText(item.title);
        String url = Utils.DEBUG_IMAGES_URL[position % Utils.DEBUG_IMAGES_URL.length];
        //Picasso.with(mContext).load(url).tag(url).placeholder(R.mipmap.ic_launcher).error(R.drawable.icon_add).into(realHolder.mLogoView);
        //PicassoTrustAll.getInstance(mContext).load(url).tag(url).placeholder(R.mipmap.ic_launcher).error(R.drawable.icon_add).into(realHolder.mLogoView);
        Glide.with(mContext).load(url).placeholder(R.mipmap.ic_launcher).dontAnimate().into(realHolder.mLogoView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_simple_adapter_item_layout, parent, false), this);
    }

    public static class SimpleItem {
        public String title;

        public SimpleItem(String title) {
            this.title = title;
        }
    }

    public static class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        SimpleAdapter mAdapter;
        TextView mTitleTextView;
        ImageView mLogoView;

        public SimpleItemViewHolder(View itemView, SimpleAdapter adapter) {
            super(itemView);
            mTitleTextView = (TextView)itemView.findViewById(R.id.recycleview_simple_adapter_item_title);
            mLogoView = (ImageView)itemView.findViewById(R.id.logo);
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

    public void doAddDummy() {
        mData.addAll(generateDummyData(100));
        notifyDataSetChanged();
    }

    public static SimpleItem generateDummyItem() {
        Random random = new Random();
        return new SimpleItem("Random" +
                random.nextInt(Integer.MAX_VALUE));
    }

    public static List<SimpleAdapter.SimpleItem> generateDummyData(int count) {
        ArrayList<SimpleAdapter.SimpleItem> items = new ArrayList<SimpleAdapter.SimpleItem>();

        for (int i=0; i < count; i++) {
            items.add(new SimpleAdapter.SimpleItem("Gen" + i));
        }

        return items;
    }
}
