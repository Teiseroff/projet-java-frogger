package com.frogger.components;

import java.util.ArrayList;
import java.util.Random;

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
        this.boxes = boxes ;
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

    public int getVoie_id() {
        return voie_id;
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
        // box id 0 : herbe
        // box id 1 : route pleine
        // box id 2 : eau
        // box id 3 : arbre       MAIS voie id 3 : herbe + arbres

        if (voie.getVoie_id() == 0) {
            for (int i = 0; i < Plateau.getX_plateau(); i++) {
                Box boxtoadd = new Box(i, 0, 0) ;
                voie.boxes.add(boxtoadd) ;
            }
        }
        else if (voie.getVoie_id() == 1) {
            for (int i = 0; i < Plateau.getX_plateau(); i++) {
                Box boxtoadd = new Box(i, 0, 1) ;
                voie.boxes.add(boxtoadd) ;
            }
        }

        else if (voie.getVoie_id() == 2) {
            for (int i = 0; i < Plateau.getX_plateau(); i++) {
                Box boxtoadd = new Box(i, 0, 2) ;
                voie.boxes.add(boxtoadd) ;
            }
        }

        else if (voie.getVoie_id() == 3) {
            int coin = new Random().nextInt(2) ;
            //TODO générer un nombre aléatoire d'arbres sur une ligne
            for (int i = 0; i < Plateau.getX_plateau(); i++) {
                Box boxtoadd = new Box(i, 0, 3) ;
                voie.boxes.add(boxtoadd) ;
            }
        }
    }


}
