package com.wh.finaldemos.demos.textshow.StaticLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.wh.finaldemos.DemoDebug;

/**
 * Created by wanghui5-s on 2016/4/1.
 * <p/>
 * Conclusion:
 * #1:
 */
public class StaticLayoutDemoCustomView extends View {

    private Paint mPaint;

    public StaticLayoutDemoCustomView(Context context) {
        super(context);
        init();
        DemoDebug.log("1");
    }

    public StaticLayoutDemoCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        DemoDebug.log("2");
    }

    public StaticLayoutDemoCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        DemoDebug.log("3");
    }

    private void init() {
        mPaint = mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);

        TextPaint tp = new TextPaint();
        tp.setColor(Color.BLUE);
        tp.setStyle(Paint.Style.FILL);
        tp.setTextSize(50);
        String message = "paint,draw paint指用颜色画,如油画颜料、水彩或者水墨画,而draw 通常指用铅笔、钢笔或者粉笔画,后者一般并不涂上颜料。两动词的相应名词分别为p";
        StaticLayout myStaticLayout = new StaticLayout(message, tp, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        myStaticLayout.draw(canvas);

    }
}
