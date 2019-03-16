package com.team15.foodhack19;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team15.foodhack19.objectClass.Dish;

import java.util.ArrayList;
import java.util.List;

public class FavoriateFragment extends Fragment {
    View favoriateView;
    List<Dish> lstDish;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstDish = new ArrayList<>();
        lstDish.add(new Dish("Ethan Calabrese","Category Book","Description Book",R.drawable.spaghetti));
        lstDish.add(new Dish("Buddha Bowls","Category Book","Description Book",R.drawable.delish));
        lstDish.add(new Dish("Pesto Penne","Category Book","Description Book",R.drawable.penne));
        lstDish.add(new Dish("Blackened Tilapia","Category Book","Description Book",R.drawable.tilapia));
        lstDish.add(new Dish("Creamy Lemon Garlic Salmon","Category Book","Description Book",R.drawable.salmon));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        favoriateView = inflater.inflate(R.layout.favoriate, container, false);


        RecyclerView myrv = (RecyclerView)favoriateView.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstDish);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);

        // The below two lines cause BUG!!!!!!!!!!!!!!!!!!!!!!!!!
//        myrv.setLayoutManager(layoutManager);
//        myrv.setAdapter(myAdapter);


        return favoriateView;
    }

}