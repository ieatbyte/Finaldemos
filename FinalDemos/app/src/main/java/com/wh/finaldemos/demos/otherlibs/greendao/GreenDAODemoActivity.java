package com.wh.finaldemos.demos.otherlibs.greendao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.wh.finaldemos.App;
import com.wh.finaldemos.R;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.BookItem;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.DaoSession;

import java.util.List;

public class GreenDAODemoActivity extends AppCompatActivity {

    DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_daodemo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDaoSession = ((App)getApplication()).getDaoSession();
        mDaoSession.getBookItemDao();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                BookItem bi = new BookItem();
                bi.setPublisher("chchod");
                bi.setUUcode("TH_789456132");
                bi.setDescription("des" + System.currentTimeMillis());
                mDaoSession.getBookItemDao().save(bi);
                List<BookItem> bookes = mDaoSession.queryBuilder(BookItem.class).list();

                for (BookItem e : bookes) {
                    Log.e("GreenDAODemoActivity", e.toString());
                }
            }
        });
    }

}
