package com.example.josewanderlucio.poketagend.adapter;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josewanderlucio.poketagend.R;
import com.example.josewanderlucio.poketagend.model.Evento;


import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Evento> eventos;
    private Context context;




    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public TextView tvText01;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);

            tvText01 = (TextView) v.findViewById(R.id.tvText01);

            cardView = (CardView) v.findViewById(R.id.cardview);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<Evento> evento  ) {
        this.eventos = evento;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_a, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvText01.setText(eventos.get(position).getTitulo());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:987908770"));
            context.startActivity(it);
            }

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return eventos.size();
    }
}