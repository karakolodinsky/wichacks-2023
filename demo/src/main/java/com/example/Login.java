package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        
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

        VBox textFields = new VBox();
        textFields.getChildren().addAll(username, password);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(signIn, textFields, login);
        vbox.setAlignment(Pos.CENTER);


        primaryStage.setScene(new Scene(vbox));
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
