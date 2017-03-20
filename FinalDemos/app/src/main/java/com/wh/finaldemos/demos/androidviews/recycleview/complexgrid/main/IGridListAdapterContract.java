package com.wh.finaldemos.demos.androidviews.recycleview.complexgrid.main;

import java.util.ArrayList;

/**
 * Created by wanghui on 17-3-20.
 */

public interface IGridListAdapterContract {

    void removeItems(ArrayList<IGridListItemViewModel> vmsToRemove);

    void removeGroupSubItemVMs(GridListGroupItemVM groupVM);

    void addGroupSubItemVMs(GridListGroupItemVM groupVM);
}
