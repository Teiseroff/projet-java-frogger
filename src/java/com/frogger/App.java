package com.frogger;

import com.frogger.components.Grenouille;
import com.frogger.components.Plateau;
import com.frogger.components.Voie;
import com.frogger.components.Voiture;
import javafx.application.Application ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color ;

import com.frogger.gamelogic.Partie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Image;
import java.awt.Component;


import java.util.EventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group() ;

        Button start_btn = new Button() ;
        start_btn.setText("START") ;
        start_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                mainstart() ;
            }
        });

        Text crazyfrog_title = new Text();
        crazyfrog_title.setText("CRAZY FROG");
        crazyfrog_title.setFont(Font.font ("Eras Bold ITC", 70));
        crazyfrog_title.applyCss();

        crazyfrog_title.setX(75) ;
        crazyfrog_title.setY(200) ;
        start_btn.setLayoutX(275) ;
        start_btn.setLayoutY(260) ;

        root.getChildren().add(start_btn) ;
        root.getChildren().add(crazyfrog_title);


//        GridPane menuGrid = new GridPane();
//        menuGrid.setMinSize(400,200);
//        menuGrid.setPadding(new Insets(10, 10, 10, 10));
//        menuGrid.setVgap(40);
//        menuGrid.setHgap(5);
//        menuGrid.setAlignment(Pos.CENTER);
//        menuGrid.add(crazyfrog_title, 0, 0);
//        menuGrid.add(btn, 0, 1);
//        btn.getStylesheets().add("mainstyle.css") ;

        Scene titleMenu = new Scene(root, 600, 500, Color.LIGHTSKYBLUE) ;
        Stage stage = new Stage() ;

        stage.setTitle("Crazy Frog");
        stage.setScene(titleMenu);

        InputStream get_crazyFrog_icon = App.class.getResourceAsStream("/assets/Crazy_Frog.png");
//        Image window_icon = new Image(get_crazyFrog_icon) ;
//        stage.getIcons().add(window_icon) ;
        stage.show();
    }

    public void mainstart() {
        Group root_mainMenu = new Group() ;
        Group root_game = new Group() ;
        Group root_options = new Group() ;
        Scene mainMenu = new Scene(root_mainMenu, 1920, 1080, Color.BLACK) ;
        Stage mainStage = new Stage() ;


        // On gère ce qu'il va se passer lorsqu'on va appuyer sur le bouton game start
        //Scene game_scene = new Scene(root_game, 1920, 1080); // ,Color.GREEN) ;


        Button gamestart_btn = new Button() ;
        gamestart_btn.setText("GAME START");
        root_mainMenu.getChildren().add(gamestart_btn) ;
        gamestart_btn.setLayoutX(900);
        gamestart_btn.setLayoutY(650);
        gamestart_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gamestart(mainStage) ;
                System.out.print (12121);    // jusqu'ici ça marche
            }
        });

        // On gère ce qu'il va se passer lorsqu'on va appuyer sur le bouton options

        Scene options_scene = new Scene(root_options,1920,1080, Color.GREY) ;

        Button options_button = new Button() ;
        options_button.setText("OPTIONS");
        root_mainMenu.getChildren().add(options_button) ;
        options_button.setLayoutX(900);
        options_button.setLayoutY(800);
        options_button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                runOptions(mainStage,options_scene) ;
            }
        });


        mainStage.setScene(mainMenu);
        mainStage.setFullScreen(true);
        mainStage.show();


    }

    public void gamestart(Stage stage) {
        System.out.print(100000); //  ça marche ici aussi
        //stage.setScene(scene) ;
        //stage.setFullScreen(true);

        Partie partie = new Partie(5);
        //Plateau.draw_plateau() ;
        //partie.jeu();


        JFrame f = new JFrame("JEUUUU");
        JPanel panel = new JPanel();
        //panel.setBounds(0, 0, 1920, 1080);

//        try {
//            panel.setBounds(-300, 0, 1920, 1080);
//            BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
//            Image dimg = img.getScaledInstance(20, 30,
//                    Image.SCALE_SMOOTH);
//            System.out.print(4321);
//            JLabel pic = new JLabel(new ImageIcon(dimg));
//            //pic.setBounds(0, 500, 20, 30);
//            panel.add(pic);}
//    catch (IOException ignored) {
//            JLabel pic = new JLabel();
//    };

        f.add(panel);
        f.setSize(1920, 1080);
        f.setLayout(null);
        f.setVisible(true);
        System.out.print (77777);



        class MyClass  implements KeyListener {
            public void keyTyped(KeyEvent e) {
                // Invoked when a key has been typed.
            }

            public void keyPressed(KeyEvent e) {

                int code = e.getKeyCode();
                if ((KeyEvent.VK_DOWN == code)&&(!(Partie.You_Win || Partie.You_Loose))) {          // quand le code correspond à celui de la fleche basse non numerique
                        partie.plateau.froggy.deplacement(0, -partie.plateau.getY_taille_case());
                        System.out.print(" bas ");
                    }
                else if ((KeyEvent.VK_UP == code) && (!(Partie.You_Win || Partie.You_Loose))) {
                    partie.plateau.froggy.deplacement(0, partie.plateau.getY_taille_case());
                    System.out.print(" haut ");
                }
                else if  ((KeyEvent.VK_LEFT== code) &&(!(Partie.You_Win || Partie.You_Loose))) {
                        partie.plateau.froggy.deplacement(-Plateau.getX_taille_case(), 0);
                        System.out.print(" gauche ");
                    }
                else if ((KeyEvent.VK_RIGHT == code) && (!(Partie.You_Win || Partie.You_Loose))) {
                        partie.plateau.froggy.deplacement(Plateau.getX_taille_case(), 0);
                        System.out.print(" droite ");
                    };

            // partie.plateau.froggy.place_grenouille( panel );
            draw_image(f, panel, partie);
            for (Voie voie : partie.plateau.getVoies()) {
                for (Voiture voiture : voie.voitures) {
                    if (partie.plateau.froggy.collision(voiture)) {
                        //timer.stop();
                        Partie.You_Loose = true;
                    }
                }
            }
        };

            public void keyReleased(KeyEvent e) {}
        }

        f.addKeyListener(new MyClass());

    };


        public void  draw_image (JFrame f, JPanel panel, Partie partie) {
            System.out.print (55555);
                //f.remove(panel);
                partie.plateau.froggy.place_grenouille(panel,  Plateau.getX_taille_case(), partie.plateau.getY_taille_case());
                //place_shrek (panel);

                f.add(panel);
                f.setSize(1920, 1080);
                f.setLayout(null);
                f.setVisible(true);
                System.out.print (77777);

        }
//    void place_grenouille (JPanel panel) {
//        try {
//        BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
//        Image dimg = img.getScaledInstance(20, 30,
//                Image.SCALE_SMOOTH);
//        System.out.print(4321);
//        JLabel pic = new JLabel(new ImageIcon(dimg));
//        pic.setBounds(200, 100, 20, 30);
//        panel.add(pic);}
//
//    catch (IOException ignored) {};
//    }

    void place_shrek (JPanel panel) {
        try {
        BufferedImage img2 = ImageIO.read(new File("C:/Users/Utilisateur/Documents/shrek.png"));
        Image dimg2 = img2.getScaledInstance(200, 250,
                Image.SCALE_SMOOTH);
        JLabel pic2 = new JLabel(new ImageIcon(dimg2));
        pic2.setBounds(20,10, 20,30);
        panel.add(pic2);}
        catch (IOException ignored) {};
    }


    public void runOptions(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }





    public static void main(String[] args) {

        launch(args) ;

    }

}