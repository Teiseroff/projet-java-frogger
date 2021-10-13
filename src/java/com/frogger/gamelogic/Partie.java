package com.frogger.gamelogic;

import com.frogger.components.Plateau;
import com.frogger.components.Voie;
import com.frogger.components.Voiture;

import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;
import java.lang.Object;

// import java.security.KeyStore;

public class Partie {
    public static boolean You_Win = false;  // Permet de voir quand la partie doit s'arrêter de run, dans la méthode jeu (en dessus)
    public static boolean You_Loose = false;  // Pareil
    public Plateau plateau;   // une partie contient un plateau

    public Partie(int nb_voie) {   // on entre le nombre de voies que l'on souhaite avoir à parcourir
        You_Win = false;
        You_Loose = false;
        plateau = new Plateau(nb_voie);
    }

    public void jeu() {                                     // ce qu'on lancera dans le main
        // lorsque le bouton démarré est pressé :
        // timer.start (60)  --> toutes les 60 ms, la fonction timer_0 est appelée
        Timer tt = new Timer(1000, taskPerformer);
        tt.start();

        // while ! (YouWin || YouLoose) {
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

        for (Voie voie : plateau.voies) {
            for (Voiture voiture : voie.voitures) {
                if (plateau.froggy.collision(voiture)) {
                    //timer.stop();
                    You_Loose = true;
                }
            }
        }
        tt.stop();

        // le timer est arreté :
        // if (You_Loose == true) {
        // afficher la scène de défaite
        // sinon :
        // afficher la scène de victoire
    }


    public void timer_0() {
        if (!You_Win) {

            for (Voie voie : plateau.voies) {
                for (Voiture voiture : voie.voitures) {
                    if (voiture.proche_bord()) {
                        // voie.remove(voiture);
                    }
                }
            }

            for (Voie voie : plateau.voies) {
                for (Voiture voiture : voie.voitures) {
                    if (plateau.froggy.collision(voiture)) {
                        //timer.stop();
                        You_Loose = true;
                    }
                }
            }

            for (Voie voie : plateau.voies) {
                for (Voiture voiture : voie.voitures) {
                    voiture.deplacement_voiture();
                }
            }

            /// update le dessin
        }
        // update le dessin
        // timer.stop()
    }

    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(You_Win)) {
                for (Voie voie : plateau.voies) {
                    for (Voiture voiture : voie.voitures) {
                        if (voiture.proche_bord()) {
                            // voie.remove(voiture);
                        }
                    }
                }

                for (Voie voie : plateau.voies) {
                    for (Voiture voiture : voie.voitures) {
                        if (plateau.froggy.collision(voiture)) {
                            //timer.stop();
                            You_Loose = true;
                        }
                    }
                }

                for (Voie voie : plateau.voies) {
                    for (Voiture voiture : voie.voitures) {
                        voiture.deplacement_voiture();
                    }
                }

                /// update le dessin
            }
            // update le dessin
            You_Win = true ;
        }
    };
}

