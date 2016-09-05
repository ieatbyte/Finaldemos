package com.wh.finaldemos.demos.backgroundtask.jobscheduler;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;

import java.util.List;

@SuppressLint("NewApi")
public class JobSchedulerDemoActivity extends AppCompatActivity {

    ConnectivityManager connMgr;
    ConnectivityManager.NetworkCallback mNetworkCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduler_demo);
        scheduleJob(JobSchedulerDemoActivity.this);

        mNetworkCallback = new ConnectivityManager.NetworkCallback(){
            @Override
            public void onAvailable(Network network) {
                super.onAvailable(network);
                Log.e("NetworkRequest", "onAvailable network:" + network);
            }

            @Override
            public void onLosing(Network network, int maxMsToLive) {
                super.onLosing(network, maxMsToLive);
                Log.e("NetworkRequest", "onLosing");
            }

            @Override
            public void onLost(Network network) {
                super.onLost(network);
                Log.e("NetworkRequest", "onLost network:" + network);
            }

            @Override
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                Log.e("NetworkRequest", "onCapabilitiesChanged network:" + network + ", networkCapabilities:" + networkCapabilities);
            }

            @Override
            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
                Log.e("NetworkRequest", "onLinkPropertiesChanged");
            }
        };
        connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest nr = new NetworkRequest.Builder().build();
        connMgr.registerNetworkCallback(nr, mNetworkCallback);
    }

    @SuppressLint("NewApi")
    public static void scheduleJob(Context context) {
        JobScheduler js =
                (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo job = new JobInfo.Builder(
                0,
                new ComponentName(context, MyJobService.class))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPeriodic(1000)
                //.setRequiresCharging(true)
                .build();
        js.schedule(job);
        List<JobInfo> result = js.getAllPendingJobs();
        if (result != null) {
            Log.e("MyJobService", "MyJobService getAllPendingJobs size:" + result.size());
        } else {
            Log.e("MyJobService", "result is null");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        connMgr.unregisterNetworkCallback(mNetworkCallback);
    }
}
