package ai;

import model.Board;

public class Simulator {

    private Board board;

    public Simulator(Board board) {
        this.board = board;
    }

    public void setMove() {
        board.getSnake().moveUp();
    }

}
