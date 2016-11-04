package com.hope.com.whatinapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by Day on 2016/10/29.
 */

public class PagerSlidingTabStrip extends HorizontalScrollView {
    public PagerSlidingTabStrip(Context context) {
        this(context,null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, null,0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {



    }
}
