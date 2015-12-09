package com.wh.finaldemos.demos.androidviews.RecycleView.decorations;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wh.finaldemos.App;
import com.whlib.alib.converters.DimensionConverter;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class SimpleDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(DimensionConverter.convertDpToPixel(App.context, 5), DimensionConverter.convertDpToPixel(App.context, 20), DimensionConverter.convertDpToPixel(App.context, 5), DimensionConverter.convertDpToPixel(App.context, 20));
    }
}
