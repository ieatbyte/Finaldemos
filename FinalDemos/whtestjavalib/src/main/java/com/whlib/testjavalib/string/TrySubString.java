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

//        String a = "http://www.micro.com/ref/book/";
//        String c = "full.zip";
//        String b = c.substring(0, c.lastIndexOf(".zip"));
//        Loger.d(b);

        String a = "-5G";//"360-test-xsd1-19-5G";
        String b = "360-test-xsd1-19";

        Loger.d("a processed:" + a.substring(0, a.lastIndexOf("-5G")).length());

        String originWifiName = "\"\"";
        if (originWifiName.length() > 1 && originWifiName.startsWith("\"") && originWifiName.endsWith("\"")){
            originWifiName = originWifiName.substring(1, originWifiName.length()-1);
        }
        Loger.d("result:" + originWifiName);
    }

}
