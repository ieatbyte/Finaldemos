package com.wh.finaldemos.demos.otherlibs.rxbinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.wh.finaldemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class RxBindingDemoActivity extends AppCompatActivity {

    @BindView(R.id.hello1)
    Button mHello1;

    @BindView(R.id.hello4)
    TextView mHello4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_binding_demo);

        ButterKnife.bind(this);

        //RxTextView.
        RxView.clicks(mHello1).retry(new Func2<Integer, Throwable, Boolean>() {
            @Override
            public Boolean call(Integer integer, Throwable throwable) {
                return null;
            }
        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Throwable> observable) {
                return null;
            }
        }).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Log.e("RxBindingDemoActivity", "hello1 click");

//                Intent intent = new Intent();
//                intent.setClassName("noentry.com.example.wanghui.noentryapplication", "noentry.com.example.wanghui.noentryapplication.MainActivity");
//                startActivity(intent);
            }
        });

    }
}
