package com.wh.finaldemos.demos.customview.highlightguide;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

import com.wh.finaldemos.DemoDebug;
import com.wh.finaldemos.R;

public class HightlightGuideDemoActivity extends AppCompatActivity implements HighlightGuide.HighlightGuideInfoProvider, HighlightGuide.HighlightGuideHost{

    private Button but1;

    private HighlightGuide mGuide;

    private RectF mGuideRectF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hightlight_guide_demo);

        but1 = (Button) findViewById(R.id.but_1);
        mGuide = (HighlightGuide) findViewById(R.id.guide);
        mGuide.setHighlightGuideInfoProvider(this);
        mGuide.setHighlightGuideHost(this);
        but1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

                HightlightGuideDemoActivity.this.setAnchorView(but1);
                but1.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
    }

    @Override
    public RectF getInfo() {
        //return new RectF(48.0f, 288.0f, 322.0f, 144.0f);
        return mGuideRectF;
    }

    @Override
    public View getGuideTextView() {
        ImageView iv = new ImageView(HightlightGuideDemoActivity.this);
        iv.setImageResource(R.drawable.guide_text_ontop);
        return iv;
    }

    @Override
    public void setAnchorView(View v) {
        DemoDebug.log("setAnchorView");
        int[] loc = new int[2];
        v.getLocationOnScreen(loc);
        int[] parentloc = new int[2];
        ((View)v.getParent()).getLocationOnScreen(parentloc);
        //getWindow().getDecorView().getLocationOnScreen(parentloc);
        int x = loc[0] - parentloc[0];
        int y = loc[1] - parentloc[1];
        mGuideRectF = new RectF(x, y, x + v.getMeasuredWidth(), y + v.getMeasuredHeight());
        DemoDebug.log("onPreDraw " + mGuideRectF);
        mGuide.invalidate();
        mGuide.requestLayout();
    }

    @Override
    public void onGuideHide() {
        DemoDebug.log("onGuideHide");
    }
}
