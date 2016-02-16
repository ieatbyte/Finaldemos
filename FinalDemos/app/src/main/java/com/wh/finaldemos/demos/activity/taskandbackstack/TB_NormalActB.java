package com.wh.finaldemos.demos.activity.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class TB_NormalActB extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb__normal_act_b);
        startSingleTask();
    }

    private void startSingleTask() {
        ((Button)findViewById(R.id.launch_but)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TB_NormalActB.this, TB_SingleTaskAct.class);
                startActivity(intent);
            }
        });
    }
}
