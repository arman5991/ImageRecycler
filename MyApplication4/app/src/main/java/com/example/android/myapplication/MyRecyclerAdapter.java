package com.example.android.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Model> list;
    private Context context;
    private Model m;

    public MyRecyclerAdapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyRecyclerAdapter.MyViewHolder holder, final int position) {
        holder.itemView1.setImageResource(R.drawable.nkar11);
        holder.itemView2.setImageResource(R.drawable.nkar12);
        holder.itemView3.setImageResource(R.drawable.nkar13);
        holderOnClickListener(holder, position);
    }

    private void holderOnClickListener(final MyViewHolder holder, final int position) {
        holder.itemView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(position + 1, m);
                initVisibility(holder, m);
                holder.imgMec.setImageDrawable(holder.itemView1.getDrawable());
            }
        });

        holder.itemView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(position + 1, m);
                initVisibility(holder, m);
                holder.imgMec.setImageDrawable(holder.itemView2.getDrawable());
            }
        });

        holder.itemView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(position + 1, m);
                initVisibility(holder, m);
                holder.imgMec.setImageDrawable(holder.itemView3.getDrawable());
            }
        });
    }

    private void initVisibility(MyViewHolder holder, Model m) {
        holder.itemView1.setVisibility(View.GONE);
        holder.itemView2.setVisibility(View.GONE);
        holder.itemView3.setVisibility(View.GONE);
        holder.imgMec.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemView1;
        private ImageView itemView2;
        private ImageView itemView3;
        private ImageView imgMec;

        MyViewHolder(View view) {
            super(view);
            itemView1 = view.findViewById(R.id.imgeview1);
            itemView2 = view.findViewById(R.id.imgeview2);
            itemView3 = view.findViewById(R.id.imgeview3);
            imgMec = view.findViewById(R.id.mec_img);

        }
    }

}