package com.example.ecurrency.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecurrency.R;

public class rAdapter extends RecyclerView.Adapter<rAdapter.rViewAdapter> {
    public static class rViewAdapter extends RecyclerView.ViewHolder{
        public TextView description,name;
        public ImageView imageDis;
        public Double value;
        public rViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.reminder_card_name);
            description = itemView.findViewById(R.id.reminder_card_description);
            imageDis = itemView.findViewById(R.id.reminder_card_img);
        }
    }
    @NonNull
    @Override
    public rViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull rViewAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
