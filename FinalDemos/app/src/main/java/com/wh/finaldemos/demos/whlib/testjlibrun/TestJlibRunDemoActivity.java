package com.wh.finaldemos.demos.whlib.testjlibrun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.finaldemos.R;
import com.whlib.jlib.file.Path;

public class TestJlibRunDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jlib_run_demo);
        ((TextView)findViewById(R.id.demo_text1)).setText("hello, " + Path.mergePathWithTailName("/data/data/com.wh.demos", "demo1", "/"));
    }
}
