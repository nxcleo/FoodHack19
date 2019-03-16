package com.team15.foodhack19;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team15.foodhack19.objectClass.Dish;

import java.util.List;

/**
 * Created by Siyang Sun on 16/3/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Dish> mData;

    public RecyclerViewAdapter (Context mContext, List<Dish> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position) {

        holder.tv_dish_title.setText(mData.get(position).getTitle());
        holder.img_dish_thumbnail.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_dish_title;
        ImageView img_dish_thumbnail;

        public MyViewHolder (View itemView){
            super(itemView);
            tv_dish_title = (TextView)itemView.findViewById(R.id.dish_title_id);
            img_dish_thumbnail = (ImageView)itemView.findViewById(R.id.dish_img_id);
        }
    }
}
