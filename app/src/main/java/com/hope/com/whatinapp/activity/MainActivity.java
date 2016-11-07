package com.hope.com.whatinapp.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hope.com.whatinapp.R;
import com.hope.com.whatinapp.utils.StateBarTranslucentUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends BaseActivity {
    @ViewInject(R.id.bar_disco)
    Button bar_disco;
    @ViewInject(R.id.bar_music)
    private ImageView bar_music;
    @ViewInject(R.id.bar_friends)
    private ImageView bar_friends;
    @ViewInject(R.id.view_pager)
    private ViewPager view_pager;
    @ViewInject(R.id.navigation_view)
    private NavigationView mNavigationView;
    @ViewInject(R.id.tool_bar)
    private Toolbar toolbar;
    @ViewInject(R.id.drawerIcon)
    private ImageView drawerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        initView();

    }


    @Override
    protected void initView() {
        super.initView();
        StateBarTranslucentUtils.setStateBarTranslucent(this);

        //获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight = getResources().getDimensionPixelSize(resourceId);
        //设置margin
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        toolbar.setLayoutParams(layoutParams);
    }
}
