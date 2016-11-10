package com.hope.com.whatinapp.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hope.com.whatinapp.R;
import com.hope.com.whatinapp.domain.UpdateInfo;
import com.hope.com.whatinapp.utils.ActivityUtils;
import com.hope.com.whatinapp.utils.NetUtils;
import com.hope.com.whatinapp.utils.UpdateManager;

/**
 * Created by DAY on 7/17 0017.
 */
public class EnterActivity extends AppCompatActivity {
    public static final String TAG = "EnterActivity";
    private UpdateInfo updateInfo;
    private UpdateInfo info;
    private static final int NET_CONNECTED_SUCCESS = 1;
    private static final int NET_CONNECTED_FAILED = 0;

    private String versionName;
    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    // TODO: 2016/8/11 接受 没有 网络的msg，直接跳转到主界面
                    Intent intent = new Intent(EnterActivity.this, MainActivity.class);
                    startActivity(intent);

                    overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                    finish();
                    break;
                case 1:
                    // TODO: 2016/8/11 接受 有 网络的msg 去检查更新包 ,如果需要更新就弹出对话框,否则直接进入MainActivity
                    if (idNeedUpdate(versionName)) {
                        callSysDownload();
                    }
            }
        }


    };

    private void callSysDownload() {
        //TODO

    }


    private boolean idNeedUpdate(String versionText) {
        UpdateManager updateManager = new UpdateManager(this);
        try {
            updateInfo = updateManager.getUpdateInfo(R.string.updateurl);
            String version = updateInfo.getVersion();
            if (versionText.equals(version)) {
                //无需升级
                ActivityUtils.toNextActivity(EnterActivity.this, MainActivity.class);
                overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                return false;
            } else {
                //需要升级返回true
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            //获取更新异常,直接进入
            ActivityUtils.toNextActivity(EnterActivity.this, MainActivity.class);
            overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String versionName = getVersionName();
        enterJudgedByNet();
    }

    private String getVersionName() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void enterJudgedByNet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                if (NetUtils.isWifiConnected(getApplicationContext())) {
                    // TODO: 2016/8/11 给主线程发送有has wifi的msg 去检查更新包 弹出对话框 提示是否下载更新包
                    message.what = 1;
                    mHandler.sendMessage(message);
                } else {
                    // TODO: 2016/8/11 给主线程发送no wifi的msg，直接跳转到主界面
                    message.what = 0;
                    mHandler.sendMessage(message);
                }
            }
        }).start();
    }
}