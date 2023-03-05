package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

// import org.checkerframework.common.subtyping.qual.Bottom;

// import com.google.api.services.sqladmin.SQLAdmin.BackupRuns.List;


/**
 * JavaFX App
 */
public class App extends Application {



    private Scene scene;
    private Stage primaryStage;
    String vboxVal;
    private  Image body;
    private  Image top;
    private  Image bottom;
    private  Image hair;
    private  Image shoes;
    private  Image cult;
    private static GridPane bottomsbox;
    private static ImageView imageView;
    private static ImageView imageView2;
    private static ImageView imageView3;
    private static ImageView imageView4;
    private static ImageView imageView5;
    private static ImageView imageView6;
    
    

    static int topsindex = 0;
    static int pantsindex = 0;


    @Override
    public void start(Stage stage) throws IOException {
        Apps ap = new Apps(null, null, null, null, null, null);
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

        Label name = new Label("Name");

         
        Button button = new Button("Save");
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.setOnAction(e -> stage.setScene(scene2));
         
        TextField text = new TextField();
        text.setMaxWidth(200);

        body = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Character.png");
        ap.setBody(body);
        top = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve.png");
        ap.setTop(top);
        bottom = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Baggy.png");
        ap.setBottom(bottom);
        hair = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Hair\\Low_Bun.png");
        ap.setHair(hair);
        shoes = new Image( "file:demo\\src\\main\\java\\com\\example\\IMAGES\\Shoes\\Flats.png");
        ap.setShoes(shoes);
        cult = null;
        ap.setCult(cult);
        imageView = new ImageView(ap.getBody());
        imageView.setFitWidth(425);
        imageView.setFitHeight(425);
        imageView.setX(0);
        imageView.setY(0);
        imageView2 = new ImageView(ap.getTop());
        imageView2.setFitWidth(425);
        imageView2.setFitHeight(425);
        imageView2.setX(0);
        imageView2.setY(0);
        imageView3 = new ImageView(ap.getBottom());
        imageView3.setFitWidth(425);
        imageView3.setFitHeight(425);
        imageView3.setX(0);
        imageView3.setY(0);
        imageView4 = new ImageView(ap.getHair());
        imageView4.setFitWidth(425);
        imageView4.setFitHeight(425);
        imageView4.setX(0);
        imageView4.setY(0);
        imageView5 = new ImageView(ap.getShoes());
        imageView5.setFitWidth(425);
        imageView5.setFitHeight(425);
        imageView5.setX(0);
        imageView5.setY(0);
        imageView6 = new ImageView(ap.getCult());
        imageView6.setFitWidth(425);
        imageView6.setFitHeight(425);
        imageView6.setX(0);
        imageView6.setY(0);

        StackPane stackp = new StackPane();
        stackp.setAlignment(Pos.CENTER_LEFT);
        stackp.getChildren().addAll(imageView, imageView2, imageView3, imageView4, imageView5);
        
        
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("body", "shoes", "top", "bottom", "hair");
        cb.setValue("body");
        final ColorPicker colorPicker = new ColorPicker();
        // EventHandler<ActionEvent> nakedevent = new EventHandler<ActionEvent>() {
        //         public void handle(ActionEvent e){
        //                 top = null;
        //                 bottom = null;
        //                 shoes = null;
        //                 cult = null;
        //                 hair =null;

        //         }
        // };


        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                        Color c = colorPicker.getValue();
                        Lighting lighting = new Lighting(new Light.Distant(45, 90, c));
                        ColorAdjust bright = new ColorAdjust(0, 0, 0, .1);
                        lighting.setContentInput(bright);
                        lighting.setSurfaceScale(0.0);
                        String val = cb.getValue();
                        switch (val){
                                case "body": imageView.setEffect(lighting);
                                case "shoes": imageView5.setEffect(lighting);
                                case "top": imageView2.setEffect(lighting);
                                case "bottom": imageView3.setEffect(lighting);
                                case "hair": imageView4.setEffect(lighting);
                        }
                        // todo: fix
                        
                        
                
                }
        };

        // ArrayList<String> bottoms = new ArrayList<>();
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Baggy.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Flared.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Skinny.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Straight.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Shin.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_short.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Thigh.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\LongSkirt.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\MedSkirt.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_LongSkirt.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_MedSkirt.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\ShortSkirt.png");
        // bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_ShortSkirt.png");

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        ArrayList<String> bottoms = new ArrayList<>();
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Baggy.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Flared.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Skinny.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Pants_Straight.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Shin.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_short.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Pants\\Shorts_Thigh.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\LongSkirt.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\MedSkirt.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_LongSkirt.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_MedSkirt.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\ShortSkirt.png");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Bottoms\\Skirts\\Pleated_ShortSkirt.png");

        GridPane bottomsbox = new GridPane();
        pantsindex = 0;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 4; ++col) {
                Button buttons = new Button();
                Image cloth = new Image(bottoms.get(pantsindex));
                ImageView cloths = new ImageView(cloth);
                cloths.setFitWidth(90);
                cloths.setFitHeight(90);
                buttons.setGraphic(cloths);
                buttons.setMinWidth(90);
                buttons.setMinHeight(90);
                ImageView cloth2 = new ImageView(cloth);
                cloth2.setFitWidth(425);
                cloth2.setFitHeight(425);

                buttons.setOnAction(e ->  imageView3.setImage(cloth)
                );
                bottomsbox.add(buttons, col, row);
                pantsindex++;
            }
        }
        VBox vbox2 = new VBox(bottomsbox);
        vbox2.maxWidth(100);

        ArrayList<String> tops = new ArrayList<>();
        tops.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_LongSleeve_Cropped.png");
        tops.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_LongSleeve.png");
        tops.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve.png");
        tops.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_ShortSleeve_Cropped.png");
        tops.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_Sleeveless");
        bottoms.add("file:demo\\src\\main\\java\\com\\example\\IMAGES\\Tops\\CrewNeck_Sleeveless_Cropped");


        // GridPane topsbox = new GridPane();
        // topsindex = 0;
        // for (int row = 0; row < 3; ++row) {
        //     for (int col = 0; col < 4; ++col) {
        //         Button buttons = new Button();
        //         Image cloth = new Image(tops.get(topsindex));
        //         ImageView cloths = new ImageView(cloth);
        //         cloths.setFitWidth(200);
        //         cloths.setFitHeight(200);
        //         buttons.setGraphic(cloths);
        //         buttons.setMinWidth(90);
        //         buttons.setMinHeight(90);
        //         ImageView cloth2 = new ImageView(cloth);
        //         cloth2.setFitWidth(425);
        //         cloth2.setFitHeight(425);

        //         buttons.setOnAction(e ->  imageView3.setImage(cloth)
        //         );
        //         bottomsbox.add(buttons, col, row);
        //         pantsindex++;
        //     }
        // }
        

        
        
        VBox culturebox = new VBox();
        // GridPane bottomsbox = new GridPane();
        // pantsindex = 0;
        // for (int row = 0; row < 3; ++row) {
        //     for (int col = 0; col < 4; ++col) {
        //         Button buttons = new Button();
        //         Image cloth = new Image(bottoms.get(pantsindex));
        //         buttons.setGraphic(new ImageView(cloth));
        //         buttons.setOnAction(e -> bottom = new Image(bottoms.get(pantsindex)));
        //         bottomsbox.add(buttons, col, row);
        //         pantsindex++;
        //     }
        // }

       
        VBox shoesbox = new VBox();
        
        VBox hairbox = new VBox();
        VBox tradbox = new VBox();
        VBox topsbox = new VBox();

        ChoiceBox<String> cb2 = new ChoiceBox<>();
        cb2.getItems().addAll("hair", "tops", "bottoms", "shoes", "traditional");
        cb2.setValue("bottoms");

        // String val2 = cb2.getValue();
        // switch (val2){
        //         case "hair": bottomsbox.setVisible(false);
        //         case "tops": bottomsbox.setVisible(false);
        //         case "bottoms": bottomsbox.setVisible(true);
        //         case "shoes": bottomsbox.setVisible(false);
        //         case "traditional": bottomsbox.setVisible(false);
        // }

        // vbox2.getChildren().addAll(bottomsbox, hairbox, tradbox, topsbox,shoesbox, hairbox);
  
        vbox.getChildren().addAll(cb2);
        

        hbox.getChildren().addAll(stackp, vbox, vbox2);



        colorPicker.setOnAction(event);
        // layout.getChildren().addAll(GridPane)
        layout.getChildren().addAll(name, text, hbox, colorPicker, cb);
        stage.setTitle("CultiDress");
        stage.setScene(scene); 
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



}