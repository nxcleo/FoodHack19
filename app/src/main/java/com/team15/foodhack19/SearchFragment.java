package com.team15.foodhack19;

import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.team15.foodhack19.objectClass.Ingredent;
import com.team15.foodhack19.objectClass.Receipe;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    View searchView;


    private static final float[] NEGATIVE = {
            -1.0f,     0,     0,    0, 255, // red
            0, -1.0f,     0,    0, 255, // green
            0,     0, -1.0f,    0, 255, // blue
            0,     0,     0, 1.0f,   0  // alpha
    };

    EditText searchText;
    ConstraintLayout filterLayout;
    RecyclerView resultsview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        searchView = inflater.inflate(R.layout.research, container, false);

        View v = searchView.findViewById(R.id.searchConstraintLayout);
        final View frameLayout = searchView.findViewById(R.id.frameLayout);
        filterLayout = frameLayout.findViewById(R.id.filterConstraintLayout);
        v.getBackground().setAlpha(120);
        searchText = searchView.findViewById(R.id.searchText);
        final TextView beef = (TextView)filterLayout.findViewById(R.id.beef);
        final TextView chicken = (TextView)filterLayout.findViewById(R.id.chicken);
        final TextView fish = (TextView)filterLayout.findViewById(R.id.fish);
        final TextView pork = (TextView)filterLayout.findViewById(R.id.pork);
        final TextView onion = (TextView)filterLayout.findViewById(R.id.onion);
        final TextView potato = (TextView)filterLayout.findViewById(R.id.potato);
        final TextView mushroom = (TextView)filterLayout.findViewById(R.id.mushroom);
        final TextView egg = (TextView)filterLayout.findViewById(R.id.egg);
        final TextView carrot = (TextView)filterLayout.findViewById(R.id.carrot);
        final TextView tomato = (TextView)filterLayout.findViewById(R.id.tomato);
        final TextView corn = (TextView)filterLayout.findViewById(R.id.corn);
        final TextView broccoli = (TextView)filterLayout.findViewById(R.id.broccoli);

        beef.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+beef.getText().toString());

            }
        });
        chicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+chicken.getText().toString());

            }
        });
        fish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+fish.getText().toString());

            }
        });
        pork.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+pork.getText().toString());

            }
        });
        onion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+onion.getText().toString());

            }
        });
        potato.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+potato.getText().toString());

            }
        });
        mushroom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+mushroom.getText().toString());

            }
        });
        egg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+egg.getText().toString());

            }
        });
        carrot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+carrot.getText().toString());

            }
        });
        tomato.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+tomato.getText().toString());

            }
        });
        corn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+corn.getText().toString());

            }
        });
        broccoli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchText.setText(searchText.getText().toString()+" "+broccoli.getText().toString());

            }
        });
        Button btn_search = searchView.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //searchText = searchView.findViewById(R.id.searchText);
                if (searchText.getText().toString() != ""){
                    String query = searchText.getText().toString();
                    ArrayList<Receipe> results = receipeSearch(toIngredent(query));
                    Log.d("JAM", "onClick: " + results.get(0).getAuthor());
                    resultsview = searchView.findViewById(R.id.rcv_searchresults);
                    resultsview.setVisibility(View.VISIBLE);
                    frameLayout.setVisibility(View.INVISIBLE);
                    SearchResultAdapter resultAdapter = new SearchResultAdapter(getActivity(), results);
                    resultsview.setAdapter(resultAdapter);
                    resultsview.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
                else{
                    resultsview.setVisibility(View.INVISIBLE);
                    frameLayout.setVisibility(View.VISIBLE);
                }

            }
        });
        return searchView;
    }


    public ArrayList<Ingredent> toIngredent(String query) {
        ArrayList<Ingredent> results = new ArrayList<Ingredent>();
        String[] keywords = query.split(" ");
        for (int i = 0; i < MainActivity.ingreds.size(); i++) {
            for (int j = 0; j < keywords.length; j++) {
                for (int k = 0; k < MainActivity.ingreds.get(i).getAltNames().size(); k++) {
                    if (MainActivity.ingreds.get(i).getAltNames().get(k).equals(keywords[j])) {
                        results.add(MainActivity.ingreds.get(i));
                        break;
                    }
                }
            }
        }
        return results;
    }

    public ArrayList<Receipe> receipeSearch(ArrayList<Ingredent> ingreds) {
        ArrayList<Receipe> results = new ArrayList<Receipe>();

        for (int i = 0; i < MainActivity.receipes.size(); i++) {
            boolean added = false;
            for (int j = 0; j < MainActivity.receipes.get(i).getIngreds().size(); j++) {
                for (int k = 0; k < ingreds.size(); k++) {
                    if (MainActivity.receipes.get(i).getIngreds().get(j).getUuid().equals(ingreds.get(k).getUuid())) {
                        results.add(MainActivity.receipes.get(i));
                        added = true;
                        break;
                    }
                }
                if (added) {
                    break;
                }
            }

        }
        return results;
    }

}