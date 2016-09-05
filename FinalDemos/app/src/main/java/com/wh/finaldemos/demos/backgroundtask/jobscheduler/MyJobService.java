package com.wh.finaldemos.demos.backgroundtask.jobscheduler;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

@SuppressLint("NewApi")
public class MyJobService extends JobService {
    public MyJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("MyJobService", "MyJobService onStartJob");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("MyJobService", "MyJobService onStopJob");
        return false;
    }
}
