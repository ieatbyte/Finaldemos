package com.wh.finaldemos.demos.arc.mvp;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/8/2.
 * <p/>
 * Conclusion:
 * #1:
 */
public interface Demo1Contract {

    interface View extends BaseView<Presenter> {
        void setData(ArrayList<String> data);
    }

    interface Presenter extends BasePresenter {
        void loadData();
    }
}
