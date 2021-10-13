package com.frogger.components;

public class Voiture {
    int taille_voiture;
    double vitesse_voiture;
    float g_voiture, d_voiture;

    public Voiture (double v){
        vitesse_voiture = v;
        taille_voiture =  (int)(3* Math.random() ) +1 ;
        if (v>0){
            g_voiture = 0;
            d_voiture = g_voiture+ taille_voiture;
        }
        else {
            d_voiture = Plateau.x_plateau;
            g_voiture = d_voiture- taille_voiture;
        }
    }

    public void deplacement_voiture (){
        g_voiture += vitesse_voiture * 0.1;  // dt par développement limité
        d_voiture += vitesse_voiture * 0.1;

    }

    public boolean proche_bord (){  // détecte si la voiture est sortie de la voie
        if (g_voiture > Plateau.x_plateau && vitesse_voiture > 0){
            return true;
        }
        if (d_voiture < 0 && vitesse_voiture < 0){  // 0 pour abscisses des x, mais suivant l'ihm ça va peut être changer
            return true;
        }
        return false;
    }
}