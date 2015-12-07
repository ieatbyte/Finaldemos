package com.wh.finaldemos.demos.media.video.textureview.camerapreview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;

import com.wh.finaldemos.R;

import java.io.IOException;

public class CameraPreviewWithTextureViewActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera_preview_with_texture_view);

        mTextureView = (TextureView)findViewById(R.id.camera_preview_with_texture_view_textureview);
        mTextureView.setSurfaceTextureListener(this);

    }

    private Camera mCamera;
    private TextureView mTextureView;

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        mCamera = Camera.open();

        //Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
        //mTextureView.setLayoutParams(new FrameLayout.LayoutParams(
        //        previewSize.width, previewSize.height, Gravity.CENTER));

        try {
            mCamera.setPreviewTexture(surface);
        } catch (IOException t) {
        }

        mCamera.startPreview();

        //mTextureView.setAlpha(0.5f);
        //mTextureView.setRotation(45.0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
        ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(mTextureView, pvhRotation);
        oa.setRepeatCount(ValueAnimator.INFINITE);
        oa.setRepeatMode(ValueAnimator.REVERSE);
        oa.setDuration(2000);
        oa.start();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        // Ignored, the Camera does all the work for us
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        // Called whenever a new frame is available and displayed in the TextureView
    }
}
