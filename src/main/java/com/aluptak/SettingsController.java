package com.aluptak;

import com.aluptak.platformio.Board;
import com.aluptak.platformio.Device;
import com.aluptak.platformio.Platformio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SettingsController implements Initializable {

    final static Logger logger = LoggerFactory.getLogger(SettingsController.class);


    @FXML
    ComboBox portComboBox;

    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    private Platformio platformio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        platformio = new Platformio();
        setupPorts();
    }

    private void setupPorts() {
        ObservableList<String> ports = platformio.
                listDevices()
                .stream().map(Device::getPort)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        portComboBox.setItems(ports);
        portComboBox.getSelectionModel().selectFirst();
    }


    public void SetRootPath(ActionEvent actionEvent) {
        Stage primaryStage = Main.getPrimaryStage();
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            openFile(file);
        }
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
