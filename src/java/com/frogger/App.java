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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color ;

import com.frogger.gamelogic.Partie;

import java.io.InputStream;


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

//        InputStream get_crazyFrog_icon = App.class.getResourceAsStream("/assets/Crazy_Frog.png");
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

        Scene game_scene = new Scene(root_game, 1920, 1080, Color.GREEN) ;

        Button gamestart_btn = new Button() ;
        gamestart_btn.setText("GAME START");
        root_mainMenu.getChildren().add(gamestart_btn) ;
        gamestart_btn.setLayoutX(900);
        gamestart_btn.setLayoutY(650);
        gamestart_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gamestart(mainStage, game_scene) ;
            }
        });

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

    public void gamestart(Stage stage, Scene scene) {
        stage.setScene(scene) ;
        stage.setFullScreen(true);

        Partie partie = new Partie(8);
        partie.jeu();
//          TitreKeyListener tkl = new TitreKeyListener();

        stage.show();
    }

    public void runOptions(Stage stage, Scene scene) {
        stage.setScene(scene) ;
        stage.setFullScreen(true);
        stage.show();
    }



    public static void main(String[] args) {

        launch(args) ;

    }

}