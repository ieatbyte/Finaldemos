package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.innerhorizenlist;

import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.GridListConfig;
import com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main.GridListFullSpanItemVM;

/**
 * Created by wanghui on 17-3-16.
 */

public class TestInnerHorizonListItemVM extends GridListFullSpanItemVM<TestInnerHorizonListItem> {

    public Object tag;

    public TestInnerHorizonListItemVM(TestInnerHorizonListItem gridItem) {
        super(gridItem);
    }

    @Override
    public int getSpanSize() {
        return GridListConfig.TOTAL_SPAN_COUNT;
    }

    @Override
    public long getItemId() {
        return this.hashCode();
    }
}
