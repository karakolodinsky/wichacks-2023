package com.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        scene = new Scene(root, 900, 600, Color.web("#a3d2e3"));
        stage.setScene(scene);

        Image image = new Image("C:\\Users\\allis\\OneDrive\\Desktop\\demo\\src\\main\\java\\com\\example\\CharacterThumbnail.png");

        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        root.getChildren().add(iv1);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}