package com.myapplication;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Crashlytics.log(Log.getStackTraceString(throwable));
        Crashlytics.logException(throwable);
        Crashlytics.setUserName("Saeed");
        Log.i("Log", "uncaughtException: ");
    }
}
