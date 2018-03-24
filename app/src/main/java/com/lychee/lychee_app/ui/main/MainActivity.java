package com.lychee.lychee_app.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lychee.lychee_app.R;
import com.lychee.lychee_app.databinding.ActivityMainBinding;
import com.lychee.lychee_app.ui.main.home.HomeFragment;
import com.lychee.lychee_app.ui.main.map.MapFragment;
import com.lychee.lychee_app.ui.main.record.RecordFragment;
import com.lychee.lychee_app.ui.main.settings.SettingsFragment;
import com.lychee.lychee_app.ui.main.stats.StatsFragment;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int previous; // navigator 의 position 을 추적하기 위한 variable

    int activeColor, inactiveColor;

    Fragment home, record, map, stats, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

    private void init() {
        home = new HomeFragment();

        addFrag(home);

        previous = R.id.home;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activeColor = getResources().getColor(R.color.active_color, getTheme());
            inactiveColor = getResources().getColor(R.color.inactive_color, getTheme());
        } else {
            activeColor = getResources().getColor(R.color.active_color);
            inactiveColor = getResources().getColor(R.color.inactive_color);
        }
    }

    public void onClick(View view) {
        int current = view.getId();

        if (previous == current) return;

        showFrag(current);
        activateColor(current);

        hideFrag();
        inactivateColor();

        previous = current;
    }

    private void addFrag(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    private void showFrag(int current) {
        switch (current) {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(home)
                        .commit();
                break;
            case R.id.record:
                if(record != null)
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(record)
                            .commit();
                else {
                    record = new RecordFragment();
                    addFrag(record);
                }
                break;
            case R.id.map:
                if(map != null)
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(map)
                            .commit();
                else {
                    map = new MapFragment();
                    addFrag(map);
                }
                break;
            case R.id.stats:
                if (stats != null)
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(stats)
                            .commit();
                else {
                    stats = new StatsFragment();
                    addFrag(stats);
                }
                break;
            case R.id.settings:
                if (settings != null)
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(settings)
                            .commit();
                else {
                    settings = new SettingsFragment();
                    addFrag(settings);
                }
                break;
        }
    }

    private void activateColor(int current) {
        switch (current) {
            case R.id.home:
                binding.homeIcon.setColorFilter(activeColor);
                binding.homeText.setTextColor(activeColor);
                break;
            case R.id.record:
                binding.recordIcon.setColorFilter(activeColor);
                binding.recordText.setTextColor(activeColor);
                break;
            case R.id.map:
                binding.mapIcon.setColorFilter(activeColor);
                binding.mapText.setTextColor(activeColor);
                break;
            case R.id.stats:
                binding.statsIcon.setColorFilter(activeColor);
                binding.statsText.setTextColor(activeColor);
                break;
            case R.id.settings:
                binding.settingsIcon.setColorFilter(activeColor);
                binding.settingsText.setTextColor(activeColor);
                break;
        }
    }

    private void hideFrag() {
        switch (previous) {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(home)
                        .commit();
                break;
            case R.id.record:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(record)
                        .commit();
                break;
            case R.id.map:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(map)
                        .commit();
                break;
            case R.id.stats:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(stats)
                        .commit();
                break;
            case R.id.settings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(settings)
                        .commit();
                break;
        }
    }

    private void inactivateColor() {
        switch (previous) {
            case R.id.home:
                binding.homeIcon.setColorFilter(inactiveColor);
                binding.homeText.setTextColor(inactiveColor);
                break;
            case R.id.record:
                binding.recordIcon.setColorFilter(inactiveColor);
                binding.recordText.setTextColor(inactiveColor);
                break;
            case R.id.map:
                binding.mapIcon.setColorFilter(inactiveColor);
                binding.mapText.setTextColor(inactiveColor);
                break;
            case R.id.stats:
                binding.statsIcon.setColorFilter(inactiveColor);
                binding.statsText.setTextColor(inactiveColor);
                break;
            case R.id.settings:
                binding.settingsIcon.setColorFilter(inactiveColor);
                binding.settingsText.setTextColor(inactiveColor);
                break;
        }
    }


}
