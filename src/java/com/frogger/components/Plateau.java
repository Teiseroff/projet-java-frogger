package com.frogger.components;

import com.frogger.App;
import javafx.application.Application ;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Plateau {
    private  static float x_taille_case = 100;
    private  static float y_taille_case ;
    private static int x_plateau = 1536;  // arbitraire, à modif pour l'IHM : ici pour qu'on ait 8 cases par voie
    private static int y_plateau = 864 ; // tailles du plateau
    public int nb_voie ;
    private ArrayList <Voie> voies = new ArrayList <Voie> (nb_voie) ;
    private static float eps = x_plateau/x_taille_case; // à modifier pour l'IHM
    public Grenouille froggy;



    public Plateau (int nb_voies){
        this.nb_voie = nb_voies;   // TODO attention là on se met dans le cas ou y'a pas de défilement et on va juste en haut de l'image de l'écran
        this.y_taille_case = (float) y_plateau / (float) nb_voies; // on détermine la hauteur de chaque voie
        eps = x_taille_case/8; // on détermine le pas acceptable pour une bonne approximation
        voies = new ArrayList <> (nb_voies -1);
        for (int i =2; i < nb_voies +1; i++) { //TODO pourquoi commencer à i=2?
            Voie v = new Voie(i);
            voies.add(v);
        }

        this.froggy = new Grenouille(0,0); // placement initial du plateau : la grenouille commence son parcours en bas à gauche
    }

    public static float getX_taille_case() {
        return x_taille_case;
    }

    public static float getY_taille_case() {
        return y_taille_case;}

    public static int getX_plateau() {
        return x_plateau;
    }

    public static int getY_plateau() {
        return y_plateau;
    }

//    public void setX_taille_case(float x_taille_case) {
//        this.x_taille_case = x_taille_case; //TODO à quoi sert le setter ici? étant donné qu'on ne va pas modifier cette valeur
//    }

//    public static void setY_taille_case(float y_taille_case) {
//        Plateau.y_taille_case = y_taille_case;
//    }

//    public static void setX_plateau(int x_plateau) {
//        Plateau.x_plateau = x_plateau;
//    }
//
//    public static void setY_plateau(int y_plateau) {
//        Plateau.y_plateau = y_plateau;
//    }

    public static float getEps() {
        return eps;
    }

    public ArrayList<Voie> getVoies() {
        return voies;
    }

    public static void draw_plateau() {
        Group root_plateau = new Group() ;
//        InputStream getAsset_box0 = App.class.getResourceAsStream("/assets/shrek.png");
//        Image box0_asset = new Image(getAsset_box0) ;
//        GridPane grid_plateau = new GridPane() ;

        //JLabel pic = new JLabel(new ImageIcon(box0_asset ));
        //grid_plateau.add(box0_asset);

        try
        {
            JFrame f = new JFrame("Ajouter une image dans JPanel");
            JPanel panel = new JPanel();
            panel.setBounds(50, 50, 250, 250);
            BufferedImage img = ImageIO.read(new File("/assets/shrek.png"));
            JLabel pic = new JLabel(new ImageIcon(img));
            panel.add(pic);
            f.add(panel);
            f.setSize(400, 400);
            f.setLayout(null);
            f.setVisible(true);
        }
        catch (IOException e) {}
    }

    }

