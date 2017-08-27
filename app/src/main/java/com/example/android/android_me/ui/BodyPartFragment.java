package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
//import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcomeneghelli on 8/26/17.
 */

public class BodyPartFragment extends Fragment {

    public final String KEY_IMG_IDS = "img_ids";
    public final String KEY_CURRENT_IMG_ID = "img_id";

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);


        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(KEY_IMG_IDS);
            mListIndex = savedInstanceState.getInt(KEY_CURRENT_IMG_ID);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

//        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));  // Hard coded solution
        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            // Add click listener here
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ++mListIndex;
                    if (mListIndex >= mImageIds.size()){
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        } else {
            Log.v(TAG, "Null list of image ids.");
        }

        return rootView;

    }

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(KEY_IMG_IDS, (ArrayList<Integer>) mImageIds);
        currentState.putInt(KEY_CURRENT_IMG_ID, mListIndex);
    }
}
