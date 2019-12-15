package model;

import ai.Simulator;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    private Board board;
    private Simulator sim;
    private GraphicsContext gc;
    private long delayInterval;
    private long delayTimer;

    public GameLoop(Board board, Simulator sim,  GraphicsContext gc) {
        this.board = board;
        this.sim = sim;
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
                if (sim != null) {
                    sim.getMoveSearch();
                }
                board.update();

                delayTimer = System.currentTimeMillis();
                delayInterval = calculateDelayInterval();
            }
        }
        Painter.paintEndGame(gc);
    }

    private int calculateDelayInterval() {
        int score = board.getScore();
        if (score >= 10 && score < 15) {
            return 90;
        } else if (score >= 15 && score < 20) {
            return 80;
        } else if (score >= 20 && score < 25) {
            return 70;
        } else if (score >= 25 && score < 30) {
            return 60;
        } else if (score >= 30 && score < 40) {
            return 50;
        } else if (score >= 40) {
            return 40;
        }
        return 100;
    }
}
