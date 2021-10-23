package com.frogger.components;

import java.util.ArrayList;

public class Plateau {
    private static float x_taille_case = 1;
    private static float y_taille_case ;
    private static int x_plateau = 8;  // arbitraire, à modif pour l'IHM : ici pour qu'on ait 8 cases par voie
    private static int y_plateau = 10 ; // tailles du plateau
     ArrayList <Voie> voies = new ArrayList <Voie> () ;
    private static float eps = 0.1f; // à modifier pour l'IHM
    public Grenouille froggy;
    public int nb_voie ;

    public Plateau (int nb_voies){
        this.nb_voie = nb_voies;
        this.y_taille_case = this.y_plateau / nb_voies; // on détermine la hauteur de chaque voie
        this.eps = x_taille_case/8;
        this.voies = new ArrayList <> (nb_voies);
        for (int i =0; i < nb_voies; i++) {
            this.voies.set(i, new Voie());
        }

        this.froggy = new Grenouille(0,0);
    }

    public static float getX_taille_case() {
        return x_taille_case;
    }

    public static float getY_taille_case() {
        return y_taille_case;
    }

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
}