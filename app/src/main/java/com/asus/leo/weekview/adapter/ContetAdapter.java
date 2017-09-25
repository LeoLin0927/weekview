package com.asus.leo.weekview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asus.leo.weekview.R;
import com.asus.leo.weekview.common.WeekViewData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Leo4_Lin on 2017/9/22.
 */

public class ContetAdapter extends  RecyclerView.Adapter<ContetAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<WeekViewData> mData;
    private Drawable mImage;
    public ContetAdapter(Context context, ArrayList<WeekViewData> data){
        mContext = context;
        mData = data;
    }

    //設定view元件
    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView image;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView)v.findViewById(R.id.contact_text);
            image = (ImageView)v.findViewById(R.id.contact_img);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_content, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.setImageDrawable(mData.get(position).getImage());
        holder.textView.setText(mData.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
