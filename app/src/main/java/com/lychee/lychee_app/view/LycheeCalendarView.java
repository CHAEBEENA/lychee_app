package com.lychee.lychee_app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by quf93 on 2018-03-20.
 */

public class LycheeCalendarView extends FrameLayout {

    public LycheeCalendarView(Context context) {
        super(context);
    }

    public LycheeCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LycheeCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        DataBindingUtil.inflate(inflater, , this, false);
    }
}
