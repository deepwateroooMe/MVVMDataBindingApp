package com.me.sample.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class BaseApplicationJava extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}