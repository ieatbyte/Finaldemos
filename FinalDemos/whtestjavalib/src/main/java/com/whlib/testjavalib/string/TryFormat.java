package com.whlib.testjavalib.string;

import com.whlib.testjavalib.ABaseTry;

/**
 * Created by wanghui5-s on 2016/10/27.
 * <p>
 * Conclusion:
 * #1:
 */

public class TryFormat extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

  //      String a = "http://%s%s?lang=%s";

        String b = "";

//        a = String.format(a, "at.123.com");
        b = "http://%s";
        b  = String.format(b, "www.abc.com");
        StringBuilder s2 = new StringBuilder(b);
        s2.append("%s?lang=%s");
//        System.out.println(a);
//        System.out.println(String.format(a, "/a/b", "zh_CN"));
        System.out.println(String.format(s2.toString(), "/a/b", "zh_CN"));

    }
}
