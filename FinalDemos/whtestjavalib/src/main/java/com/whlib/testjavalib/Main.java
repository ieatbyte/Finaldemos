package com.whlib.testjavalib;

import com.whlib.testjavalib.string.TrySubString;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world!");
        startTry(TrySubString.class);
    }

    public static <T> void startTry(Class<? extends ATry> tryClass) {
        if (tryClass != null) {
            try {
                ATry aTry = (ATry) tryClass.newInstance();
                aTry.startTry();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
