package com.wh.finaldemos.demos.customview.testcustomshapeimageview;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wh.finaldemos.R;
import com.whlib.alib.widget.CustomShapeImageView;
import com.whlib.alib.widget.RoundRectImageView;

public class TestCustomShapeImageViewActivity extends AppCompatActivity {

    CustomShapeImageView customShapeImageView;
    RoundRectImageView roundRectImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_shape_image_view);
        customShapeImageView = (CustomShapeImageView)(findViewById(R.id.demo_image));
        customShapeImageView.setBuildPathCallbackAfterMeasure(new CustomShapeImageView.BuildPathCallbackAfterMeasure() {

            RectF rectF = new RectF();

            @Override
            public void buildPath(Path path) {
                rectF.set(0, 0, customShapeImageView.getMeasuredWidth(), customShapeImageView.getMeasuredHeight());
                path.addRoundRect(rectF, customShapeImageView.getMeasuredWidth() / 2, customShapeImageView.getMeasuredHeight() / 2, Path.Direction.CW);
                //path.addRoundRect(rectF, 10, 10, Path.Direction.CW);
                //path.addCircle(customShapeImageView.getMeasuredWidth() / 2, customShapeImageView.getMeasuredHeight() / 2, 200, Path.Direction.CW);
            }
        });
        roundRectImageView = (RoundRectImageView)findViewById(R.id.demo_image_1);
        roundRectImageView.setRxRy(30f, 30f);
    }
}
