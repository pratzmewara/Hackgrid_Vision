package com.example.prateek.bottom_navigation.howitworks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kartikbhardwaj.bottom_navigation.R;

import androidx.fragment.app.Fragment;

public class Fragment5 extends Fragment {
    private View view;


    ImageView slide;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragmenthow5, container, false);
        slide=view.findViewById(R.id.imghow5);


        return view;
    }

    public static Fragment5 newInstance() {
        Fragment5 fragment5 = new Fragment5();
        Bundle bundle = new Bundle();
        fragment5.setArguments(bundle);

        return fragment5;
    }
}
