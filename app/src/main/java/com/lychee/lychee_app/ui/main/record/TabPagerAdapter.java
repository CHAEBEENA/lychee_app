package com.lychee.lychee_app.ui.main.record;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * 지출 - 수입 Tab Adapter
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    Fragment exp, inc;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            if(exp == null) exp = new ExpenditureFragment();
            return exp;
        } else {
            if(inc == null) inc = new IncomeFragment();
            return inc;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
