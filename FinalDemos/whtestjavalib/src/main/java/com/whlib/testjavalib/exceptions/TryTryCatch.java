package com.whlib.testjavalib.exceptions;

import com.whlib.testjavalib.ABaseTry;

/**
 * Created by wanghui5-s on 2015/12/13.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TryTryCatch extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        try {
            System.out.println("try1");
            String a = null;
            a.length();
            return;
        }
//        catch(Exception e) {
//            System.out.println("try2");
//            return;
//        }
        finally {
            System.out.println("try3");
            return;
        }
        //System.out.println("try4");
    }
}
