package com.lychee.lychee_app.view.chart;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by quf93 on 2018-03-19.
 *
 * Data / Paint /
 */

public class LycheeChart extends ViewGroup {

    Paint paint;

    public LycheeChart(Context context) {
        super(context);
    }

    public LycheeChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LycheeChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
