package com.project.thursday;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static String FXML_LOCATION = "main_menu.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_MODENA);

        // parses FXML view
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_LOCATION));
        Parent root = loader.load();

        // scene which contains the FXML parsed components
        Scene scene = new Scene(root,1000, 1000);
        scene.getStylesheets().add("application.css");
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
