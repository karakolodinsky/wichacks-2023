package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;


    @Override
    public void start(Stage stage) throws IOException {
        VBox layout = new VBox();
        VBox layout2 = new VBox();
     
        Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));

        layout.getStyleClass().add("color-palette");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#a3d2e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        layout2.getStyleClass().add("color-palette");
        layout2.setBackground(new Background(new BackgroundFill(Color.web("#c5a4eb"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout2.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        Scene scene2 = new Scene(layout2, 900, 600);
         
        Button button = new Button("Forward");
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.setOnAction(e -> stage.setScene(scene2));
         
        Button button2 = new Button("Backwards");
        button2.setOnAction(e -> stage.setScene(scene));
         
        TextField text = new TextField();
        text.setMaxWidth(200);
             
        layout.getChildren().addAll(button, text);
        layout2.getChildren().addAll(button2, text);
        stage.setTitle("CultiDress");
        stage.setScene(scene);   
        stage.show();
        // VBox layout = new VBox();
        // VBox layout2 = new VBox();

        // Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));
        // Scene scene2 = new Scene(layout2, 900, 600, Color.web("#c5a4eb"));
        // stage.setScene(scene);

        // Image image = new Image("file:IMAGES\\CharacterThumbnail.png");

        // Label label1 = new Label("Name:");
        // TextField textField = new TextField();
        // HBox hb = new HBox();
        // hb.getChildren().addAll(label1, textField);
        // hb.setSpacing(10);

        // Button submit = new Button("Next");
        // submit.setOnAction(e -> primaryStage.setScene(scene2));


        // ImageView iv1 = new ImageView();
        // iv1.setImage(image);
        // layout.getChildren().addAll(iv1, hb, submit);


        

        // stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}