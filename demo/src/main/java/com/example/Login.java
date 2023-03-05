package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                  if (username.getText().equals("") || String.valueOf(password.getText()).equals("")) {
                }
                else if (verifyLogin(username.getText(),
                String.valueOf(password.getText())) != -1){
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

    public static void main(String[] args) {
        launch(args);
    }


        /**
     *
     * @param username
     * @param password
     * @return if the user exists, it returns the user id.
     */
    public static int verifyLogin(String username, String password) {
        String instanceConnectionName = "vast-zodiac-379618:us-central1:wichacks";
        String databaseName = "dressUp";


        String IP_of_instance = "10.83.160.3";
        String username1 = "wichacks";
        String password1 = "imsohungry";

        String jdbcUrl = String.format(
                "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
                 + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
        IP_of_instance,
        databaseName,
        instanceConnectionName);

        try {
                Connection conn = DriverManager.getConnection(jdbcUrl, username1, password1);
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select username, password from userInfo where username=?;");

            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (password == rs.getString(2)) {
                    return 1;
                    //update most recent access date
                }
                else return -1;
        }
            
        } catch (SQLException e) {

        }

        return -1;

    }
}
