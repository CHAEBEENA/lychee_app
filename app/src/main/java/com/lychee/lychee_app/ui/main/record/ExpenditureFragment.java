package com.lychee.lychee_app.ui.main.record;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lychee.lychee_app.R;


/**
 *  지출 내역을 보여주는 Fragment
 */
public class ExpenditureFragment extends Fragment {


    public ExpenditureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expenditure, container, false);
    }

}
