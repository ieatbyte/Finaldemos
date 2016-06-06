package com.wh.finaldemos.demos.jsongson.basic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    public List<String> dataStrs;

    public String sn = "36060700000";
    public String eventId="36060700000_1464331425";
    public String eventCover="http://q.jia.360.cn/public/viewImage?imgKey=4785c009b7cfa8afabf784ed598fde5fc3113bd1-1-3-0-1920-1080.jpg&sn=36060700000";
    //public long eventTime="2016-05-27T14:43:45.000+0800";
    public long eventTime = 1464325749000L;
    public long eventDuration=33502;
    public String eventHls="http://g3.live.360.cn/vodplay?_rate=sd&channel=huikan_camera&dtype=non&sid=04840060d0b7fe15d41594a088c6a9b5&sn=_LC_3606070000014642257090112467_TX_1464331425&stype=m3u8&ts=1464343941&_sign=363d3ee23e18d26d4f08c09a0e7808eb";
    public String playKey="";
    public long size=4014552;
}
