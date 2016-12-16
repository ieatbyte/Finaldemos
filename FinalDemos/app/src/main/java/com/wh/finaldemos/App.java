package com.wh.finaldemos;

import android.app.Application;
import android.content.Context;

import com.wh.finaldemos.demos.otherlibs.greendao.dao.DaoMaster;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.DaoSession;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.MyOpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public class App extends Application {

    public static Context context;

    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        DaoMaster.DevOpenHelper helper = new MyOpenHelper(this,ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
