package com.team15.foodhack19;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.team15.foodhack19.objectClass.Ingredent;
import com.team15.foodhack19.objectClass.Receipe;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    View searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        searchView = inflater.inflate(R.layout.research, container, false);

        Button btn_search = searchView.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchText = searchView.findViewById(R.id.searchText);
                String query = searchText.getText().toString();
                ArrayList<Receipe> results = receipeSearch(toIngredent(query));
                Log.d("JAM", "onClick: " + results.get(0).getAuthor());
                RecyclerView resultsview = searchView.findViewById(R.id.rcv_searchresults);
                SearchResultAdapter resultAdapter = new SearchResultAdapter(getActivity(), results);
                resultsview.setAdapter(resultAdapter);
                resultsview.setLayoutManager(new LinearLayoutManager(getActivity()));


            }
        });

        return searchView;
    }



    public ArrayList<Ingredent> toIngredent(String query){
        ArrayList<Ingredent> results = new ArrayList<Ingredent>();
        String[] keywords = query.split(" ");
        for(int i=0; i<MainActivity.ingreds.size(); i++){
            for(int j=0; j<keywords.length; j++){
                for(int k=0; k<MainActivity.ingreds.get(i).getAltNames().size(); k++){
                    if(MainActivity.ingreds.get(i).getAltNames().get(k).equals(keywords[j])){
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

        for(int i=0; i<MainActivity.receipes.size(); i++)
        {
            boolean added = false;
            for(int j=0; j<MainActivity.receipes.get(i).getIngreds().size(); j++)
            {
                for(int k=0; k<ingreds.size(); k++)
                {
                    if (MainActivity.receipes.get(i).getIngreds().get(j).getUuid().equals(ingreds.get(k).getUuid())){
                        results.add(MainActivity.receipes.get(i));
                        added = true;
                        break;
                    }
                }
                if (added) {break;}
            }

        }


        return results;
    }
}
