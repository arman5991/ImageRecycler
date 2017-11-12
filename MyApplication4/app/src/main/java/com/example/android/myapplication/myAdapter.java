package com.example.android.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class myAdapter extends BaseAdapter implements View.OnClickListener {
    private List<Model> list;
    private Context context;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView imgMec;
    private Model m;
    private int x;

    public myAdapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Model getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View rootView = layoutInflater.inflate(R.layout.list_item, viewGroup, false);

        img1 = rootView.findViewById(R.id.imgeview1);
        img2 = rootView.findViewById(R.id.imgeview2);
        img3 = rootView.findViewById(R.id.imgeview3);
        imgMec = rootView.findViewById(R.id.mec_img);
//        imgMec.setVisibility(View.VISIBLE);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);

        img1.setImageResource(getItem(i).getImg1());
        img2.setImageResource(getItem(i).getImg2());
        img3.setImageResource(getItem(i).getImg3());
//        imgMec.setImageResource(getItem(i).getImgMec());
        return rootView;
    }

    public void addImage(int y) {

        list.add(y +1, m);
//        Model m = new Model();
//        m.setImgMec(R.drawable.nkar9);
//        list.add((y + 1), m);
//        notifyDataSetChanged();
    }

    public void getPos(int pos) {
        this.x = pos;
        Log.i("sssssssssssssssss", pos + "");
//        addImage(x);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgeview1: {
                if (initVisibility()){
                    list.remove(inter(x));
                }
                addImage(x);
                imgMec.setImageResource(getItem(x).getImg1());
                initVisibility();
                break;
            }
            case R.id.imgeview2: {
                if (initVisibility()){
                    list.remove(inter(x));
                }
                addImage(x);
                imgMec.setImageResource(getItem(x).getImg2());
                initVisibility();
                break;
            }
            case R.id.imgeview3: {
                if (initVisibility()){
                    list.remove(inter(x));
                }
                addImage(x);
                imgMec.setImageResource(getItem(x).getImg3());
                initVisibility();
                break;
            }
        }
    }

    private int inter(int inter) {
        return inter + 1;
    }

    private boolean initVisibility() {
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        imgMec.setVisibility(View.VISIBLE);
        return true;
    }
}
