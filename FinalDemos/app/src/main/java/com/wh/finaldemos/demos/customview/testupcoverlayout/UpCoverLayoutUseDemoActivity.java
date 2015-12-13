package com.wh.finaldemos.demos.customview.testupcoverlayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;
import com.wh.finaldemos.demos.androidviews.RecycleView.adapters.SimpleAdapter;
import com.wh.finaldemos.demos.androidviews.RecycleView.decorations.SimpleDecoration;
import com.whlib.alib.Log.XLog;

import java.io.IOException;

public class UpCoverLayoutUseDemoActivity extends BaseDemoActivity implements AdapterView.OnItemClickListener{

    XLog logger = new XLog(UpCoverLayoutUseDemoActivity.class);

    RecyclerView mRecyclerView;

    SurfaceView mPlaySurfaceView;
    SurfaceHolder mSurfaceHolder;
    MediaPlayer mMediaPlayer;
    RelativeLayout mSurfaceContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_cover_layout_use_demo);

        mRecyclerView = (RecyclerView) findViewById(R.id.upcover_nested_scrollivew);
        SimpleAdapter sa = new SimpleAdapter();
        sa.setItemCount(12);
        sa.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SimpleDecoration());
        mRecyclerView.setAdapter(sa);

        mSurfaceContainer = (RelativeLayout) findViewById(R.id.playSurfaceViewContainer);
        mPlaySurfaceView = new SurfaceView(UpCoverLayoutUseDemoActivity.this);
        //mPlaySurfaceView.setBackgroundColor(Color.BLACK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mSurfaceContainer.addView(mPlaySurfaceView, layoutParams);
        mSurfaceHolder = mPlaySurfaceView.getHolder();
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                playVideo();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    public void onButtonClick(View v) {
        Button real = null;
        if (v instanceof Button) {
            real = (Button) v;
        }
        if (real != null) {
            logger.d("onButtonClick:" + real.getText());
        }
    }


    private void playVideo() {
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(this, Utils.PUBLIC_MP4_URI);
            mMediaPlayer.setDisplay(mSurfaceHolder);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.setLooping(true);
                    mMediaPlayer.start();
                }
            });
        } catch (IOException e) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "Clicked: " + position + ", index " + mRecyclerView.indexOfChild(view),
                Toast.LENGTH_SHORT).show();
    }
}
