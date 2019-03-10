package com.example.prateek.bottom_navigation.notification;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.kartikbhardwaj.bottom_navigation.R;

import androidx.recyclerview.widget.RecyclerView;

import static android.view.View.GONE;

public class NotificationViewHolder extends RecyclerView.ViewHolder
{
    private String notifName, notifTime;
    private TextView notifNameTv, notifTimeTv;
    private ImageView tick;
    private LinearLayout notifll;


    public NotificationViewHolder(View itemView)
    {
        super(itemView);
        notifNameTv=itemView.findViewById(R.id.tv_notif_name);
        notifTimeTv=itemView.findViewById(R.id.tv_notif_time);
        tick=itemView.findViewById(R.id.tick);
        notifll=itemView.findViewById(R.id.notifll);
    }

    public void populate(NotificationModel notif)
    {
        notifName=notif.getNotifName();
        notifTime=notif.getNotifTime();

        notifNameTv.setText(notifName);
        notifTimeTv.setText(notifTime);
        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tick.setVisibility(GONE);
                notifNameTv.setVisibility(GONE);
                notifTimeTv.setVisibility(GONE);
                notifll.setVisibility(GONE);
            }
        });
    }


}
