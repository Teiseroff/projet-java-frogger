package com.frogger.components;

import java.lang.Integer;
import java.util.ArrayList;

public class Plateau {
    private static float x_taille_case = 1;
    private static float y_taille_case ;
    private static int x_plateau = 8;  // arbitraire, à modif pour l'IHM : ici pour qu'on ait 8 cases par voie
    private static int y_plateau = 10 ; // tailles du plateau
    public int nb_voie ;
    private ArrayList <Voie> voies = new ArrayList <Voie> (nb_voie) ;
    private static float eps = 0.1f; // à modifier pour l'IHM
    public Grenouille froggy;



    public Plateau (int nb_voies){
        this.nb_voie = nb_voies;   // TODO attention là on se met dans le cas ou y'a pas de défilement et on va juste en haut de l'image de l'écran
        y_taille_case = (float) y_plateau / (float) nb_voies; // on détermine la hauteur de chaque voie
        eps = x_taille_case/8;
        voies = new ArrayList <> (nb_voies);
        for (int i =0; i < nb_voies; i++) {
            Voie v = new Voie(0);
            voies.add(v);
        }

        this.froggy = new Grenouille(0,0);
    }

    public static float getX_taille_case() {
        return x_taille_case;
    }

    public static float getY_taille_case() {  return y_taille_case; }

    public static int getX_plateau() {
        return x_plateau;
    }

    public static int getY_plateau() {
        return y_plateau;
    }

    public static void setX_taille_case(float x_taille_case) {
        Plateau.x_taille_case = x_taille_case;
    }

    public static void setY_taille_case(float y_taille_case) {
        Plateau.y_taille_case = y_taille_case;
    }

    public static void setX_plateau(int x_plateau) {
        Plateau.x_plateau = x_plateau;
    }

    public static void setY_plateau(int y_plateau) {
        Plateau.y_plateau = y_plateau;
    }

    public static float getEps() {
        return eps;
    }

    public ArrayList<Voie> getVoies() {
        return voies;
    }
}