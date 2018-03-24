package com.lychee.lychee_app.ui.calender;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lychee.lychee_app.R;
import com.lychee.lychee_app.databinding.ActivityCalendarBinding;

public class CalenderActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);

        init();
    }

    private void init() {

    }
}
