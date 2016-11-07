package com.hope.com.whatinapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hope.com.whatinapp.R;
import com.hope.com.whatinapp.utils.StateBarTranslucentUtils;

/**
 * Created by JiaQing on 2016/7/17.
 */
public class BaseActivity extends AppCompatActivity {

    protected String TAG = this.getClass().getSimpleName();

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    protected void initView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        //状态栏着色
        StateBarTranslucentUtils.setStateBarColor(this);

    }

}
