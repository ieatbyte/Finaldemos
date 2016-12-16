package com.wh.finaldemos.demos.otherlibs.greendao.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import static com.wh.finaldemos.demos.otherlibs.rxjava.RXDemoActivity.TAG;

/**
 * Created by wanghui on 16-12-15.
 */

public class MyOpenHelper extends DaoMaster.DevOpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.e("MyOpenHelper", "onUpgrade oldVersion:" + oldVersion + ", newVersion:" + newVersion);

        int version = oldVersion;
        if (version < 2) {
            db.beginTransaction();
            try {
                db.execSQL("ALTER TABLE book_items " +
                        "ADD COLUMN description VARCHAR(64);");
                db.setTransactionSuccessful();
                version = 2;
            } catch (SQLException ex) {
                // Old version remains, which means we wipe old data
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                db.endTransaction();
            }

        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("MyOpenHelper", "onDowngrade oldVersion:" + oldVersion + ", newVersion:" + newVersion);
        DaoMaster.dropAllTables(wrap(db), true);
    }
}
