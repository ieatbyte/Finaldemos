package com.wh.finaldemos.demos.activity.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class TaskAndBackstackDemoActivity extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_and_backstack_demo);
        startNormalA();
    }

    private void startNormalA() {
        ((Button)findViewById(R.id.launch_but)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TaskAndBackstackDemoActivity.this, TB_NormalActA.class);
                startActivity(intent);
            }
        });
    }
}
