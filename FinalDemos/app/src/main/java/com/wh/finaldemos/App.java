package com.wh.finaldemos;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.DaoMaster;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.DaoSession;
import com.wh.finaldemos.demos.otherlibs.greendao.dao.MyOpenHelper;

import org.greenrobot.greendao.database.Database;

import java.io.InputStream;

import okhttp3.OkHttpClient;

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

        Glide.get(this).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(new OkHttpClient.Builder().build()));
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
