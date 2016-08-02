package com.wh.finaldemos.demos.arc.mvp;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by wanghui5-s on 2016/8/2.
 * <p/>
 * Conclusion:
 * #1:
 */
public class Demo1Presenter implements Demo1Contract.Presenter {

    private Demo1Contract.View mView;

    public Demo1Presenter(Demo1Contract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<String> result = new ArrayList<String>();
                mView.setData(result);
            }
        }.execute();
    }

    @Override
    public void start() {

    }
}
