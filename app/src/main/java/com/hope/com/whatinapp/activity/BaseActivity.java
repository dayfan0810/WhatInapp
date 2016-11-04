package com.hope.com.whatinapp.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by DAY on 7/22 0022.
 */

public abstract class BaseActivity extends FragmentActivity implements
        View.OnClickListener {
    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    /**
     * 是否允许全屏
     **/
    private boolean mAllowFullScreen = true;
    /**
     * 是否禁止旋转屏幕
     **/
    private boolean isAllowScreenRoate = false;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;
    /**
     * 是否输出日志信息
     **/
    private boolean isDebug;

    /**
     * 根布局
     */
    protected FrameLayout rootContent;

    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityCreated();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        clearContentView();
        getLayoutInflater().inflate(layoutResID, rootContent, true);
    }


    @Override
    public void setContentView(View view) {
        clearContentView();
        rootContent.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        clearContentView();
        rootContent.addView(view, params);
    }

    private void clearContentView() {
        rootContent.removeAllViews();

    }


    protected abstract void onActivityCreated();


    /**
     * [沉浸状态栏]
     */


    /**
     * [初始化Bundle参数]
     *
     * @param parms
     */
//    public abstract void initParms(Bundle parms);

    /**
     * [绑定布局]
     *
     * @return
     */
//    public abstract int bindLayout();

    /**
     * [重写： 1.是否沉浸状态栏 2.是否全屏 3.是否禁止旋转屏幕]
     */
    // public abstract void setActivityPre();

    /**
     * [初始化控件]
     *
     * @param view
     */
//    public abstract void initView(final View view);

    /**
     * [业务操作]
     *
     * @param mContext
     */
//    public abstract void doBusiness(Context mContext);

    /**
     * View点击
     **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }


    @Override
    protected void onResume() {
        super.onResume();
        $Log(TAG + "--->onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "--->onDestroy()");
    }

    /**
     * [是否允许全屏]
     *
     * @param allowFullScreen
    //     */
//    public void setAllowFullScreen(boolean allowFullScreen) {
//        this.mAllowFullScreen = allowFullScreen;
//    }


    /**
     * [是否允许屏幕旋转]
     *
     * @param isAllowScreenRoate
     */
//    public void setScreenRoate(boolean isAllowScreenRoate) {
//        this.isAllowScreenRoate = isAllowScreenRoate;
//    }

    /**
     * [日志输出]
     *
     * @param msg //
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }
}



