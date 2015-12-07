package com.wh.finaldemos.demos.media.video.videoview.simplePlay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;

public class VideoViewSimplePlayActivity extends AppCompatActivity {

    VideoView mPlayVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_simple_play);
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

        mPlayVideoView = (VideoView) findViewById(R.id.playVideoView);
        mPlayVideoView.setVideoURI(Utils.PUBLIC_MP4_URI);
        mPlayVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });
        MediaController mc = new MediaController(this);
        //mc.setAnchorView(mPlayVideoView);
        mPlayVideoView.setMediaController(mc);
    }

}
