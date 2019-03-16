package com.team15.foodhack19;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FavoriateFragment extends Fragment {
    View favoriateView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        favoriateView = inflater.inflate(R.layout.favoriate, container, false);
        return favoriateView;
    }
}