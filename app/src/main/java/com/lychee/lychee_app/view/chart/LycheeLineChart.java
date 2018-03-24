package com.lychee.lychee_app.view.chart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnDrawListener;

/**
 * Created by quf93 on 2018-03-19.
 */

public class LycheeLineChart extends LycheeChart {

    OnDrawListener onDrawListener;



    public LycheeLineChart(Context context) {
        super(context);

    }

    public LycheeLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LycheeLineChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
