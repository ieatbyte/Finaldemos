package com.wh.finaldemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wanghui5-s on 2015/12/9.
 * <p/>
 * Conclusion:
 * #1:
 */
public class BaseDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getClass().getSimpleName());
    }
}
