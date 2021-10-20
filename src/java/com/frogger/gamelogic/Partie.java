package com.frogger.gamelogic;

import com.frogger.components.Plateau;
import com.frogger.components.Voie;
import com.frogger.components.Voiture;
import com.frogger.components.Grenouille;

import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;
import java.lang.Object;
import java.awt.AWTEvent;
import java.util.EventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        // lorsque le bouton démarré est pressé : // TODO gestion d'appui sur le bouton démarrer
        // timer.start (60)  --> toutes les 60 ms, la fonction timer_0 est appelée
        Timer tt = new Timer(1000, taskPerformer);
        tt.start();

//         while ! (You_Win || You_Loose) {
//         if keyPressedEvent :
//        // if (c'est |^ && (!Partie.YouWin) {
//        //   Grenouille.froggy.deplacement (0,y_taille_case)
//        //   }
//        // if (c'est -> && (!Grenouille.froggy.bord_d) {
//        //   Grenouille.froggy.deplacement (x_taille_case,0)
//        //   }
//        // if (c'est <- && (!Grenouille.froggy.bord_g) {
//        //   Grenouille.froggy.deplacement (-x_taille_case,0)
//        //   }
//        // if (c'est |bas && (!Grenouille.froggy.bord_b) {
//        //   Grenouille.froggy.deplacement (0,-y_taille_case)
//        //   }
//        //}
//        // mettre à jour la scène

        for (Voie voie : plateau.voies) {
            for (Voiture voiture : voie.voitures) {
                if (plateau.froggy.collision(voiture)) {
                    //timer.stop();
                    You_Loose = true;
                }
            }
        }
        tt.stop();  // le timer est arreté :

        // if (You_Loose == true) {
        // TODO afficher la scène de défaite
        // else {
        // TODO afficher la scène de victoire
        // }
    }


//    public void timer_0() {
//        if (!You_Win) {
//
//            for (Voie voie : plateau.voies) {
//                for (Voiture voiture : voie.voitures) {
//                    if (voiture.proche_bord()) {
//                        // voie.remove(voiture);
//                    }
//                }
//            }
//
//            for (Voie voie : plateau.voies) {
//                for (Voiture voiture : voie.voitures) {
//                    if (plateau.froggy.collision(voiture)) {
//                        //timer.stop();
//                        You_Loose = true;
//                    }
//                }
//            }
//
//            for (Voie voie : plateau.voies) {
//                for (Voiture voiture : voie.voitures) {
//                    voiture.deplacement_voiture();
//                }
//            }
//
//            /// update le dessin
//        }
//        // update le dessin
//        // timer.stop()
//    }
//
//
//        KeyListener listener = new EventListener() {
//            @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        switch (code) {
            case (KeyEvent.VK_DOWN):        // quand le code correspond à celui de la fleche basse non numerique
                if (!(You_Win || You_Loose)) {
                    plateau.froggy.deplacement(0, -plateau.y_taille_case);
                }
            case (KeyEvent.VK_UP):
                if (!(You_Win || You_Loose)) {
                    plateau.froggy.deplacement(0, plateau.y_taille_case);
                }
            case (KeyEvent.VK_LEFT):
                if (!(You_Win || You_Loose)) {
                    plateau.froggy.deplacement( -plateau.x_taille_case, 0);
                }
            case (KeyEvent.VK_RIGHT):
                if (!(You_Win || You_Loose)) {
                    plateau.froggy.deplacement(plateau.x_taille_case, 0);
                }

        }
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

                /// TODO update le dessin
            }
            // TODO update le dessin
            You_Win = true ;
        }
    };

}

