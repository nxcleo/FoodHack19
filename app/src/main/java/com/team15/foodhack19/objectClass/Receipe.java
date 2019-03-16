package com.team15.foodhack19.objectClass;

import java.util.ArrayList;
import java.util.UUID;

public class Receipe {
    private ArrayList<Ingredent> ingreds;
    private ArrayList<Step> steps;
    private String author;
    private String author_title;
    private int likes;
    private String name;
    private String desc;
    private String imageURL;
    private String uuid = UUID.randomUUID().toString();


    public Receipe(ArrayList<Ingredent> ingreds, ArrayList<Step> steps, String author, String author_title, int likes, String name, String desc, String imageURL){
        this.ingreds = ingreds;
        this.steps = steps;
        this.author = author;
        this.author_title = author_title;
        this.likes = likes;
        this.name = name;
        this.desc = desc;
        this.imageURL = imageURL;
    };

    public int getLikes() {
        return likes;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_title() {
        return author_title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredent> getIngreds() {
        return ingreds;
    }

    public void setIngreds(ArrayList<Ingredent> ingreds) {
        this.ingreds = ingreds;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

}
