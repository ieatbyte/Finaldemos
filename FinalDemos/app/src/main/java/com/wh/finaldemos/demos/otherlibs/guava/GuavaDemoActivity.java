package com.wh.finaldemos.demos.otherlibs.guava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.wh.finaldemos.R;

public class GuavaDemoActivity extends AppCompatActivity {

    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guava_demo);

        String a = null;
        //Preconditions.checkNotNull(a, "a should not null");

        Strings.isNullOrEmpty(a);

        mCount = 10;

        Log.e("wh_debug", MoreObjects.toStringHelper(this).add("me", "4104").add("mCount", mCount).toString());

    }
}
