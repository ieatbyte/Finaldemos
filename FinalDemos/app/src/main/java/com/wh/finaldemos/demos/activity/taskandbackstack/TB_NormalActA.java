package com.wh.finaldemos.demos.activity.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wh.finaldemos.R;

public class TB_NormalActA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb__normal_act);
        startNormalB();
        //startNormalBWithSingleTaskFlag();
    }

    private void startNormalB() {
        ((Button)findViewById(R.id.launch_but)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TB_NormalActA.this, TB_NormalActB.class);
                startActivity(intent);
            }
        });
    }

    private void startNormalBWithSingleTaskFlag() {
        ((Button)findViewById(R.id.launch_but)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(TB_NormalActA.this, TB_NormalActB.class);
                startActivity(intent);
            }
        });
    }
}
