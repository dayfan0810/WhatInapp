package com.hope.com.whatinapp.activity;

import android.os.Bundle;
import android.view.View;

import com.hope.com.whatinapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityCreated() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
