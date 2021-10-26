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

    public Voie (int voie_id) {
        sens = (int)(Math.random() + 0.5);
        v = sens* 20; // TODO adapter le 20 à la situation
        frequence = 0.1 ; // Math.random();
        this.voitures = new ArrayList <> (10);
        this.boxes = boxes ;
        this.voie_id = voie_id ;
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


    //Ok la je tente un truc pour faire marcher : je definis direct la liste des voies

    ArrayList <Voie> test_plateau = new ArrayList<>() ;

    public ArrayList test_getVoies() {
        Voie voie_herbe1 = new Voie(0) ;
        Voie voie_route1 = new Voie(1) ;
        Voie voie_route2 = new Voie(1) ;
        Voie voie_route3 = new Voie(1) ;
        Voie voie_route4 = new Voie(1) ;
        Voie voie_herbe2 = new Voie(0) ;
        Voie voie_route5 = new Voie(1) ;
        Voie voie_route6 = new Voie(1) ;
        Voie voie_route7 = new Voie(1) ;
        Voie voie_herbe3 = new Voie(0) ;

        test_plateau.add(voie_herbe1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_herbe1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_route1) ;
        test_plateau.add(voie_herbe1) ;

        return test_plateau ;
    }


}
