package com.frogger.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Voiture {
    private int taille_voiture;
    private double vitesse_voiture;
    private float g_voiture, d_voiture;
    private int id_voiture;
    private Image im ;

    public Voiture (double v, int id){
        this.id_voiture=id;
        vitesse_voiture = 5*v ;
        taille_voiture =  (int)(3* Math.random() ) +1 ;
        if (v>0){
            g_voiture = 0;
            d_voiture = g_voiture+ taille_voiture* Plateau.getX_taille_case() ;
        }
        else {
            d_voiture = Plateau.getX_plateau();
            g_voiture = d_voiture- taille_voiture * Plateau.getX_taille_case();
        }

        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream("C://Users//Utilisateur//Documents//shrek.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //this.im = new javafx.scene.image.Image(inputstream); // variable d'instance

    }
    public int GetTailleVoit (){
        return taille_voiture;
    }

    public float getG_voiture() {
        return g_voiture;
    }

    public float getD_voiture() {
        return d_voiture;
    }

    public void setG_voiture(float g){
        this.g_voiture=g;
    }

    public void setD_voiture(float d){
        this.d_voiture=d;
    }

    public double getVitesse_voiture(){
        return vitesse_voiture;
    }

    public void setVitesse_voiture(double v){
        this.vitesse_voiture=v;
    }

    public int GetId_voiture(){
        return id_voiture;}

    public void deplacement_voiture (){
        g_voiture += vitesse_voiture; // * 0.1;  // dt par développement limité
        d_voiture += vitesse_voiture; // * 0.1;  // TODO adapter le 0.1 à la situation

    }

    public boolean proche_bord (){  // détecte si la voiture est sortie de la voie

        if (g_voiture >= Plateau.getX_plateau() && vitesse_voiture > 0)
        {
            return true;
        }

        else if (d_voiture <= 0 && vitesse_voiture < 0)
        {  // 0 pour abscisses des x, mais suivant l'ihm ça va peut être changé
            return true;
        }

        return false;
    }


    public void place_voiture (JPanel panel, JFrame f, float width, float height, float width_ecran, float height_ecran , int voie_id) {
        System.out.print (" ok on affiche une voiture !!");
        try {
            //panel.removeAll();
            //panel.setBounds(0, 0, 1920, 1080);
            System.out.print ("  1   ");
            BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/flash_gauche.jfif"));
            System.out.print ("  2   ");
            Image dimg = img.getScaledInstance((int) width * this.taille_voiture - (int) Plateau.getEps() * 2, (int) height - (int) Plateau.getEps() * 2,
                    Image.SCALE_SMOOTH);
            System.out.print("   3  ");
            JLabel pic = new JLabel(new ImageIcon(dimg));
            System.out.print (this.g_voiture);
//            System.out.print ("    ");
//            System.out.print (this.d);
            panel.setBounds( (int) this.g_voiture, (int) height_ecran - (int) voie_id *  (int) height , (int) width * this.taille_voiture - (int) Plateau.getEps() * 2, (int) height - (int) Plateau.getEps() * 2);  // pas de pb ici
            panel.add(pic);
            System.out.print ("  4   ");
        }
        catch (IOException ignored) {};
        f.setSize((int) width_ecran, (int) height_ecran);
        f.setLayout(null);
        f.setVisible(true);
    }
}