package com.whlib.testjavalib.guava;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import java.nio.charset.Charset;

/**
 * Created by wanghui on 16-12-21.
 */

public class TryGuava extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        HashFunction hf = Hashing.sha1();
        int a = hf.hashInt(123).asInt();
        String b = hf.hashString("1", Charset.forName("utf-8")).toString();
        String c = hf.hashString("2", Charset.forName("utf-8")).toString();
        String d = Hashing.sha1().hashString("3", Charset.forName("utf-8")).toString();
        Loger.d("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
    }

}
