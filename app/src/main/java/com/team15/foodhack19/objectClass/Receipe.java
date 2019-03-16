package com.team15.foodhack19.objectClass;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Receipe implements Serializable {
    private ArrayList<Ingredent> ingreds;
    private ArrayList<Step> steps;
    private String author;
    private String author_title;
    private int likes;
    private String name;
    private String desc;
    private int imageID;


    public Receipe(ArrayList<Ingredent> ingreds, ArrayList<Step> steps, String author, String author_title, int likes, String name, String desc, int imageID){
        this.ingreds = ingreds;
        this.steps = steps;
        this.author = author;
        this.author_title = author_title;
        this.likes = likes;
        this.name = name;
        this.desc = desc;
        this.imageID = imageID;
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

    public int imageID() {
        return imageID;
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
