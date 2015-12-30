package com.wh.finaldemos.demos.textshow.Path;

import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

import java.io.File;

public class PathShowDemoActivity extends BaseDemoActivity {

    TextView mShowBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_show_demo);

        mShowBoard = (TextView) findViewById(R.id.show_path);
        mShowBoard.setText(buildPathsString());
    }

    private String buildPathsString() {
        StringBuilder stringBuilder = new StringBuilder();
        File file1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        stringBuilder.append("Environment.DIRECTORY_DOWNLOADS:" + file1.getAbsolutePath() + ", exists:" + file1.exists());
        stringBuilder.append("\n\n");
        file1 = Environment.getExternalStorageDirectory();
        stringBuilder.append("Environment.getExternalStorageDirectory:" + file1.getAbsolutePath() + ", exists:" + file1.exists());
        stringBuilder.append("\n\n");
        file1 = getExternalFilesDir(null);
        stringBuilder.append("Context.getExternalFilesDir(null):" + file1.getAbsolutePath() + ", exists:" + file1.exists());
        stringBuilder.append("\n\n");
        file1 = getFilesDir();
        stringBuilder.append("Context.getFilesDir():" + file1.getAbsolutePath() + ", exists:" + file1.exists());
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }
}
