package com.wh.finaldemos.demos.androidviews.NestedScrollView.simpleuse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

public class NestedScrollViewSimpeUseDemoActivity extends BaseDemoActivity {

    XLog logger = new XLog(NestedScrollViewSimpeUseDemoActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view_simpe_use_demo);
    }

    public void onButtonClick(View v) {
        Button real = null;
        if (v instanceof Button) {
            real = (Button) v;
        }
        if (real != null) {
            logger.d("onButtonClick:" + real.getText());
        }
    }
}
