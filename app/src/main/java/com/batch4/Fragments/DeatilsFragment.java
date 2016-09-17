package com.batch4.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Divyanshu on 28-08-2016.
 */
public class DeatilsFragment extends Fragment {

    public static DeatilsFragment newInstance(int index){
        DeatilsFragment f = new DeatilsFragment();

        Bundle args = new Bundle();
        args.putInt("index",index);
        f.setArguments(args);
        return f;
    }

    public int getShowIndex(){
        return getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setText(Data.DETAILS[getShowIndex()]);
        return text;
    }
}
