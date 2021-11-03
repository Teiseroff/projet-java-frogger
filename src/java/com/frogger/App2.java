package com.frogger;

import com.frogger.components.Plateau;
import com.frogger.components.Voie;
import com.frogger.components.Voiture;
import com.frogger.gamelogic.Partie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import javafx.scene.image.Image;


public class App2 extends Application {

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

        crazyfrog_title.setX(75) ; crazyfrog_title.setY(200) ; start_btn.setLayoutX(275) ; start_btn.setLayoutY(260) ;

        root.getChildren().add(start_btn) ;
        root.getChildren().add(crazyfrog_title);

        Scene titleMenu = new Scene(root, 600, 500, Color.LIGHTSKYBLUE) ;
        Stage stage = new Stage() ;

        stage.setTitle("Crazy Frog");
        stage.setScene(titleMenu);
        stage.show();
    }

    public void mainstart() {
        Group root_mainMenu = new Group() ;
        //Group root_game = new Group() ;
        Group root_options = new Group() ;
        Scene mainMenu = new Scene(root_mainMenu, 1500, 700, Color.BLACK) ;
        //Stage mainStage = new Stage() ;

        // On gère ce qu'il va se passer lorsqu'on va appuyer sur le bouton game start
//        Scene game_scene = new Scene(root_game, 1500, 700 ,Color.YELLOW) ;
//        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //        int height_ecran = (int)dimension.getHeight(); //        int width_ecran  = (int)dimension.getWidth(); System.out.print (width_ecran); System.out.print (" "); System.out.print (height_ecran); System.out.print ("  ");
        Button gamestart_btn = new Button() ;
        gamestart_btn.setText("GAME START");
        root_mainMenu.getChildren().add(gamestart_btn) ;
        gamestart_btn.setLayoutX(900);
        gamestart_btn.setLayoutY(650);

        gamestart_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gamestart() ; // , width_ecran, height_ecran) ;
                System.out.print (" début du jeu ");    // jusqu'ici ça marche
            }
        });

        // On gère ce qu'il va se passer lorsqu'on va appuyer sur le bouton options

        Scene options_scene = new Scene(root_options, Color.GREY); // width_ecran,height_ecran, Color.GREY) ;

        Button options_button = new Button() ;
        options_button.setText("OPTIONS");
        root_mainMenu.getChildren().add(options_button) ;
        options_button.setLayoutX(900);
        options_button.setLayoutY(800);
        options_button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                runOptions(options_scene) ;
            }
        });

        Stage mainStage = new Stage() ;
        mainStage.setScene(mainMenu);
        //mainStage.setFullScreen(true);
        mainStage.show();
    }

    public void gamestart() { // , float width_ecran, float height_ecran) {
        Group root = new Group() ;
        Stage stage = new Stage() ;
        //stage.setScene(scene) ; //stage.setFullScreen(true);
        Partie partie = new Partie(8); //Plateau.draw_plateau() ;  //partie.jeu();


        //root.getChildren().add(boxz);
        Scene game_scene = new Scene(root, 1500, 700 ,Color.YELLOW);
        stage.setScene(game_scene);

        try {HBox boxz = new HBox();

//            iv2.setFitHeight(Plateau.getY_taille_case());
//            iv2.setFitWidth(Plateau.getX_taille_case());
            FileInputStream inputstream = null;
            ImageView iv2 = new ImageView();
            inputstream = new FileInputStream("C://Users//Utilisateur//Documents//Crazy_Frog.png");
            Image image = new Image(inputstream);

            stage.getScene().setOnKeyPressed(event -> {
                //HBox box = new HBox();


                //stage.setScene(game_scene);
                //root.getChildren().add(boxz);

//                Rectangle rect = new Rectangle(38, 38 ); //, Color.GREEN);
//                //rect.setTranslateY(600 - 39);
//                rect.setTranslateX(partie.plateau.froggy.Getg());
//                rect.setTranslateY(partie.plateau.froggy.Getg());
//                root.getChildren().add(rect);
//                iv2.setImage(image);
//                iv2.setTranslateX(partie.plateau.froggy.Getg());
//                iv2.setTranslateY(partie.plateau.froggy.Getg());
//                iv2.setFitHeight(80);
//                iv2.setFitWidth(80);

                if (KeyCode.UP == event.getCode()) {
                    partie.plateau.froggy.deplacement(0, -Plateau.getY_taille_case());
//                    iv2.setTranslateY( partie.plateau.froggy.Getb());
//                    iv2.setTranslateX( partie.plateau.froggy.Getg());
//                    rect.setTranslateY( partie.plateau.froggy.Getb());
//                    rect.setTranslateX( partie.plateau.froggy.Getg());
//                    System.out.print (" ");
//                    System.out.print ("haut");
//                    //System.out.print (iv2.getTranslateX());
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getg());
//                    System.out.print ("   ");
//                    // System.out.print (iv2.getTranslateY() - Plateau.getY_taille_case() );
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getb());
//                    boxz.getChildren().add(iv2);
//                    root.getChildren().add(boxz);
                  //  root.getChildren().add(rect);
                    System.out.print ("   ");
                //stage.show();
                }
                if (KeyCode.DOWN == event.getCode()) {
                    partie.plateau.froggy.deplacement(0, 70);
////                    iv2.setTranslateY( partie.plateau.froggy.Getb());
////                    iv2.setTranslateX( partie.plateau.froggy.Getg());
//                    rect.setTranslateY( partie.plateau.froggy.Getb());
//                    rect.setTranslateX( partie.plateau.froggy.Getg());
////                    //iv2.setTranslateY(iv2.getTranslateY() + 70);
//                    System.out.print (" ");
//                    System.out.print ("bas");
////                    //System.out.print (iv2.getTranslateX());
////                    System.out.print ("   ");
////                    //System.out.print (iv2.getTranslateY() - Plateau.getY_taille_case() );
////                    System.out.print ("   ");
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getg());
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getb());
//                    boxz.getChildren().add(iv2);
//                    root.getChildren().add(boxz);
                   // root.getChildren().add(rect);
                   // stage.show();
                }

                if (KeyCode.LEFT == event.getCode()) {

                    partie.plateau.froggy.deplacement(-Plateau.getX_taille_case(), 0);
////                    iv2.setTranslateY( partie.plateau.froggy.Getb());
////                    iv2.setTranslateX( partie.plateau.froggy.Getg());
//                    rect.setTranslateY( partie.plateau.froggy.Getb());
//                    rect.setTranslateX( partie.plateau.froggy.Getg());
////                    //iv2.setTranslateX(iv2.getTranslateX() - Plateau.getX_taille_case());
//                    System.out.print (" ");
//                    System.out.print ("gauche");
////                    System.out.print (iv2.getTranslateX());
////                    System.out.print ("   ");
////                    System.out.print (iv2.getTranslateY() - Plateau.getY_taille_case() );
////                    System.out.print ("   ");
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getg());
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getb());
////                    boxz.getChildren().add(iv2);
//                    root.getChildren().add(boxz);
                  //  root.getChildren().add(rect);
                    // stage.show();
                };
                if (KeyCode.RIGHT == event.getCode()) {
                    partie.plateau.froggy.deplacement(Plateau.getX_taille_case(), 0);
//                    iv2.setTranslateY( partie.plateau.froggy.Getb());
////                    iv2.setTranslateX( partie.plateau.froggy.Getg());
//                    rect.setTranslateY( partie.plateau.froggy.Getb());
//                    rect.setTranslateX( partie.plateau.froggy.Getg());
//                    //iv2.setTranslateX(iv2.getTranslateX() + Plateau.getX_taille_case());
//                    System.out.print (" ");
//                    System.out.print ("droite");
////                    System.out.print (iv2.getTranslateX());
////                    System.out.print ("   ");
////                    System.out.print (iv2.getTranslateY() - Plateau.getY_taille_case() );
////                    System.out.print ("   ");
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getg());
//                    System.out.print (" ");
//                    System.out.print (partie.plateau.froggy.Getb());
////                    boxz.getChildren().add(iv2);
//                    root.getChildren().add(boxz);
                   // root.getChildren().add(rect);
                    // stage.show();
                }
                else {};


                //stage.sizeToScene();
                //  stage.show();

//                box.getChildren().add(iv2);
//                root.getChildren().add(box);
//                stage.show();
            });


//                iv2.setTranslateX(partie.plateau.froggy.Getg());
//                iv2.setTranslateY(partie.plateau.froggy.Getg());
//                iv2.setFitHeight(100);
//                iv2.setFitWidth(100);
            //stage.show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (Voie voie : partie.plateau.getVoies()) {
                    for (Voiture voiture : voie.voitures) {
                        voiture.deplacement_voiture();
                    }
                    voie.nouvelle_voiture();
                }
                for (Voie voie : partie.plateau.getVoies()) {
                    for (Voiture voiture : voie.voitures) {
                        if (partie.plateau.froggy.collision(voiture)) {
                            partie.plateau.froggy.Setg(700);
                            partie.plateau.froggy.Setb(650);
                            System.out.print("  ON A PERDUUUUUU  ");
                        }
                        if (voiture.proche_bord()) {
                            //voie.voitures.remove(voiture);  // TODO quand je met cette ligne ça marche plus
                            //System.out.print("  ON devrait enlever une voiture là   ");  // TODO ça ça marche bien
                        }
                    }
                }
//                HBox box = new HBox();
                root.getChildren().clear();
              //  root.getChildren().add ()
                for (Voie voie : partie.plateau.getVoies()) {
                    for (Voiture voiture : voie.voitures) {
                        try {

                            HBox box = new HBox();
                            FileInputStream inputstream = new FileInputStream("C://Users//Utilisateur//Documents//shrek.png");
                            Image image = new Image(inputstream);
                            ImageView iv2 = new ImageView();
                            iv2.setImage(image);
//                            iv2.setX(voiture.getG_voiture());
//                            iv2.setY(voiture.GetId_voiture() * Plateau.getY_taille_case());
                            iv2.setTranslateX(voiture.getG_voiture());
                            iv2.setTranslateY(Plateau.getY_taille_case() * voiture.GetId_voiture());
//                          iv2.setTranslateX(500);
                            //iv2.setTranslateY(500);
//                            iv2.setY(500);
//                            iv2.setFitHeight(Plateau.getY_taille_case());
//                            iv2.setFitWidth(voiture.GetTailleVoit()*Plateau.getY_taille_case());
                            iv2.setFitHeight(Plateau.getY_taille_case()/2);
                            iv2.setFitWidth(voiture.GetTailleVoit() * Plateau.getX_taille_case()/2);
                            //iv2.setPreserveRatio(true);
                            iv2.setSmooth(true);
                            iv2.setCache(true);
                            box.getChildren().add(iv2);
                            root.getChildren().add(box);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                }
           // root.getChildren().add(box);
               // stage.show();
                //root.getChildren().removeAll() ;
                Rectangle rect = new Rectangle(38, 38 ); //, Color.GREEN);
                //rect.setTranslateY(600 - 39);
                rect.setTranslateX(partie.plateau.froggy.Getg());
                rect.setTranslateY(partie.plateau.froggy.Getb());
                root.getChildren().add(rect);
            };
        };

//                if (partie.plateau.froggy.Geth() <= 0) {
//                    //timer.stop();
//                    String win = "YOU WIN";
//
//                    HBox hBox = new HBox();
//                    hBox.setTranslateX(300);
//                    hBox.setTranslateY(250);
//                    root.getChildren().add(hBox);
//
//                    for (int i = 0; i < win.toCharArray().length; i++) {
//                        char letter = win.charAt(i);
//
//                        Text text = new Text(String.valueOf(letter));
//                        text.setFont(Font.font(48));
//                        text.setOpacity(0);
//
//                        hBox.getChildren().add(text);
//
//                        FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
//                        ft.setToValue(1);
//                        ft.setDelay(Duration.seconds(i * 0.15));
//                        ft.play();
//                    }
//                };


        timer.start();
        stage.show();
    }


//    public void  draw_image (JFrame f, JPanel panel, Partie partie, float width_ecran, float height_ecran) {
//        // System.out.print (55);
//        // System.out.print (" ");
//        // partie.plateau.froggy.place_grenouille(panel, f,  Plateau.getX_taille_case(), partie.plateau.getY_taille_case(), width_ecran, height_ecran);
//        try {
//            //panel.setBounds(0, 0, 1920, 1080);
//            BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/Crazy_Frog.png"));
//            Image dimg = img.getScaledInstance((int)  Plateau.getX_taille_case() - (int) Plateau.getEps() *2, (int)partie.plateau.getY_taille_case()  - (int) Plateau.getEps() *2,
//                    Image.SCALE_SMOOTH);
//            //System.out.print(4321);
//            JLabel pic = new JLabel(new ImageIcon(dimg));
//            System.out.print (partie.plateau.froggy.Getg());
//            System.out.print ("  ");
//            System.out.print (partie.plateau.froggy.Getb());
//            panel.setBounds( (int) partie.plateau.froggy.Getg(), (int) height_ecran - (int) partie.plateau.froggy.Getb()- (int) partie.plateau.getY_taille_case() , (int) Plateau.getX_taille_case() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps()*2);  // pas de pb ici
//            panel.add(pic);}
//        catch (IOException ignored) {}
//        f.add(panel);
//        f.setSize((int) width_ecran, (int) height_ecran);
//        f.setLayout(null);
//        f.setVisible(true);
//    }
//
//
//    public void  draw_voitures (JFrame f, Partie partie, float width_ecran, float height_ecran) {
//        //System.out.print (" lalalala ");
//        JPanel panel2 = new JPanel();
//        for (Voie voie : partie.plateau.getVoies()) {
////            panel2 = new JPanel();
//            for (Voiture voiture : voie.voitures) {
//                try {
//                    BufferedImage img = ImageIO.read(new File("C:/Users/Utilisateur/Documents/flash_gauche.jfif"));
//                    Image dimg = img.getScaledInstance((int) Plateau.getX_taille_case() * voiture.GetTailleVoit() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps() * 2,
//                            Image.SCALE_SMOOTH);
//                    JLabel pic = new JLabel(new ImageIcon(dimg));
//                    //System.out.print (voiture.getG_voiture());
//                    panel2.setBounds((int) voiture.getG_voiture(), (int) height_ecran - (int) voie.getVoie_id() * (int) partie.plateau.getY_taille_case(), (int) Plateau.getX_taille_case() * voiture.GetTailleVoit() - (int) Plateau.getEps() * 2, (int) partie.plateau.getY_taille_case() - (int) Plateau.getEps() * 2);  // pas de pb ici
//                    panel2.add(pic);
//                    f.getContentPane().add(panel2);f.add(panel2);
//                    f.setSize((int) width_ecran, (int) height_ecran);
//                    f.setLayout(null);
//                    f.setVisible(true);
//                } catch (IOException ignored) {};
//            }
//            //f.add(panel2);  // jcp trop pk mais le truc d'en dessous marche mieux
////            f.getContentPane().add(panel2);
////            f.setSize((int) width_ecran, (int) height_ecran);
////            f.setLayout(null);
////            f.setVisible(true);
//
//        }
//
//        f.getContentPane().add(panel2);
//        f.setSize((int) width_ecran, (int) height_ecran);
//        f.setLayout(null);
//        f.setVisible(true);


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

    public void runOptions( Scene scene) {
        Stage mainStage = new Stage() ;
        mainStage.setScene(scene);
        mainStage.setFullScreen(true);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args) ;
    }
}