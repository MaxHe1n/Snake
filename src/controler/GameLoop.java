package controler;

import javafx.scene.paint.Color;
import view.View;
import ai.Simulator;
import model.Board;

public class GameLoop implements Runnable {

    private static long delayInterval = 100;

    private View view;
    private Board board;
    private Simulator sim;
    private long delayTimer;

    public GameLoop(Board board, Simulator sim, View view) {
        this.view = view;
        this.board = board;
        this.sim = sim;
        this.delayTimer = System.currentTimeMillis();
    }

    @Override
    public void run() {

        Board boardSave = new Board(board.getSnake(), board.getFood(), board.getSuperFood(), board.getScore());
        view.initPaint(board);

        while (board.getSnake().isSafe()) {

            long lastExecutionDelay = System.currentTimeMillis() - delayTimer;
            if (lastExecutionDelay > delayInterval) {

                if (sim != null) {
                    sim.getMoveSearch();
                }
                board.update();

                //view.paintScore(board.getScore());

                if (boardSave.getSuperFood() != null && board.getSuperFood() != null) {
                    view.paintFood(boardSave.getSuperFood().getPosition(), board.getSuperFood().getPosition(), Color.RED);
                } else if(board.getSuperFood() != null) {
                    view.paintFood(null, board.getSuperFood().getPosition(), Color.RED);
                } else if(boardSave.getSuperFood() != null) {
                    view.paintFood(boardSave.getSuperFood().getPosition(), null, Color.RED);
                }

                view.paintFood(boardSave.getFood().getPosition(), board.getFood().getPosition(), Color.SPRINGGREEN);
                view.paintSnake(boardSave.getSnake().getPosition(), board.getSnake().getPosition());

                boardSave = new Board(board.getSnake(), board.getFood(), board.getSuperFood(), board.getScore());

                delayTimer = System.currentTimeMillis();
                delayInterval = calculateDelayInterval();
            }
        }
        view.paintEndGame(view.getGraphicsContext2D());
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
