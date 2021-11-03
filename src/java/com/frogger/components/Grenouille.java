package com.frogger.components;

import com.frogger.gamelogic.Partie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Grenouille {

    private float b,h,g,d;  //  la grenouille, considérée comme un rectangle, est repérée par ses coordonées: en bas, en haut, à droite et à gauche
    private boolean bord_b, bord_g, bord_d;  // booléens qui sont vrais si la grenouille touche un des bords du plateau de jeu
    // (et ne pourra plus se déplacer du coté de ce bord)
    // il n'y a pas de bord_h car celui-ci correspond à la victoire du joueur (la grenouille a atteint l'arrivée)

    // TODO insérer la photo ici je crois, ou pas jcp

    public Grenouille ( float b, float g) {   // on instancie la grenouille en entrant ses cooordonnées de départ à gauche et en bas.
        // Celles en haut et à droite sont déduites par translation de la taille d'une case (x_taille_case et y_taille_case))
        //this.b = b + Plateau.getEps();    // on rajoute une petite quantité eps pour ne pas remplir exactement la case
        // On s'assure ainsi de ne pas avoir de problèmes de collisions avec les voies voisines
        this.g = 200; // TODO i dont know why, i dont want to know why, i shouldnt have to wonder why
        this.b = 200;
        this.d = g + Plateau.getX_taille_case() - Plateau.getEps();
        this.h = b + Plateau.getY_taille_case() - Plateau.getEps();
        this.d = g + Plateau.getX_taille_case() - Plateau.getEps();
        this.bord_b = true;  // à sa création, la grenouille est placée en bas au centre du plateau de jeu
        // (donc seulement proche du bord bas)
        this.bord_g = false ;
        this.bord_d = false;
    }

    public boolean GetBordB (){
        return this.bord_b;
    }

    public boolean GetBordG (){
        return this.bord_g;
    }

    public boolean GetBordD (){
        return this.bord_d;
    }

    public float Getg (){
        return this.g;
    }
    public float Geth (){
        return this.h;
    }

    public void Setg (float gg) {
        this.g = gg + Plateau.getEps();
        this.d = this.g + Plateau.getX_taille_case() - Plateau.getEps();
    }

    public void Setb (float bb) {
        this.b = bb + Plateau.getEps();
        this.h = this.b + Plateau.getY_taille_case() - Plateau.getEps();
    }


    public float Getb (){
        return this.b;
    }

    public void deplacement (float dx, float dy){   // on déplace la grenouille de dx vers la droite et de dy vers le haut
        this.g += dx;
        this.d += dx;
        this.b += dy;
        this.h += dy;

        // Mettre à jour la position de la grenouille dans l'IHM

        if (h == Plateau.getY_plateau() - Plateau.getEps()){ // si la grenouille est arrivée en haut du parcours
            Partie.You_Win = true;  // c'est gagné //TODO ca marchera jamais !!
        }
        else {
            Partie.You_Win = false;
        }

        if (b <= Plateau.getEps()){  // si la grenouille est tout en bas du parcours
            bord_b = true; // elle ne pourra pas reculer au prochain mouvement
        }
        else {
           bord_b = false;
        }

        if (g <= Plateau.getEps()){ // si la grenouille arrive au bord gauche du plateau
            bord_g = true; // elle ne pourra pas de déplacer à gauche au prochain mouvement
        }
        else {
            bord_g = false;

        }
        if (g >= Plateau.getX_plateau() - Plateau.getX_taille_case() - 3* Plateau.getEps()){ // si la grenouille arrive au bord droit du plateau
            bord_d = true; // elle ne pourra pas de déplacer à droite au prochain mouvement
        }
        else {
            bord_d = false;
        }
    }

    public boolean collision (Voiture voiture){  // on regarde si la voiture entrée en paramètre intercepte la grenouille

        if ( Math.abs(voiture.GetId_voiture()*Plateau.getY_taille_case()-this.h) <= 100)
        { // on vérifie que la voiture et la grenouille sont sur la même voie

            if ((voiture.getG_voiture() <= this.g && this.g <= voiture.getD_voiture()) || (voiture.getG_voiture() <= this.d && this.d <= voiture.getD_voiture()) || (this.g <= voiture.getG_voiture() && voiture.getG_voiture() <= this.d)
                || (this.g <= voiture.getD_voiture() && voiture.getD_voiture() <= this.d))
            {

//            if ((voiture.getD_voiture()>=this.g && voiture.getVitesse_voiture()>0)|| (voiture.getG_voiture()<=this.d && voiture.getVitesse_voiture()<0)){
                return true;
            }
            return false;

        }
        return false;

    }

    public void place_grenouille (JPanel panel, JFrame f, float width, float height, float width_ecran, float heigth_ecran) {
        try {
              //panel.removeAll();
              //panel.setBounds(0, 0, 1920, 1080);
              BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
              Image dimg = img.getScaledInstance((int) width - (int) Plateau.getEps() *2, (int) height - (int) Plateau.getEps() *2,
                    Image.SCALE_SMOOTH);
            System.out.print(4321);
            JLabel pic = new JLabel(new ImageIcon(dimg));
//            System.out.print (this.g);
//            System.out.print ("    ");
//            System.out.print (this.d);
            panel.setBounds( (int) this.g, (int) heigth_ecran - (int) this.b - (int) height , (int) width - (int) Plateau.getEps() * 2, (int) height - (int) Plateau.getEps()*2);  // pas de pb ici
            panel.add(pic);}
        catch (IOException ignored) {};
        f.add(panel);
        f.setSize((int) width_ecran, (int) heigth_ecran);
        f.setLayout(null);
        f.setVisible(true);
    }

}
