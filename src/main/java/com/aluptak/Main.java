package com.aluptak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


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
