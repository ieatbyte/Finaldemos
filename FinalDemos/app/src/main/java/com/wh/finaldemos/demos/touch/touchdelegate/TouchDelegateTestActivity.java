package com.wh.finaldemos.demos.touch.touchdelegate;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

public class TouchDelegateTestActivity extends AppCompatActivity {

    XLog logger = new XLog(TouchDelegateTestActivity.class, true, true);

    private Button click_me;

    private Button click_me2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_delegate_activity_main);
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
        click_me2 = (Button)findViewById(R.id.click_me2);
        click_me2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logger.e("click me 2");
            }
        });
        // #1
        click_me2.setVisibility(View.GONE);
        click_me = (Button)findViewById(R.id.click_me);
        click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logger.e("click me 1");
            }
        });
        click_me.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Rect delegateRegion = new Rect();
                View parent = (View)click_me.getParent();
                delegateRegion.set(0, 0, parent.getWidth(), parent.getHeight());
                logger.e("touchDelegate rect:" + delegateRegion);
                TouchDelegate touchDelegate = new TouchDelegate(delegateRegion, click_me);
                parent.setTouchDelegate(touchDelegate);
                parent.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        logger.e("parent onTouch");
                        return false;
                    }
                });
                click_me.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
