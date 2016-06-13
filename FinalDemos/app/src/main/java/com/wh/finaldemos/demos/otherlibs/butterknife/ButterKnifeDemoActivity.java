package com.wh.finaldemos.demos.otherlibs.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.finaldemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeDemoActivity extends AppCompatActivity {

    @BindView(R.id.my_txt)
    TextView mMyTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_demo);
        ButterKnife.bind(this);

        mMyTxt.setText("hello world!");
    }

    @OnClick(R.id.but1)
    void onBut1Click() {
        mMyTxt.setText("hello world2!");
    }
}
