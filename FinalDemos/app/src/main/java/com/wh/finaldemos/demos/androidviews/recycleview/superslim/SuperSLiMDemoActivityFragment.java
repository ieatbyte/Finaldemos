package com.wh.finaldemos.demos.androidviews.recycleview.superslim;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wh.finaldemos.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SuperSLiMDemoActivityFragment extends Fragment {

    public SuperSLiMDemoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_super_sli_mdemo, container, false);
    }
}
