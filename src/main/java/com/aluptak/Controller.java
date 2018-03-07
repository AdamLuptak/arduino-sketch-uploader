package com.aluptak;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public void settings(ActionEvent actionEvent) throws IOException {
        Stage dialog = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Settings.fxml"));
        Scene scene = new Scene( fxmlLoader.load());
        dialog.setScene(scene);
        Stage primaryStage = Main.getPrimaryStage();
        dialog.getIcons().addAll(primaryStage.getIcons());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.show();
    }

    public void about(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About ArduinoSketch uploader");
        alert.setHeaderText("ArduinoSketch uploader");
        alert.setContentText("Copyright © 2018 Adam Luptak All rights reserved.");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("icon.png"));
        alert.showAndWait();
    }

    @FXML
    public void validation(Event event) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("start");

    }
}
