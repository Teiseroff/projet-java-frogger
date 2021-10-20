package com.frogger;

import javafx.application.Application ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color ;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


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

        crazyfrog_title.setX(50) ;
        crazyfrog_title.setY(50) ;
        start_btn.setLayoutX(70);
        start_btn.setLayoutY(50);

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

        Scene titleMenu = new Scene(root, 500, 400, Color.LIGHTSKYBLUE) ;
        Stage stage = new Stage() ;

        stage.setTitle("Crazy Frog");
        stage.setScene(titleMenu);

        //Image window_icon = new Image("Users/hendr/Desktop/COURS/S3/JAVA/projet-java-frogger/src/resources/assets/shrek.png") ;
        //stage.getIcons().add(window_icon) ;
        stage.show();

        //Image billard = new Image("") ;

    }

    public void mainstart() {
        Group root_mainMenu = new Group() ;
        Group root_game = new Group() ;
        Group root_options = new Group() ;
        Scene mainMenu = new Scene(root_mainMenu, 1920, 1080, Color.BLACK) ;
        Stage mainStage = new Stage() ;

        Scene game_scene = new Scene(root_game, 1920, 1080, Color.GREEN) ;

        Button gamestart_btn = new Button() ;
        gamestart_btn.setText("GAME START");
        root_mainMenu.getChildren().add(gamestart_btn) ;
        gamestart_btn.setLayoutX(0);
        gamestart_btn.setLayoutY(50);
        gamestart_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){gamestart(mainStage, game_scene) ;
            }
        });

        Scene options_scene = new Scene(root_options,1920,1080, Color.GREY) ;

        Button options_button = new Button() ;
        options_button.setText("OPTIONS");
        root_mainMenu.getChildren().add(options_button) ;
        options_button.setLayoutX(0);
        options_button.setLayoutY(-50);
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

    public void gamestart(Stage stage, Scene scene) {
        stage.setScene(scene) ;
    }

    public void runOptions(Stage stage, Scene scene) {
        stage.setScene(scene) ;
    }



    public static void main(String[] args) {

        launch(args) ;

    }

}