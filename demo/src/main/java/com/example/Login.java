package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

import com.google.api.client.util.Data;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        

        VBox layout = new VBox();
     
        Scene scene = new Scene(layout, 900, 600, Color.web("#a3d2e3"));

        layout.getStyleClass().add("color-palette");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#a3d2e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, null, null)));
        primaryStage.setMinWidth(600);
        

        Label signIn = new Label("Sign In");
        signIn.setFont(new Font("Impact", 24));
        signIn.setAlignment(Pos.CENTER);
        signIn.setTextFill(Color.CORNFLOWERBLUE);

        TextField username = new TextField("");
        username.setPromptText("Enter username");

        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");

        Button login = new Button("Login");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                  if (username.getText().equals("") || String.valueOf(password.getText()).equals("")) {
                } else
                                if (Database.verifyLogin(username.getText(),
                                password.getText()) == -1){
                                        Application.launch(App.class);

                                }
            };
        };
        login.setOnAction(event);

        VBox textFields = new VBox();
        textFields.getChildren().addAll(username, password);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(signIn, textFields, login);
        vbox.setAlignment(Pos.CENTER);


        primaryStage.setScene(new Scene(vbox));
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

}
