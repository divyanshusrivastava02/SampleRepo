package com.batch4.Fragments;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Divyanshu on 28-08-2016.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DeatilsFragment deatilsFragment = new DeatilsFragment();

        deatilsFragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(android.R.id.content,deatilsFragment).commit();
    }
}
