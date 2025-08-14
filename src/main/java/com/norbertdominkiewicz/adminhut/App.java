package com.norbertdominkiewicz.adminhut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {
    private double x, y = 0;
    private static Scene scene;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        scene = new Scene(loadFXML("main-view"), 900, 600);
        scene.setFill(Color.TRANSPARENT);
        AppMouseMovement();
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.initStyle(StageStyle.TRANSPARENT);
        this.stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void AppMouseMovement() {
        scene.setOnMousePressed((MouseEvent event) -> {
            x = event.getScreenX() - stage.getX();
            y = event.getScreenY() - stage.getY();
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x); 
            stage.setY(event.getScreenY() - y);
        });
    }

}