package com.wh.finaldemos.demos.jsongson.basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wh.finaldemos.R;

public class BasicDemoActivity extends AppCompatActivity {

    private TextView contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_demo);

        contentTextView = (TextView) findViewById(R.id.content);

        Gson gson = new Gson();


//        A a = new A();
//        contentTextView.setText(gson.toJson(a));

        //A a2 = gson.fromJson("{\"1\":6,\"b\":2,\"data\":{\"mName\":12},\"dataStrs\":[]}", A.class);
        A a2 = new A();
        //A a2 = gson.fromJson("{\"1\":6,\"b\":2,\"data\":{\"mName\":12},\"dataStrs\":[],\"eventTime\":2016-05-27T14:43:45.000+0800}", A.class);
        contentTextView.setText(gson.toJson(a2));
    }
}
