package com.team15.foodhack19;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        favoriateView = inflater.inflate(R.layout.favoriate, container, false);

        return favoriateView;
    }
}