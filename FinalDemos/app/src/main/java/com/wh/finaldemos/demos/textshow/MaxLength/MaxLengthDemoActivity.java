package com.wh.finaldemos.demos.textshow.MaxLength;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.wh.finaldemos.R;

public class MaxLengthDemoActivity extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    private final static String DEMO_STRING = "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
    private final static String DEMO_STRING2 = "我都MMMMMMM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_length_demo);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);

        String useString = DEMO_STRING2;

        txt1.setText(useString);
        txt2.setText(useString);
        txt3.setText(useString);
        txt4.setText(DEMO_STRING);
        txt4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        Log.e("MaxLengthDemoActivity", "result:" + isSameWifiName("360-test-xsd1-4-5G", "360-test-xsd1-4"));

    }

    private boolean isSameWifiName(String name1, String name2) {
        return TextUtils.equals(fixWifiName(name1), fixWifiName(name2));
    }

    private String fixWifiName(String originWifiName) {
        if (!TextUtils.isEmpty(originWifiName)) {
            if (originWifiName.endsWith("-5G")) {
                return originWifiName.substring(0, originWifiName.lastIndexOf("-5G"));
            } else if (originWifiName.endsWith("-5g")) {
                return originWifiName.substring(0, originWifiName.lastIndexOf("-5g"));
            } else if (originWifiName.endsWith("-2.4G")) {
                return originWifiName.substring(0, originWifiName.lastIndexOf("-2.4G"));
            } else if (originWifiName.endsWith("-2.4g")) {
                return originWifiName.substring(0, originWifiName.lastIndexOf("-2.4g"));
            } else {
                return originWifiName;
            }
        } else {
            return originWifiName;
        }
    }
}
