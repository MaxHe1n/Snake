package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Board;
import model.Point;

public class View extends Canvas {

    private Color black = new Color(0.1, 0.1, 0.1, 1);

    public View(int width, int height) {
        super(width, height);
    }

    public void initPaint(Board board) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            // fills background
            gc.setFill(black);
            gc.fillRect(0, 0, 500, 500);

            // init snake
            gc.setFill(Color.CORNSILK);
            for (Point p : board.getSnake().getPosition()) {
                paintPoint(p, gc, 0);
            }
        });

        //paintScore(board.getScore());
        paintFood(board.getFood().getPosition(), board.getFood().getPosition(), Color.SPRINGGREEN);
    }

    public void paintSnake(Point oldTail, Point currentHead) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            gc.setFill(black);
            paintPoint(oldTail, gc, 0);

            gc.setFill(Color.CORNSILK);
            paintPoint(currentHead, gc, 0);
        });
    }

    public void paintFood(Point old, Point current, Color color) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            if (old != null) {
                gc.setFill(black);
                paintPoint(old, gc, 0);
            }

            if (current != null) {
                gc.setFill(color);
                paintPoint(current, gc, 0);
            }
        });
    }

    public void paintScore(int score) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            gc.setFill(black);
            gc.fillRect(10, 480, 100, 10);

            gc.setFill(Color.CORNSILK);
            gc.fillText(String.format("Score: %s", score * 10), 10, 490);
        });
    }

    public void paintEndGame(GraphicsContext gc) {
        Platform.runLater(() -> {
            gc.setFill(Color.AQUAMARINE);
            gc.fillText("Game Over", 220, 250);
        });
    }

    private void paintPoint(Point point, GraphicsContext gc, int offset) {
        gc.fillRect((point.getXCord() * 10) + offset, (point.getYCord() * 10) + offset, 10 - offset, 10 - offset);
    }

}
