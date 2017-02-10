package com.wh.finaldemos.demos.textshow.SysInfo;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

import java.lang.reflect.Field;

public class SysInfoShowActivity extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_info_show);

        ((TextView) findViewById(R.id.sys_info_board)).setText(buildSysInfo());
    }

    private String buildSysInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wifi info:" + getBSSID());
        stringBuilder.append("androidVersionCode=" + Build.VERSION.SDK_INT + "\n\n");
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                stringBuilder.append(field.getName() + "=" + field.get(null).toString() + "\n\n");
            } catch (Exception e) {
            }
        }
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        stringBuilder.append("maxMemory=" + String.valueOf(Runtime.getRuntime().maxMemory() / 1000f / 1000f) + "\n\n");
        stringBuilder.append("LargeMemoryClass=" + String.valueOf(am.getLargeMemoryClass()) + "\n\n");
        stringBuilder.append("MemoryClass=" + String.valueOf(am.getMemoryClass()) + "\n\n");
        stringBuilder.append("DisplayMetrics=" + getResources().getDisplayMetrics().toString() + "\n\n");
        return stringBuilder.toString();
    }

    private String getBSSID() {
        String result = "EMPTY";
        WifiInfo wi = ((WifiManager) getSystemService(Context.WIFI_SERVICE)).getConnectionInfo();
        if (wi != null) {
            result = "bssid:" + wi.getBSSID() + ", mac:" + wi.getMacAddress() + ", ssid:" + wi.getSSID() + ", network_id:" + wi.getNetworkId() + ", rssi:" + wi.getRssi();
        }
        return result;
    }
}
