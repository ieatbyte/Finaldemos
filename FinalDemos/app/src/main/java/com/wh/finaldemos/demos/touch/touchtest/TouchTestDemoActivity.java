package com.wh.finaldemos.demos.touch.touchtest;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class TouchTestDemoActivity extends BaseDemoActivity {

    private MyView myView;
    private MyViewGroup myViewGroup;
    private MyView myViewGroupMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_test_demo);

        myView = (MyView) findViewById(R.id.myView);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TouchTestDemo.logger.d("setOnTouchListener myview onTouch event action:" + motionEvent.getAction() + ", tag:" + view.getTag());
                return false;
            }
        });
        myViewGroup = (MyViewGroup) findViewById(R.id.myViewGroup);
        myViewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TouchTestDemo.logger.d("setOnTouchListener myviewgroup onTouch event action:" + motionEvent.getAction() + ", tag:" + view.getTag());
                return true;
            }
        });
        myViewGroupMyView = (MyView) findViewById(R.id.myViewInside);
        myViewGroupMyView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TouchTestDemo.logger.d("setOnTouchListener myviewinsidegroup onTouch event action:" + event.getAction() + ", tag:" + v.getTag());
                return false;
            }
        });
    }
}
