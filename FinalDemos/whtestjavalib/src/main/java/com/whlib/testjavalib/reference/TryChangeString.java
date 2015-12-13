package com.whlib.testjavalib.reference;

import com.whlib.testjavalib.ABaseTry;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TryChangeString extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        String a = "abc";
        String b = new String("abc");
        changeStr(a);
        System.out.println(a);
        changeStr(b);
        System.out.println(b);
    }

    private static void changeStr(String c) {
        c = "cde";
    }
}
