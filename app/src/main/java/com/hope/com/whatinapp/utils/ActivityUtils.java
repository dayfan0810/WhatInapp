package com.hope.com.whatinapp.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Day on 2016/8/11.
 */
public class ActivityUtils {
    public static void toNextActivity(Context mContext, Class<?> cls){
        Intent i = new Intent(mContext, cls);
        mContext.startActivity(i);
    }
}
