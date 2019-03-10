package com.example.prateek.bottom_navigation;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ReferralFragment extends Fragment {

    Button referralButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.referral_fragment,null);
   }

    @Override
    public void onViewCreated(@NonNull final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        referralButton = view.findViewById(R.id.invitebutton);
        final Context context = getContext();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStart() {
        super.onStart();
        Fresco.initialize(getContext());
        final Activity activity = getActivity();
        referralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Join me on TradeRoyale ,a financial services app by PrasannAndCo.Enter my code ###### and get 10 GoldCoins. https://www.youtube.com/watch?v=34Na4j8AVgA&list=RD34Na4j8AVgA&start_radio=1");
                sendIntent.setType("text/plain");
                startActivityForResult(sendIntent, 1);

            }
        });
    }
}
