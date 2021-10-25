package com.frogger.components;

import java.util.ArrayList;

public class Voie {
    private int sens ;
    private int voie_id ;
    private double v;
    private double frequence;
    public ArrayList <Voiture> voitures = new ArrayList <Voiture> ();
    private ArrayList <Box> boxes = new ArrayList<>() ;

    public Voie () {
        sens = (int)(Math.random() -1);
        v = sens* 20* Math.random();
        frequence = Math.random();
        this.voitures = new ArrayList <> (10);
    }

    public int getSens() {
        return sens;
    }

    public double getV() {
        return v;
    }

    public double getFrequence() {
        return frequence;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void nouvelle_voiture(){
        double r = Math.random ();
        if (r < this.frequence) {
            voitures.add( new Voiture (v));
        }
    }

    public void generate_boxes(Voie voie){
        // id 0 : herbe
        // id 1 : route pleine
        // id 2 : eau
        // id 3 : herbe + arbres

        if (voie.getSens() == 0) {

        }
    }


}
