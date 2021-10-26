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
import java.awt.event.ActionListener;
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


        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height_ecran = (int)dimension.getHeight();
        int width_ecran  = (int)dimension.getWidth();

        System.out.print (width_ecran);
        System.out.print (" ");
        System.out.print (height_ecran);
        System.out.print ("  ");


        Button gamestart_btn = new Button() ;
        gamestart_btn.setText("GAME START");
        root_mainMenu.getChildren().add(gamestart_btn) ;
        gamestart_btn.setLayoutX(900);
        gamestart_btn.setLayoutY(650);
        gamestart_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gamestart(mainStage, width_ecran, height_ecran) ;
                System.out.print (" début du jeu ");    // jusqu'ici ça marche
            }
        });

        // On gère ce qu'il va se passer lorsqu'on va appuyer sur le bouton options


        Scene options_scene = new Scene(root_options,width_ecran,height_ecran, Color.GREY) ;

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

    public void gamestart(Stage stage, float width_ecran, float height_ecran) {

//        System.out.print(10); //  ça marche ici aussi
        //stage.setScene(scene) ;
        //stage.setFullScreen(true);

        Partie partie = new Partie(8);
        //Plateau.draw_plateau() ;
        //partie.jeu();

        JFrame f = new JFrame("JEUUUU");
        JPanel panel = new JPanel();
        //JPanel panel2 = new JPanel();
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
        //f.add(panel2);
        //draw_voitures(f, partie, width_ecran, height_ecran);
        f.setSize((int) width_ecran + 20, (int) height_ecran + 20);
        f.setLayout(null);
        f.setVisible(true);
        System.out.print ("  ");
        System.out.print (777);
        System.out.print ("  ");

        class MyClass  implements KeyListener {
            public void keyTyped(KeyEvent e) {
                // Invoked when a key has been typed.
            }

            public void keyPressed(KeyEvent e) {
                //System.out.print ("booooooon le clavier a bien détecté qu'on appuyais dessus");
                int code = e.getKeyCode();
                if ((KeyEvent.VK_DOWN == code)){ //&&(!(partie.plateau.froggy.GetBordB() || Partie.You_Win ))) {          // quand le code correspond à celui de la fleche basse non numerique
                        partie.plateau.froggy.deplacement(0, -partie.plateau.getY_taille_case());
                        //System.out.print(" bas ");
                    }
                else if ((KeyEvent.VK_UP == code)){ // && (!( Partie.You_Win ))) {
                    partie.plateau.froggy.deplacement(0, partie.plateau.getY_taille_case());
                    //System.out.print(" haut ");
                }

                /// quand je laissais le Partie.You_Win, avec le mauvais calibrage ça arrêtait tout dès l'instant qu'on avait une voiture
                else if  ((KeyEvent.VK_LEFT== code)) { // &&(!( partie.plateau.froggy.GetBordG() || Partie.You_Win ))) {
                        partie.plateau.froggy.deplacement(-Plateau.getX_taille_case(), 0);
                       // System.out.print(" gauche ");
                    }
                else if ((KeyEvent.VK_RIGHT == code)){ //&& (!(partie.plateau.froggy.GetBordD() || Partie.You_Win ))) {
                        partie.plateau.froggy.deplacement(Plateau.getX_taille_case(), 0);
                        //System.out.print(" droite ");
                    };

            // partie.plateau.froggy.place_grenouille( panel );
            draw_image(f, panel, partie, width_ecran, height_ecran);
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
        //draw_voitures(f, partie, width_ecran, height_ecran);
//        System.out.print ("PREMIERE PHASE");


//        for (Voie voie : partie.plateau.getVoies()) { // TODO ça ça a engendré un erreur sur l'affichage de la grenouille...
//        voie.nouvelle_voiture ();}

//        System.out.print ("DEUXIEME PHASE");
        draw_voitures(f, partie, width_ecran, height_ecran);
//      f.addKeyListener(new MyClass());

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //draw_voitures(f, partie, width_ecran, height_ecran);
                //System.out.print ("  le timer a biiiiiiiiiiiiiiiien fonctionné !!!  ");
             //   if (!(Partie.You_Win)) {

                    for (Voie voie : partie.plateau.getVoies()) {

                        for (Voiture voiture : voie.voitures) {
                            if (partie.plateau.froggy.collision(voiture)) {
                                Partie.You_Loose = true;
                                //break;
                            }
//                            if (voiture.proche_bord()) {
//                                voie.voitures.remove(voie.voitures.indexOf(voiture));  // TODO peut être plutôt utiliser un dico
//                            }
                        }

                        for (Voiture voiture : voie.voitures) {
                            voiture.deplacement_voiture();
                        }
                        draw_voitures(f, partie, width_ecran, height_ecran);
                    }

                    for (Voie voie : partie.plateau.getVoies()) {
                            voie.nouvelle_voiture();
                    }

                    draw_voitures(f, partie, width_ecran, height_ecran); /// TODO update le dessin
             //   }
                // TODO update le dessin
                Partie.You_Win = true;
            }
        };


        final Timer tt = new Timer(100, taskPerformer);
        tt.start();

//        while (!(Partie.You_Win || Partie.You_Loose)) {
//        }
//        tt.stop();  // on a arrête le timer
//        if (Partie.You_Win) {
//            System.out.print ("gagnééé");
//        }
//        else {
//            System.out.print ("perduuu");
//        }

};

        public void  draw_image (JFrame f, JPanel panel, Partie partie, float width_ecran, float height_ecran) {
            // System.out.print (55);
           // System.out.print (" ");
               // partie.plateau.froggy.place_grenouille(panel, f,  Plateau.getX_taille_case(), partie.plateau.getY_taille_case(), width_ecran, height_ecran);
            try {
                //panel.setBounds(0, 0, 1920, 1080);
                BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
                Image dimg = img.getScaledInstance((int)  Plateau.getX_taille_case() - (int) Plateau.getEps() *2, (int)partie.plateau.getY_taille_case()  - (int) Plateau.getEps() *2,
                        Image.SCALE_SMOOTH);
                //System.out.print(4321);
                JLabel pic = new JLabel(new ImageIcon(dimg));
                System.out.print (partie.plateau.froggy.Getg());
                System.out.print ("  ");
                System.out.print (partie.plateau.froggy.Getb());
                panel.setBounds( (int) partie.plateau.froggy.Getg(), (int) height_ecran - (int) partie.plateau.froggy.Getb()- (int) partie.plateau.getY_taille_case() , (int) Plateau.getX_taille_case() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps()*2);  // pas de pb ici
                panel.add(pic);}
            catch (IOException ignored) {}
            f.add(panel);
            f.setSize((int) width_ecran, (int) height_ecran);
            f.setLayout(null);
            f.setVisible(true);
        }


    public void  draw_voitures (JFrame f, Partie partie, float width_ecran, float height_ecran) {
        //System.out.print (" lalalala ");
        JPanel panel2 = new JPanel();
        for (Voie voie : partie.plateau.getVoies()) {
//            panel2 = new JPanel();
            for (Voiture voiture : voie.voitures) {
                try {
                    BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/flash_gauche.jfif"));
                    Image dimg = img.getScaledInstance((int) Plateau.getX_taille_case() * voiture.GetTailleVoit() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps() * 2,
                            Image.SCALE_SMOOTH);
                    JLabel pic = new JLabel(new ImageIcon(dimg));
                    //System.out.print (voiture.getG_voiture());
                    panel2.setBounds((int) voiture.getG_voiture(), (int) height_ecran - (int) voie.getVoie_id() * (int) partie.plateau.getY_taille_case(), (int) Plateau.getX_taille_case() * voiture.GetTailleVoit() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps() * 2);  // pas de pb ici
                    panel2.add(pic);
//                    f.add(panel2);
//                    f.setSize((int) width_ecran, (int) height_ecran);
//                    f.setLayout(null);
//                    f.setVisible(true);
                } catch (IOException ignored) {};
            }
            //f.add(panel2);  // jcp trop pk mais le truc d'en dessous marche mieux
//            f.getContentPane().add(panel2);
//            f.setSize((int) width_ecran, (int) height_ecran);
//            f.setLayout(null);
//            f.setVisible(true);

        }

        f.getContentPane().add(panel2);
        f.setSize((int) width_ecran, (int) height_ecran);
        f.setLayout(null);
        f.setVisible(true);
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