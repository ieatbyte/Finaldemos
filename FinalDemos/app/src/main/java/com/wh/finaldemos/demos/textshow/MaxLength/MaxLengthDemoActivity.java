package com.wh.finaldemos.demos.textshow.MaxLength;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.finaldemos.R;

public class MaxLengthDemoActivity extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;

    private final static String DEMO_STRING = "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
    private final static String DEMO_STRING2 = "我都MMMMMMM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_length_demo);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);

        String useString = DEMO_STRING2;

        txt1.setText(useString);
        txt2.setText(useString);
        txt3.setText(useString);
    }
}
