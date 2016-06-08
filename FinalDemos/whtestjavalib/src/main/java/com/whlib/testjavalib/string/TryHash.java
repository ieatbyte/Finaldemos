package com.whlib.testjavalib.string;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import java.util.HashSet;

/**
 * Created by wanghui5-s on 2016/6/8.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TryHash extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        String a = new String("abc");
        String b = new String("abc");

        Loger.d("a hash:" + a.hashCode() + ", b hash:" + b.hashCode());
        HashSet<String> strHash = new HashSet<>();
        strHash.add(a);
        Loger.d("has:" + strHash.contains(b));
    }
}
