package com.wh.finaldemos.demos.media.video.surfaceview.simpleplay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wh.finaldemos.App;
import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;

import java.io.IOException;

public class SurfaceViewPlayMp4DemoActivity extends AppCompatActivity {

    SurfaceView mPlaySurfaceView;
    SurfaceHolder mSurfaceHolder;
    MediaPlayer mMediaPlayer;
    RelativeLayout mSurfaceContainer;
    ImageView mVideoMaskTop;
    ImageView mVideoMaskBottom;
    Button mToggleMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_play_mp4_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //mPlaySurfaceView = (SurfaceView) findViewById(R.id.playSurfaceView);
        mSurfaceContainer = (RelativeLayout) findViewById(R.id.playSurfaceViewContainer);
        mPlaySurfaceView = new SurfaceView(SurfaceViewPlayMp4DemoActivity.this);
        //mPlaySurfaceView.setBackgroundColor(Color.BLACK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mSurfaceContainer.addView(mPlaySurfaceView, layoutParams);
        mVideoMaskTop = new ImageView(SurfaceViewPlayMp4DemoActivity.this);
        RelativeLayout.LayoutParams layoutParamsMask = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.convertDpToPixel(App.context, 40));
        layoutParamsMask.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        mVideoMaskTop.setBackgroundResource(R.drawable.black_mask);
        mVideoMaskTop.setScaleY(-1f);
        mSurfaceContainer.addView(mVideoMaskTop, layoutParamsMask);
        mVideoMaskBottom = new ImageView(SurfaceViewPlayMp4DemoActivity.this);
        layoutParamsMask.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        mVideoMaskBottom.setBackgroundResource(R.drawable.black_mask);
        RelativeLayout.LayoutParams layoutParamsMaskBottom = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.convertDpToPixel(App.context, 40));
        layoutParamsMaskBottom.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mSurfaceContainer.addView(mVideoMaskBottom, layoutParamsMaskBottom);
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
        mToggleMask = (Button) findViewById(R.id.toggle_mask);
        mToggleMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoMaskTop.setVisibility(mVideoMaskTop.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                mVideoMaskBottom.setVisibility(mVideoMaskBottom.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
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
}
