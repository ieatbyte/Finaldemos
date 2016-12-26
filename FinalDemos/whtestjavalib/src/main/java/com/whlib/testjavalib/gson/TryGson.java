package com.whlib.testjavalib.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by wanghui on 16-12-26.
 */

public class TryGson extends ABaseTry{

    public static class DemoClass {
        public int a;

        public String b;

        public JsonElement c;
    }

    @Override
    public void startTry() {
        super.startTry();

        //try1();
        try2();
    }

    private void try2() {
        Gson gson = new Gson();
        String jsonString = "{a:10, b:hello, c:{a:b, b:c, c:[{d:e}, {e:f}]}}";
        try {
            DemoClass dc = gson.fromJson(jsonString, DemoClass.class);
            Loger.d("dc" + dc.c.toString());
            JSONObject jsonObject = new JSONObject(dc.c.toString());
            Loger.d("jsonObject:" + jsonObject.get("b") + ", " + jsonObject.keys().next());
        } catch (Exception e) {
            Loger.d("" + e);
        }
    }

    private void try1() {
        String content = "{\"a\":tru}";
        Gson gson = new Gson();
        JsonElement je = gson.fromJson(content, JsonElement.class);
        JsonObject jo = null;
        String test1 = new String("helloabc");
        String test2 = null;
        try {
            jo = je.getAsJsonObject();
            jo.addProperty("pp", "789");
            JSONObject jsO = new JSONObject(jo.toString());
            Loger.d("jo:" + jo.toString() + ", " + jo.entrySet());
            for (Map.Entry e : jo.entrySet()) {
                Loger.d("key:" + e.getKey() + ", value:" +e.getValue() + ", " + jsO.get(e.getKey().toString()));
            }
            test2 = jsO.toString();
            JSONObject jsO2 = new JSONObject("{b:c}");
            Loger.d("jsO2:" + jsO2.toString() + ", " + jsO2.get("b"));

            String a1 = new String("{a:b, b:c, c:[{d:e}, {e:f}]}");
            JSONObject ja1 = new JSONObject(a1);

            Loger.d("ja1:" + ja1);
        } catch (Exception e) {
            Loger.d("" + e);
        }
        Loger.d("test1:" + test1 + ", test2:" + test2.toString());
    }
}
