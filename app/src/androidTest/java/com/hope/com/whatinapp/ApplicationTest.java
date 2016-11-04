package com.hope.com.whatinapp;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.hope.com.whatinapp.domain.UpdateInfo;
import com.hope.com.whatinapp.utils.UpdateManager;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    public void testfGetinfo() throws Exception{
        UpdateManager updateManager = new UpdateManager(getContext());
        UpdateInfo updateInfo = updateManager.getUpdateInfo(R.string.updateurl);
        assertEquals("2.0",updateInfo.getVersion());


    }
}