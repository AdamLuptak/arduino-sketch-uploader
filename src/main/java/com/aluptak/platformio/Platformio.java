package com.aluptak.platformio;

import java.util.List;

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

    private List<Board> fetchBoards() {
        return null;
    }
}
