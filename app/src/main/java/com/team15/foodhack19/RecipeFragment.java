package com.team15.foodhack19;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipeFragment extends Fragment {

    private String[] images = {
            "https://dish-environment-prod-contentbucket-10u8bszryovz3.s3.amazonaws.com/assets/s3fs-public/styles/content_image_tiny/public/102334255__Chicken-with-peppers-in-tomato-sauce_Photo-by-Meredith-1.jpg?itok=HuS8TBCs 320w, https://dish-environment-prod-contentbucket-10u8bszryovz3.s3.amazonaws.com/assets/s3fs-public/styles/content_image_small/public/102334255__Chicken-with-peppers-in-tomato-sauce_Photo-by-Meredith-1.jpg?itok=bBYCqKW0 500w, https://dish-environment-prod-contentbucket-10u8bszryovz3.s3.amazonaws.com/assets/s3fs-public/styles/content_image_x_large/public/102334255__Chicken-with-peppers-in-tomato-sauce_Photo-by-Meredith-1.jpg?itok=LkBSyQaS 650w"
    };
    ViewPager viewPager;
    View recipeView;
    ViewPagerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView?


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recipeView = inflater.inflate(R.layout.recipe, container, false);



        viewPager = (ViewPager)recipeView.findViewById(R.id.imageRecipe);
        adapter = new ViewPagerAdapter(this.getActivity(),images);
        viewPager.setAdapter(adapter);
        return recipeView;
    }
}

