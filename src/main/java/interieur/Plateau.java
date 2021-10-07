package interieur;

import java.util.ArrayList;
import java.lang.Math;
import interieur.Voie;
import interieur.Grenouille;

public class Plateau {
    public static float x_taille_case = 1;
    public static float y_taille_case ;
    public static float x_plateau = 8;  // arbitraire, à modif pour l'IHM : ici pour qu'on ait 8 cases par voie
    public static float y_plateau = 10 ; // tailles du plateau
    public ArrayList <Voie> voies = new ArrayList <Voie> () ;
    public static float eps = 0.1f; // à modifier pour l'IHM
    public Grenouille froggy;

    public Plateau (int nb_voies){
        this.y_taille_case = this.y_plateau / nb_voies; // on détermine la hauteur de chaque voie
        this.eps = x_taille_case/8;
        this.voies = new ArrayList <> (nb_voies);
        for (int i =0; i < nb_voies; i++) {
            this.voies.set(i, new Voie());
        }
        this.froggy = new interieur.Grenouille(0,0);
    }
}