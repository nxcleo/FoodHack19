package com.team15.foodhack19.objectClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Ingredent implements Serializable {
    private ArrayList<String> altNames;
    private String type;
    private String imageUrl;
    private ArrayList<Ingredent> replacement;
    private ArrayList<Double> replacement_multiplier;
    private String uuid = UUID.randomUUID().toString();

    public Ingredent(ArrayList<String> altNames, String type, String imageUrl){
        this.altNames = altNames;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public boolean hasName(String keyword){


        // Wait for implementation


        return false;
    }

    public String getUuid() { return this.uuid;}
    public void addAltName(String newName) {
        altNames.add(newName);
    }

    public ArrayList<String> getAltNames() {
        return altNames;
    }

    public void setAltNames(ArrayList<String> altNames) {
        this.altNames = altNames;
    }

    public String getName(){
        if (altNames.size() == 0) return "null";

        return altNames.get(0);
    }
}
