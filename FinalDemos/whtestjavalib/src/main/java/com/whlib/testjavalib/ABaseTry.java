package com.whlib.testjavalib;

/**
 * Created by wanghui5-s on 2015/11/25.
 */
public class ABaseTry implements ATry {

    @Override
    public void startTry() {
        Loger.d("****** startTry " + getClass().getSimpleName());
    }

    @Override
    public void outputConclusionIfTryDone(String... conclusions) {
        Loger.d("$ " + getClass().getSimpleName() + " Conclusion: ");
        if (conclusions != null && conclusions.length > 0) {
            int i = 0;
            for (String e : conclusions) {
                Loger.d("#" + i++ + ": " + e);
            }
        } else {
            Loger.d("$ No conclusion.");
        }
        Loger.d("****** Done.");
    }
}
