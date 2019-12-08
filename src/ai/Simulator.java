package ai;

import model.Board;
import model.Point;

public class Simulator {

    private Board board;

    public Simulator(Board board) {
        this.board = board;
    }

    public void setMove() {
        Point food = board.getFood().getPosition();
        Point snake = board.getSnake().getHead();

        if (snake.getXCord() < food.getXCord()) {
            board.getSnake().moveRight();
        } else if (snake.getXCord() > food.getXCord()) {
            board.getSnake().moveRight();
        } else if (snake.getYCord() < food.getYCord()) {
            board.getSnake().moveDown();
        } else if (snake.getYCord() > food.getYCord()) {
            board.getSnake().moveUp();
        }

    }

}
