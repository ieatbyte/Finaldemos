package com.wh.finaldemos.demos.customview.customtoast;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.wh.finaldemos.DemoDebug;
import com.wh.finaldemos.R;
import com.wh.finaldemos.Utils;

/**
 * Created by wanghui5-s on 2016/4/1.
 * <p/>
 * Conclusion:
 * #1:
 */
public class CustomToast {

    WindowManager mWM;

    private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();

    PopupViewContainer mView;

    Context mContext;

    int mGravity;

    private boolean mIsShowing;

    VideoView mPlayVideoView;

    public CustomToast(Context context) {
        mContext = context;
        mGravity = Gravity.RIGHT;
        mView = new PopupViewContainer(mContext);//LayoutInflater.from(mContext).inflate(R.layout.custom_toast_layout, null); //new StaticLayoutDemoCustomView(mContext);
        PopupViewContainer.LayoutParams listParams = new PopupViewContainer.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.addView(LayoutInflater.from(mContext).inflate(R.layout.custom_toast_layout, null), listParams);

        final WindowManager.LayoutParams params = mParams;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
//        params.windowAnimations = com.android.internal.R.style.Animation_Toast;
        params.type = WindowManager.LayoutParams.TYPE_TOAST; //WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;//WindowManager.LayoutParams.TYPE_TOAST;
        params.setTitle("MyToast");
        params.flags = computeFlags(params.flags);
    }

    public void show() {
        mWM = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        // We can resolve the Gravity here by using the Locale for getting
        // the layout direction
        final Configuration config = mView.getContext().getResources().getConfiguration();
        final int gravity = Gravity.getAbsoluteGravity(mGravity, LayoutDirection.LTR);
        mParams.gravity = gravity;
        if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.FILL_HORIZONTAL) {
            mParams.horizontalWeight = 1.0f;
        }
        if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.FILL_VERTICAL) {
            mParams.verticalWeight = 1.0f;
        }
//        mParams.x = mX;
//        mParams.y = mY;
//        mParams.verticalMargin = mVerticalMargin;
//        mParams.horizontalMargin = mHorizontalMargin;
        mParams.packageName = mContext.getPackageName();
        if (mView.getParent() != null) {
            mWM.removeView(mView);
        }
        mWM.addView(mView, mParams);
        mIsShowing = true;

        mPlayVideoView = (VideoView) mView.findViewById(R.id.playVideoView);
        mPlayVideoView.setVideoURI(Utils.PUBLIC_MP4_URI);
        mPlayVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });
        MediaController mc = new MediaController(mContext);
        //mc.setAnchorView(mPlayVideoView);
        mPlayVideoView.setMediaController(mc);
    }

    private int computeFlags(int curFlags) {
        curFlags &= ~(
                WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES |
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                        WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
//        if(mIgnoreCheekPress) {
//            curFlags |= WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES;
//        }
//        if (!mFocusable) {
//            curFlags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//            if (mInputMethodMode == INPUT_METHOD_NEEDED) {
//                curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
//            }
//        } else if (mInputMethodMode == INPUT_METHOD_NOT_NEEDED) {
            curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
//        }
//        if (!mTouchable) {
//            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        }
//        if (mOutsideTouchable) {
            curFlags |= WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
//        }
//        if (!mClippingEnabled) {
//            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
//        }
//        if (isSplitTouchEnabled()) {
//            curFlags |= WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
//        }
//        if (mLayoutInScreen) {
//            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
//        }
//        if (mLayoutInsetDecor) {
//            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
//        }
//        if (mNotTouchModal) {
//            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
//        }
//        if (mAttachedInDecor) {
//            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_ATTACHED_IN_DECOR;
//        }
        return curFlags;
    }

    public boolean isShowing() {
        return mIsShowing;
    }

    public void dismiss() {
        if (isShowing()) {
            mIsShowing = false;

            try {
                mWM.removeViewImmediate(mView);
            } finally {
                mView = null;
            }
        }
    }

    private class PopupViewContainer extends FrameLayout {
        private static final String TAG = "PopupWindow.PopupViewContainer";

        public PopupViewContainer(Context context) {
            super(context);
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            DemoDebug.log("dispatchKeyEvent " + event);
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(event);
                }

                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null && state.isTracking(event) && !event.isCanceled()) {
                        dismiss();
                        return true;
                    }
                }
                return super.dispatchKeyEvent(event);
            } else {
                return super.dispatchKeyEvent(event);
            }
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
//            if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
//                return true;
//            }
            return super.dispatchTouchEvent(ev);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            DemoDebug.log("onTouchEvent " + event);
            final int x = (int) event.getX();
            final int y = (int) event.getY();

            if ((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight()))) {
                dismiss();
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                dismiss();
                return true;
            } else {
                return super.onTouchEvent(event);
            }
        }
    }
}
