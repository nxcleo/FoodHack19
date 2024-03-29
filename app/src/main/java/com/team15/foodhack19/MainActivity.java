package com.team15.foodhack19;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.team15.foodhack19.objectClass.Dish;
import com.team15.foodhack19.objectClass.Ingredent;
import com.team15.foodhack19.objectClass.Receipe;
import com.team15.foodhack19.objectClass.Step;
import com.team15.foodhack19.objectClass.About;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    DatabaseReference mRef;
    DatabaseReference mCondition;

    private RecipeFragment recipe;
    private SearchFragment search;
    private  FavoriateFragment favoriate;

    List<Dish> lstDish;

    public static ArrayList<Ingredent> ingreds;
    public static ArrayList<Step> steps;
    public static ArrayList<Receipe> receipes;
    ActionBar actionbar;
    TextView appTitle;
    RelativeLayout.LayoutParams layoutparams;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.options_add:
                Intent intent = new Intent(this, addRecipeActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frame = (FrameLayout) findViewById(R.id.fragmentLayout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_search);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recipe = new RecipeFragment();
        search = new SearchFragment();
        favoriate = new FavoriateFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentLayout, search, "viewFragment")
                .commit();

        testInstance();
        ActionBarTitleGravity();
        mRef= FirebaseDatabase.getInstance().getReference();

    }

    private void ActionBarTitleGravity() {
        actionbar = getSupportActionBar();

        appTitle = new TextView(getApplicationContext());

        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        appTitle.setLayoutParams(layoutparams);

        appTitle.setText("Eatime");
        appTitle.setTextColor(Color.WHITE);

        appTitle.setGravity(Gravity.CENTER);

        appTitle.setTextSize(25);

        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionbar.setCustomView(appTitle);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.about:
//                startActivity(new Intent(this, About.class));
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
    @Override
    protected void onStart() {
        super.onStart();
        mCondition = mRef.child("receipes");
        mCondition.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                data.add(dataSnapshot.getValue(ForecastStatus.class));
//                itemsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_recipe:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentLayout, recipe, "recipeFragment")
                            .commit();
                    return true;
                case R.id.navigation_search:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentLayout, search, "searchFragment")
                            .commit();
                    return true;
                case R.id.navigation_favoriate:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentLayout, favoriate, "favoriateFragment")
                            .commit();

//                    RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
//                    RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getApplicationContext(),lstDish);
//                    myrv.setLayoutManager(new GridLayoutManager(getApplication(),3));
//                    myrv.setAdapter(myAdapter);
                    return true;
            }
            return false;
        }
    };

    private void testInstance(){
        final Ingredent beef = new Ingredent(new ArrayList<String>(){{add("beef");}}, "Main", "google.com");
        final Ingredent potato = new Ingredent(new ArrayList<String>(){{add("potato");}}, "Main", "google.com");
        final Ingredent tomato = new Ingredent(new ArrayList<String>(){{add("tomato");}}, "Main", "google.com");
        final Ingredent salt = new Ingredent(new ArrayList<String>(){{add("salt");}}, "Main", "google.com");
        ingreds = new ArrayList<Ingredent>(){{add(beef);add(potato);add(tomato);add(salt);}};

        final Step step1 = new Step(Step.StepType.ADDITEM, new ArrayList<Ingredent>(){{add(beef);}});
        final Step step2 = new Step(Step.StepType.ADDITEM, new ArrayList<Ingredent>(){{add(potato);}});
        final Step step3 = new Step(Step.StepType.BREW, 20);
        final Step step4 = new Step(Step.StepType.ADDITEM, new ArrayList<Ingredent>(){{add(salt);}});
        steps = new ArrayList<Step>(){{add(step1);add(step2);add(step3);add(step4);}};

        final Receipe receipe1 = new Receipe(ingreds, steps, "Adam Smith", "Baker of Nations",
                3100, "Beef Stew", "Great tasting stew made easy with home ingredents",
          R.drawable.beef);

        final Receipe receipe2 = new Receipe(ingreds, steps, "Carathy", "Iron Local Cheff",
                387410000, "Beef Stew", "Great tasting stew made easy with home ingredents",
          R.drawable.sadwitch);

        final Receipe receipe3 = new Receipe(ingreds, steps, "Sarah", "Burnt This One",
                59831298, "Beef Stew", "Great tasting stew made easy with home ingredents",
          R.drawable.salmonbro);

        final Receipe receipe4 = new Receipe(ingreds, steps, "Alicia", "I make food",
                12923809, "Beef Stew", "Great tasting stew made easy with home ingredents",
          R.drawable.toast);
        receipes = new ArrayList<Receipe>(){{add(receipe1);add(receipe2);add(receipe3);add(receipe4);add(receipe1);}};

        // Below is testInstance from Siyang Sun
        lstDish = new ArrayList<>();
        lstDish.add(new Dish("Ethan Calabrese","Category Book","Description Book",R.drawable.spaghetti));
        lstDish.add(new Dish("Buddha Bowls","Category Book","Description Book",R.drawable.delish));
        lstDish.add(new Dish("Pesto Penne","Category Book","Description Book",R.drawable.penne));
        lstDish.add(new Dish("Blackened Tilapia","Category Book","Description Book",R.drawable.tilapia));
        lstDish.add(new Dish("Creamy Lemon Garlic Salmon","Category Book","Description Book",R.drawable.salmon));
    }

    public SearchResultAdapter setSearchResult(ArrayList<Receipe> results){
        return new SearchResultAdapter(this, results);
    }


}
