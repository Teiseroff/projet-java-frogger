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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color ;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group() ;

        Button btn = new Button() ;
        btn.setText("START") ;
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                mainstart(primaryStage) ;
            }
        });

        Text crazyfrog_title = new Text();
        crazyfrog_title.setText("CRAZY FROG");

        crazyfrog_title.setX(50) ;
        crazyfrog_title.setY(50) ;
        btn.setLayoutX(70);
        btn.setLayoutY(50); 

        root.getChildren().add(btn) ;
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
    }

    public void mainstart(Stage primaryStage) {
        StackPane root_mainMenu = new StackPane() ;
        Scene mainMenu = new Scene(root_mainMenu, 1920, 1080, Color.BLACK) ;
        


        primaryStage.setScene(mainMenu);
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args) ;
    }

}