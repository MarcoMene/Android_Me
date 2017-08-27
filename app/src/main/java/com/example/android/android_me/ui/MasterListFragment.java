package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by marcomeneghelli on 8/27/17.
 */

public class MasterListFragment extends Fragment {

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

//        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        // Get a reference to the ImageView in the fragment layout
        final GridView gridView = (GridView) rootView.findViewById(R.id.fragment_master_list_grid_view);

        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        gridView.setNumColumns(3);

        MasterListAdapter masterListAdapter = new MasterListAdapter(inflater.getContext(),
                AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        return rootView;

    }
}
