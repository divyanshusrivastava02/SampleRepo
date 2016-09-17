package com.batch4.Fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.batch4.R;

/**
 * Created by Divyanshu on 28-08-2016.
 */
public class TitlesFragment extends ListFragment {

    boolean mDualPane;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,Data.TITLES));


        View detailsFrame = getActivity().findViewById(R.id.details) ;
        mDualPane = detailsFrame !=null && detailsFrame.getVisibility()==View.VISIBLE;
        Toast.makeText(getActivity(),"mDualpane "+mDualPane,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index){


        //Landscape mode
        if(mDualPane){

            getListView().setItemChecked(index,true);
            DeatilsFragment deatilsFragment = (DeatilsFragment)getFragmentManager().findFragmentById(R.id.details);

            if(deatilsFragment==null || deatilsFragment.getShowIndex()!=index){
                deatilsFragment = DeatilsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details,deatilsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

        }
        //Potrait mode
        else {

            Intent intent = new Intent();
            intent.setClass(getActivity(),DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);

        }

    }
}
