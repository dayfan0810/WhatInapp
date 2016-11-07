package com.hope.com.whatinapp;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Day on 2016/11/5.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
