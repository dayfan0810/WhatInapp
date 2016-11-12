package com.hope.com.whatinapp;

import android.app.Activity;
import android.app.Application;

import com.hope.com.whatinapp.utils.SharedPreferencesUtil;

import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by Day on 2016/11/5.
 */

public class MyApp extends Application {
    public static ArrayList<Activity> actitivitys = new ArrayList<>();
    public SharedPreferencesUtil sharedPreferencesUtil;
    @Override
    public void onCreate() {
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        super.onCreate();
        x.Ext.init(this);
    }
}
