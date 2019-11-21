package model;

import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    private Board board;
    private GraphicsContext gc;
    private long delayInterval;
    private long delayTimer;

    public GameLoop(Board board, GraphicsContext gc) {
        this.board = board;
        this.gc = gc;
        this.delayInterval = 100;
        this.delayTimer = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (board.getSnake().isSafe()) {

            long lastExecutionDelay = System.currentTimeMillis() - delayTimer;
            if (lastExecutionDelay > delayInterval) {

                Painter.paint(board, gc);
                board.update();

                delayTimer = System.currentTimeMillis();
            }
        }
        Painter.paintEndGame(gc);
    }
}
