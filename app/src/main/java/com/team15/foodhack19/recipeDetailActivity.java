package com.team15.foodhack19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.team15.foodhack19.objectClass.Receipe;

import java.util.ArrayList;

public class recipeDetailActivity extends AppCompatActivity {
    ArrayList<Receipe> receipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("JAM", "onClick: creating instance");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //add back buttons
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        receipes = (ArrayList<Receipe>) getIntent().getSerializableExtra("recipe");
        Log.d("JAM", "onCreate: " + receipes.get(0).getAuthor());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
