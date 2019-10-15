package com.example.tutorial2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFrag extends Fragment {

    View view;
    ImageView profilePic;
    TextView nameTv;
    TextView descriptionTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        //Inflate View
        profilePic = view.findViewById(R.id.profilePic);
        nameTv = view.findViewById(R.id.nameTv);
        descriptionTv = view.findViewById(R.id.infoTv);

        return view;
    }

}
