package com.whlib.testjavalib.string;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TrySubString extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        String a = "http://www.micro.com/ref/book/";
        String c = "full.zip";
        String b = c.substring(0, c.lastIndexOf(".zip"));
        Loger.d(b);
    }
}
