package com.example.ecurrency.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecurrency.R;

import java.util.ArrayList;

public class CardNews extends RecyclerView.Adapter<CardNews.NewsViewHolder>{

    private Context context;
    private ArrayList<News> listNews = new ArrayList<>();

    public CardNews(Context context) {
        this.context = context;
    }

    public void setListNews(ArrayList<News> list){
        listNews.clear();
        listNews.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = listNews.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        holder.newsimg.setText(news.getNewsimg());
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, newsimg;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            newsimg = itemView.findViewById(R.id.newsimg);
        }
    }
}
