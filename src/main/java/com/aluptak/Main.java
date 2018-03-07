package com.aluptak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main extends Application {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }


    private Parent rootNode;

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        Controller controller = fxmlLoader.getController();
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(new Scene(rootNode));
        this.setPrimaryStage(stage);
        stage.show();
    }

    public void commandLine() {
        try {
            new ProcessExecutor()
                    .directory(new File("C:\\Users\\adam\\git\\ecap\\arduino"))
                    .command("platformio", "-f", "-c", "clion", "run", "--target", "upload")
                    .redirectErrorStream(true)
                    .redirectOutput(new LogOutputStream() {
                        @Override
                        protected void processLine(String line) {
                            logger.info(line);
                        }
                    })
                    .execute();
        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
