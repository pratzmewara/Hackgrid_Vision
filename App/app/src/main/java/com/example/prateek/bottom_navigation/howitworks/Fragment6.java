package com.example.prateek.bottom_navigation.howitworks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kartikbhardwaj.bottom_navigation.R;

import androidx.fragment.app.Fragment;

public class Fragment6 extends Fragment {
    private View view;


    ImageView slide;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragmenthow6, container, false);
        slide=view.findViewById(R.id.imghow6);


        return view;
    }

    public static Fragment6 newInstance() {
        Fragment6 fragment6= new Fragment6();
        Bundle bundle = new Bundle();
        fragment6.setArguments(bundle);

        return fragment6;
    }
}
