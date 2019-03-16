package com.team15.foodhack19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.team15.foodhack19.objectClass.Receipe;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recipeDetailActivity extends AppCompatActivity {
    Receipe receipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("JAM", "onClick: creating instance");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //add back buttons
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int recipeLoc = getIntent().getIntExtra("recipe", 0);
        receipe = MainActivity.receipes.get(recipeLoc);
        TextView dishname = findViewById(R.id.dishname);
        TextView txt_ing = findViewById(R.id.txt_ing);
        TextView txt_steps = findViewById(R.id.txt_steps);
        TextView numberLike = findViewById(R.id.numberLike);
        ImageView dishImage = findViewById(R.id.dishImage);

        String ing = "";
        for (int i=0; i<receipe.getIngreds().size(); i++){
          ing = ing + receipe.getIngreds().get(i).getName() + "\n";
        }
        String steps = "";
        for (int i=0; i<receipe.getSteps().size(); i++){
          steps = steps + receipe.getSteps().get(i).toString() + "\n";
        }

        dishname.setText(receipe.getName());
        txt_ing.setText(ing);
        txt_steps.setText(steps);
        numberLike.setText(SearchResultAdapter.coolFormat((double) receipe.getLikes(), 0));
        dishImage.setImageResource(receipe.imageID());


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
