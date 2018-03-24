package com.lychee.lychee_app.ui.main.record;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lychee.lychee_app.R;
import com.lychee.lychee_app.databinding.FragmentRecordBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {

    FragmentRecordBinding binding;
    Context context;

    public RecordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false);
        context = getActivity();

        init();

        return binding.getRoot();
    }

    private void init() {
        FragmentActivity activity = (FragmentActivity)context;
        binding.viewPager.setAdapter(new TabPagerAdapter(activity.getSupportFragmentManager()));
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
