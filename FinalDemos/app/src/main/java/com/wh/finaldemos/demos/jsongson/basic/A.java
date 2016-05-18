package com.wh.finaldemos.demos.jsongson.basic;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wanghui5-s on 2016/5/18.
 * <p/>
 * Conclusion:
 * #1:
 */
public class A {

    @SerializedName("1")
    public int a;

    public int b = 10;

    public HB data = new HB();
}
