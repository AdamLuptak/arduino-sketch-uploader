package com.aluptak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JavaFx extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Enter your name");
        TextField textField = new TextField();
        Button button = new Button("OK");
        button.setOnAction(e ->{
            String msg = "";
            String name = textField.getText();
            if(name.trim().length() > 0){
                msg = "Hello " + name;
            }else {
                msg = "Hello there";
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information dialog");
            alert.setHeaderText("header");
            alert.setContentText(msg);
            alert.showAndWait();

        });
        VBox root = new VBox(label,textField,button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
