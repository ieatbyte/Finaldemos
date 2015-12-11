package com.wh.finaldemos.demos.uiproperty.viewgroupvisibility;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

public class ViewGroupVisibilityDemoActivity extends BaseDemoActivity {

    XLog logger = new XLog(ViewGroupVisibilityDemoActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group_visibility_demo);
    }

    public void onButtonClick(View v) {
        Button real = null;
        if (v instanceof Button) {
            real = (Button) v;
        }
        if (real != null) {
            logger.d("onButtonClick:" + real.getText());
        }
        findViewById(R.id.viewgroupvis_btn_wrapper).setVisibility(View.GONE);
    }
}
