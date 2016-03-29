package com.wh.finaldemos.demos.textshow.EnterSpace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wh.finaldemos.R;

public class EnterSpaceDemoActivity extends AppCompatActivity {

    private TextView mContentText;

    private Button mOK;

    private EditText mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_space_demo);
        mOK = (Button) findViewById(R.id.ok);
        mInput = (EditText) findViewById(R.id.edit_content);
        mContentText = (TextView) findViewById(R.id.content_text);
        String a = "helloiiewofa\nrefefefe\nrerfrrroooooooooooo\n\n\njjjjjj";
        mContentText.setText(a);

        mOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String b = TextUtils.replace(mInput.getText(), new String[]{"\n"}, new CharSequence[]{" "}).toString();
                String b = mInput.getText().toString();
                mContentText.setText(getNoLineBreakString(b));
            }
        });
    }

    public static String getNoLineBreakString(String content) {
        if (!TextUtils.isEmpty(content)) {
            return content.replaceAll("[\\t\\n\\r]", " ");
        } else {
            return content;
        }
    }


}
