package com.aluptak.platformio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Platformio {

    private List<Board> boards;

    public void uploadSketch(Sketch sketchPath) {

    }

    public List<Board> listBoards() {
        if (this.boards == null) {
            boards = fetchBoards();
        }
        return boards;
    }

    public List<Device> listDevices() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Future<ProcessResult> future = new ProcessExecutor()
                    .command("platformio", "device", "list", "--json-output")
                    .readOutput(true)
                    .start().getFuture();
            String output = future.get(60, TimeUnit.SECONDS).outputUTF8();
            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(List.class, Device.class);
            return mapper.readValue(output, type);
        } catch (IOException | InterruptedException | TimeoutException | ExecutionException e) {
            throw new PlatformioException(String.format("Can't list devices %s $s", e.getMessage(), e));
        }
    }

    private List<Board> fetchBoards() {
        return null;
    }

    private class PlatformioException extends RuntimeException {
        public PlatformioException(String message) {
            super(message);
        }
    }
}
