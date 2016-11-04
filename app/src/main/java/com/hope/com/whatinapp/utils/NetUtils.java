package com.hope.com.whatinapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Day on 2016/8/11.
 */
public class NetUtils {
    public static boolean isWifiConnected(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (null != connectivity) {

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    int type = info.getType();
                    switch (type) {
                        case ConnectivityManager.TYPE_MOBILE:
                            return false;
                        case ConnectivityManager.TYPE_WIFI:
                            return true;
                        default:
                            return false;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
