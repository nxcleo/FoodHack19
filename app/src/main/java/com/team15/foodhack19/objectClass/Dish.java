package com.team15.foodhack19.objectClass;

/**
 * Created by Siyang Sun on 16/3/2019.
 */

public class Dish {
    private String Title;
    private String Category;
    private String Description;
    private int Thumbnail;

    public Dish() {

    }

    public Dish(String title,String category, String description, int thumbnail){
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}


