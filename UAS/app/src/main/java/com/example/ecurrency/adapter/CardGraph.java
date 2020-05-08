package com.example.ecurrency.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecurrency.R;
import com.example.ecurrency.model.Graph;

import java.util.ArrayList;

public class CardGraph extends RecyclerView.Adapter<CardGraph.GraphViewHolder> {

    private Context context;
    private ArrayList<Graph> listGraph = new ArrayList<>();

    public CardGraph(Context context) {
        this.context = context;
    }

    public void setListGraph(ArrayList<Graph> list){
        listGraph.clear();
        listGraph.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GraphViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_graph, parent, false);
        return new GraphViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphViewHolder holder, int position) {
        Graph graph = listGraph.get(position);
        holder.state.setText(graph.getState());
        holder.currency.setText(graph.getCurrency());
        holder.value.setText(graph.getValue());
    }

    @Override
    public int getItemCount() {
        return listGraph.size();
    }

    public class GraphViewHolder extends RecyclerView.ViewHolder {

        TextView state,currency,value;

        public GraphViewHolder(@NonNull View itemView) {
            super(itemView);
            state = itemView.findViewById(R.id.cv_state);
            currency = itemView.findViewById(R.id.cv_currency);
            value = itemView.findViewById(R.id.cv_value);
        }
    }
}
