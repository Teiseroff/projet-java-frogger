package com.frogger.components;

public class Partie {
    public static boolean You_Win = false;
    public static boolean You_Loose = false;
    public int nb_voies ;
    public Plateau plateau ;

    public Partie (int nb_voie){
        You_Win = false;
        You_Loose = false;
        plateau = new Plateau (nb_voie);
        nb_voies = nb_voie;

    }

    public void jeu () {
        // lorsque le bouton démarré est pressé :
        // timer.start (60)  --> toutes les 60 ms, la fonction timer_0 est appelée

        // while timer is running {
        // if une des flèches du clavier a été pressée :
           // if (c'est |^ && (!Partie.YouWin) {
           //   Grenouille.froggy.deplacement (0,y_taille_case)
           //   }
        // if (c'est -> && (!Grenouille.froggy.bord_d) {
        //   Grenouille.froggy.deplacement (x_taille_case,0)
        //   }
        // if (c'est <- && (!Grenouille.froggy.bord_g) {
        //   Grenouille.froggy.deplacement (-x_taille_case,0)
        //   }
        // if (c'est |bas && (!Grenouille.froggy.bord_b) {
        //   Grenouille.froggy.deplacement (0,-y_taille_case)
        //   }
        //}
        // mettre à jour la scène

        for (Voie voie  : plateau.voies){
            for (Voiture voiture : voie.voitures){
                if (plateau.froggy.collision(voiture)){
                    //timer.stop();
                    You_Loose = true;
                }
            }
        }

    // le timer est arreté :
        // if (You_Loose == true) {
        // afficher la scène de défaite
        // sinon :
        // afficher la scène de victoire
    }

    public void timer_0 () {
        if (! You_Win) {

            for (Voie voie  : plateau.voies){
                for (Voiture voiture : voie.voitures){
                    if (voiture.proche_bord ()){
                        // voie.remove(voiture);
                    }
                }
            }

            for (Voie voie  : plateau.voies){
                for (Voiture voiture : voie.voitures){
                    if (plateau.froggy.collision(voiture)){
                        //timer.stop();
                        You_Loose = true;
                    }
                }
            }

            for (Voie voie  : plateau.voies){
                for (Voiture voiture : voie.voitures){
                    voiture.deplacement_voiture ();
                }
            }

            /// update le dessin
        }
        // update le dessin
        // timer.stop()
    }

}
