package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist;

import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.androidviews.recycleview.adapters.SimpleAdapter;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListItemViewHolder;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.IGridListAdapterContract;

import butterknife.BindView;

/**
 * Created by wanghui on 17-3-16.
 */

// TODO save layoutmanager instance and restore out of item data model structure
public class TestInnerHorizonListItemViewHolder extends GridListItemViewHolder<TestInnerHorizonListItemVM> {

    @BindView(R.id.inner_list)
    RecyclerView innerListView;

    TestInnerHorizonListItemVM currentRealItem;

    public TestInnerHorizonListItemViewHolder(View itemView, IGridListAdapterContract adapter) {
        super(itemView, adapter);
        mItemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                Log.e("TestInner", "onViewAttachedToWindow");
            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                Log.e("TestInner", "onViewDetachedFromWindow view:" + view + ", " + mItemView);
                currentRealItem.tag = innerListView.getLayoutManager().onSaveInstanceState();
            }
        });
    }

    @Override
    public void bind(TestInnerHorizonListItemVM item) {
//        Exception e = new Exception();
//        Log.e("TMP_TRACE_TEST_INNER", "bind", e);
        if (item instanceof TestInnerHorizonListItemVM) {
            final TestInnerHorizonListItemVM realItem = (TestInnerHorizonListItemVM) item;
            currentRealItem = realItem;
            SimpleAdapter sa = new SimpleAdapter();
            sa.setItemCount(10);
            innerListView.setLayoutManager(new LinearLayoutManager(mItemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            innerListView.setAdapter(sa);
            innerListView.setNestedScrollingEnabled(false);
            innerListView.setTag(item.getItemId());
            if (realItem.tag != null && realItem.tag instanceof Parcelable) {
                innerListView.getLayoutManager().onRestoreInstanceState((Parcelable) realItem.tag);
            }
        } else {
            // will not reach
        }
    }

}
