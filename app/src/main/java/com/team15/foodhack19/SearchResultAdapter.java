package com.team15.foodhack19;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.team15.foodhack19.objectClass.Receipe;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{
    private static final String TAG = "JAM";
    private ArrayList<Receipe> receipes;
    private Context mContext;

    public SearchResultAdapter(Context mContext, ArrayList<Receipe> receipes) {
        this.mContext = mContext;
        this.receipes = receipes;

    }
    private static String coolFormat(double n, int iteration) {
        char[] c = new char[]{'k', 'm', 'b', 't'};
        double d = ((long) n / 100) / 10.0;
        boolean isRound = (d * 10) %10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
        return (d < 1000? //this determines the class, i.e. 'k', 'm' etc
                ((d > 99.9 || isRound || (!isRound && d > 9.99)? //this decides whether to trim the decimals
                        (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
                ) + "" + c[iteration])
                : coolFormat(d, iteration+1));
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("JAM", "SearchResultAdapter: created");
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_searchresult, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.img_bg.setImageResource(R.drawable.beef);
        Log.d(TAG, "onBindViewHolder: " + receipes.get(i).getImageURL());
        viewHolder.txt_like_num.setText(coolFormat((double) receipes.get(i).getLikes(), 0));
        viewHolder.txt_profile_name.setText(receipes.get(i).getAuthor());
        viewHolder.txt_profile_title.setText(receipes.get(i).getAuthor_title());
        viewHolder.txt_receipe_Name.setText(receipes.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent startIntent = new Intent(mContext, recipeDetailActivity.class);
            startIntent.putExtra("recipe", receipes.get(viewHolder.getAdapterPosition()));
            Log.d("JAM", "onClick: Intent packed");
            mContext.startActivity(startIntent);
          }
        });
    }

    @Override
    public int getItemCount() {
        return receipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_bg;
        TextView txt_profile_name;
        TextView txt_profile_title;
        TextView txt_like_num;
        TextView txt_receipe_Name;
        ConstraintLayout lyt_parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_bg = itemView.findViewById(R.id.img_bg);
            txt_profile_name = itemView.findViewById(R.id.txt_profile_name);
            txt_profile_title = itemView.findViewById(R.id.txt_profile_title);
            txt_like_num = itemView.findViewById(R.id.txt_like_num);
            txt_receipe_Name = itemView.findViewById(R.id.txt_receipe_Name);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);
        }
    }
}
