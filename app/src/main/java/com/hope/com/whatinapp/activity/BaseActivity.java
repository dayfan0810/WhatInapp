package com.hope.com.whatinapp.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hope.com.whatinapp.R;
import com.hope.com.whatinapp.utils.SharedPreferencesUtil;

public class BaseActivity extends AppCompatActivity {
    public static int color = 0;

    public static int[] style = {R.style.AppTheme, R.style.AppThemeMaterial, R.style.DarkMode};
    public static String[] strings = {"material theme", "dark mode"};
    private SharedPreferencesUtil sharedPreferencesUtil;
    public static final int TYPE_THEME_MATERIAL = 1;
    public static final int TYPE_THEME_DARK = 2;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        setTheme();
        super.onCreate(savedInstanceState);

    }

    private void setTheme() {
        sharedPreferencesUtil.saveInt("theme", BaseActivity.TYPE_THEME_MATERIAL);
        getColor();
        setTheme();
    }

    private void getColor() {
        TextView s = new TextView(this);
        TypedArray array = getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.colorPrimary,
                android.R.attr.colorPrimaryDark,
        });

//        color = array.getColor(0, getResources().getColor(R.color.blue_theme));
        int textColor = array.getColor(1, 0xFF00FF);

        array.recycle();

    }
}