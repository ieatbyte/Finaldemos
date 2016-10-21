package com.wh.finaldemos.demos.otherlibs.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest.DaggerMultiConstructorComponent;
import com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest.TestClassA;
import com.wh.finaldemos.demos.otherlibs.dagger2.MultiConstructorTest.TestModule;

import javax.inject.Inject;
import javax.inject.Named;

public class Dagger2DemoActivity extends AppCompatActivity {

    @Inject
    @Named("one")
    TestClassA mA1;

    @Inject
    @Named("two")
    TestClassA mA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_demo);
        Log.e("dagger2", "onCreate start");

        DaggerMultiConstructorComponent.builder().testModule(new TestModule(10, 20, 30)).build().inject(this);

        Log.e("dagger2", "mA1:" + mA1 + ", mA2:" + mA2);
    }
}
