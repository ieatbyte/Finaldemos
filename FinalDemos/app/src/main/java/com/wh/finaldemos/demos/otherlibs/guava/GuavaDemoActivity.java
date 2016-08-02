package com.wh.finaldemos.demos.otherlibs.guava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.Preconditions;
import com.wh.finaldemos.R;

public class GuavaDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guava_demo);

        String a = null;
        Preconditions.checkNotNull(a, "a should not null");
    }
}
