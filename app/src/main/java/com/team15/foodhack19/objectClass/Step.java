package com.team15.foodhack19.objectClass;

import java.io.Serializable;
import java.util.ArrayList;

public class Step implements Serializable
{
    public enum StepType { ADDITEM, STIR, BREW, FINISH }
    private StepType type;
    private int time = 0;
    private ArrayList<Ingredent> ingreds;

    public Step(StepType type, ArrayList<Ingredent> ingreds){
        this.type = type;
        this.ingreds = ingreds;
    }


    public Step(StepType type, int time){
        this.time = time;
        this.type = type;
    }

    public ArrayList<Ingredent> getIngreds() {
        return ingreds;
    }

    public int getTime() {
        return time;
    }

    public StepType getType() {
        return type;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setType(StepType type) {
        this.type = type;
    }
    public String toString(){
      if (this.type == StepType.ADDITEM){
        return "Add " + this.ingreds.get(0).getName();
      }
      else{
        return "Brew for " + this.time + " minutes.";
      }
    }

}
