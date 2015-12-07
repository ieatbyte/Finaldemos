package com.wh.finaldemos.demos.media.video.textureview.simpleplay;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;

import java.io.IOException;

public class TextureViewPlayMp4Activity extends AppCompatActivity {

    TextureView mPlayTextureView;
    MediaPlayer mMediaPlayer;
    ObjectAnimator mObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_view_play_mp4);
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

        mPlayTextureView = (TextureView) findViewById(R.id.playTextureView);
        mPlayTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
                Surface surface = new Surface(surfaceTexture);
                mMediaPlayer = new MediaPlayer();
                try {
                    mMediaPlayer.setDataSource(TextureViewPlayMp4Activity.this, Utils.PUBLIC_MP4_URI);
                    mMediaPlayer.setSurface(surface);
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
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {

            }
        });
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.5f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.5f);
        PropertyValuesHolder pvhRotate = PropertyValuesHolder.ofFloat("rotationX", 0f, 360f);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mPlayTextureView, pvhX, pvhY, pvhRotate);
        mObjectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        mObjectAnimator.setDuration(2000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            mObjectAnimator.start();
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
