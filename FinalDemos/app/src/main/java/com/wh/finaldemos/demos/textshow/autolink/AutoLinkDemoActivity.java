package com.wh.finaldemos.demos.textshow.autolink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AutoLinkDemoActivity extends BaseDemoActivity {

    @BindView(R.id.send_mail)
    Button mSendMailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_link_demo);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.send_mail)
    void onSendMailClick() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "abc@gmail.com");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}
