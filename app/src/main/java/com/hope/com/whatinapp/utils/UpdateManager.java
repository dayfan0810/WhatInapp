package com.hope.com.whatinapp.utils;

import android.content.Context;

import com.hope.com.whatinapp.domain.UpdateInfo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Day on 2016/8/24.
 */
public class UpdateManager {
    private Context mContext;

    public UpdateManager(Context mContext) {
        this.mContext = mContext;
    }

    public UpdateInfo getUpdateInfo(int urlid) throws Exception {
        String path = mContext.getResources().getString(urlid);
        URL url  = new URL(path);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(2000);
        urlConnection.setRequestMethod("GET");
        InputStream inputStream = urlConnection.getInputStream();
        UpdateInfo info = UpdateParser.getUpdateInfo(inputStream);
        return info;
    }
}
