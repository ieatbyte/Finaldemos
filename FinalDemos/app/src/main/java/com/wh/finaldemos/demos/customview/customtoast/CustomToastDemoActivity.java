package com.wh.finaldemos.demos.customview.customtoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wh.finaldemos.R;

public class CustomToastDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomToast mCustomToast;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast_demo);

        mCustomToast = new CustomToast(this);

        mPopupWindow = new PopupWindow(LayoutInflater.from(this).inflate(R.layout.custom_toast_layout, null), RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT, true);

        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(CustomToastDemoActivity.this, "test", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 300, 0);
                //toast.show();
                //mCustomToast.show();
            }
        }, 3000);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_win) {
            mCustomToast.show();
            //mPopupWindow.showAsDropDown(v);
        }
    }
}
