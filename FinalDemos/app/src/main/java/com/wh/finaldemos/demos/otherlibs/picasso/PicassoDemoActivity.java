package com.wh.finaldemos.demos.otherlibs.picasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.arc.mvp.MVPDemoActivity;

public class PicassoDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_demo);

        Intent intent = new Intent(this, MVPDemoActivity.class);
        startActivity(intent);
    }
}
