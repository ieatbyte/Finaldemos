package com.wh.finaldemos.demos.androidviews.popupwindow;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class PopupWindowDemoActivity extends BaseDemoActivity {

    private Button but1;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_demo);

        but1 = (Button) findViewById(R.id.but1);
        View content = getLayoutInflater().inflate(R.layout.popup_window_demo_layout, null);
        mPopupWindow = new PopupWindow(content, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(but1);
            }
        });
    }
}
