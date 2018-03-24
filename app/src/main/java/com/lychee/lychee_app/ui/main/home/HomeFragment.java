package com.lychee.lychee_app.ui.main.home;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.lychee.lychee_app.R;
import com.lychee.lychee_app.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    Context context;

    Drawable gradient_color;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        context = getActivity();

        init();

        setChart(binding.chart);

        return binding.getRoot();
    }

    private void setChart(LineChart chart) {
        chart.setBackgroundColor(Color.WHITE);

        chart.setDrawGridBackground(false);

        chart.setDrawBorders(false);

        chart.getDescription().setEnabled(false);

        chart.setPinchZoom(false);
        chart.setHighlightPerDragEnabled(false);
        chart.setHighlightPerTapEnabled(false);

        Legend l = chart.getLegend();
        l.setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setEnabled(false);
        chart.getAxisRight().setEnabled(false);

        // add data
        setData(chart, 20, 60);

        chart.invalidate();
    }

    private void init() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
            gradient_color = getResources().getDrawable(R.drawable.gradient_chart, context.getTheme());
        else gradient_color = getResources().getDrawable(R.drawable.gradient_chart);
    }

    private void setData(final LineChart chart, int count, float range) {
        List<Entry> vals = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 50;// + (float)
            // ((mult *
            // 0.1) / 10);
            vals.add(new Entry(i, val));
        }

        List<Entry> today = new ArrayList<>();
        today.add(new Entry(count, 20));

        LineDataSet set, todaySet;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set = (LineDataSet) chart.getData().getDataSetByIndex(0);
            set.setValues(vals);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set = new LineDataSet(vals, "DataSet 1");
            setLineDataSet(chart, set, false);

            todaySet = new LineDataSet(today, "Today");
            setLineDataSet(chart, todaySet, true);


            List<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set); // add the datasets
            dataSets.add(todaySet);

            // create a data object with the datasets
            LineData data = new LineData(dataSets);
            data.setDrawValues(false);

            // set data
            chart.setData(data);
        }
    }

    private void setLineDataSet(final LineChart chart, LineDataSet set, boolean isDrawCircle) {
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(Color.TRANSPARENT); // 등고선
        set.setDrawCircles(isDrawCircle); // true : 모든 data 에 circle 을 그린다

        set.setLineWidth(2f);
        set.setCircleRadius(3f);
        set.setFillAlpha(255);
        set.setDrawFilled(true);
        set.setFillDrawable(gradient_color);
        set.setHighLightColor(Color.TRANSPARENT); // 따라다니는 선
        set.setDrawCircleHole(false); //
        set.setFillFormatter(new IFillFormatter() {
            @Override
            public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                return chart.getAxisLeft().getAxisMinimum();
            }
        });
    }
}
