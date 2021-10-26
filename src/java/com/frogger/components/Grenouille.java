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

    private float b,h,g,d;  //  coordonées de gauche, droite, haut bas de la grenouille
    private boolean bord_b, bord_g, bord_d;  // boolean qui sont à vrai sur la grenouille est au bord du jeu (et ne pourra plus se déplacer du coté de ce bord)

    // TODO insérer la photo ici je crois, ou pas jcp

    public Grenouille ( float b, float g) {   // on instancie la grenouille en entrant ses cooordonnées de gauche et du bas de départ. Celles du haut et de droite sont déduites par translation de la taille d'une case (x_taille_case et y_taille_case))
        this.b = b + Plateau.getEps();    // on rajoute le eps pour ne pas remplir pile la case et avoir des pb de collisions avec les voies voisines
        this.g = g + Plateau.getEps(); // TODO i dont know why, i dont want to know why, i shouldnt have to wonder why
        //this.h = b + Plateau.getY_taille_case() - Plateau.getEps();
       // this.d = g + Plateau.getX_taille_case() - Plateau.getEps();
        this.bord_b = true;  // à sa création, la grenouille est placée en bas au centre du jeu (donc seulement proche du bord bas)
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

    public void deplacement (float dx, float dy){   // on déplace la grenouille de dx vers la droite et de dy vers le haut
        this.g += dx;
       // this.d += dx;
        this.b += dy;
       // this.h += dy;

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

        if (g <= Plateau.getEps()){
            bord_g = true;
        }
        else {
            bord_g = false;

        }
        if (g >= Plateau.getX_plateau() - 3* Plateau.getEps() - Plateau.getX_taille_case()){
            bord_d = true;
        }
        else {
            bord_d = false;
        }
    }

    public boolean collision (Voiture voiture){  // on regarde si la voiture entrée en paramètre intercepte la grenouille
        if ((voiture.g_voiture <= this.g && this.g <= voiture.d_voiture) || (voiture.g_voiture <= this.d && this.d <= voiture.d_voiture) || (this.g <= voiture.g_voiture && voiture.g_voiture <= this.d)
                || (this.g <= voiture.d_voiture && voiture.d_voiture <= this.d)){
            return true;
    }
        return false;
    }

    public void place_grenouille (JPanel panel, float width, float height, float width_ecran, float heigth_ecran) {
        try {
              //panel.removeAll();
              //panel.setBounds(0, 0, 1920, 1080);
              BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
              Image dimg = img.getScaledInstance((int) width - (int) Plateau.getEps(), (int) height - (int) Plateau.getEps(),
                    Image.SCALE_SMOOTH);
            System.out.print(4321);
            JLabel pic = new JLabel(new ImageIcon(dimg));
            System.out.print (this.g);
            System.out.print ("    ");
            System.out.print (this.d);
            panel.setBounds( (int) this.g, (int) heigth_ecran - (int) this.b - (int) height , (int) width - (int) Plateau.getEps(), (int) height - (int) Plateau.getEps());  // pas de pb ici
            panel.add(pic);}
        catch (IOException ignored) {};

    }

}
