package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Board;
import model.Point;

import java.util.List;

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
            gc.fillRect(0, 0, this.getWidth(), this.getHeight());

            // fills in init snake
            gc.setFill(Color.CORNSILK);
            for (Point p : board.getSnake().getPosition()) {
                paintPoint(p, gc, 0, 0);
            }
        });

        //paintScore(board.getScore());
        paintFood(board.getFood().getPosition(), board.getFood().getPosition(), Color.SPRINGGREEN);
    }

    public void paintSnake(List<Point> oldSnake, List<Point> currentSnake) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            gc.setFill(black);
            paintPoint(oldSnake.get(0), gc, 0, 0);

            gc.setFill(Color.CORNSILK);
            paintPoint(currentSnake.get(currentSnake.size()-1), gc, 0, 0);
        });
    }

    public void paintFood(Point old, Point current, Color color) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            if (old != null) {
                gc.setFill(black);
                paintPoint(old, gc, 0, 0);
            }

            if (current != null) {
                gc.setFill(color);
                paintPoint(current, gc, 0, 0);
            }
        });
    }

    public void paintScore(int score) {
        Platform.runLater(() -> {
            GraphicsContext gc = this.getGraphicsContext2D();

            gc.setFill(black);
            gc.fillRect(10, this.getHeight() - 20, 100, 10);

            gc.setFill(Color.CORNSILK);
            gc.fillText(String.format("Score: %s", score * 10), 10, this.getHeight() - 10);
        });
    }

    public void paintEndGame(GraphicsContext gc) {
        Platform.runLater(() -> {
            gc.setFill(Color.AQUAMARINE);
            gc.fillText("Game Over", (this.getWidth() / 2) - 30, this.getHeight() / 2);
            gc.fillText("Hit enter to play again!", (this.getWidth() / 2) - 60, (this.getHeight() / 2) + 15);
        });
    }

    private void paintPoint(Point point, GraphicsContext gc, int offsetX, int offsetY) {
        gc.fillRect((point.getXCord() * 10) + offsetX, (point.getYCord() * 10) + offsetY, 10 - offsetX, 10 - offsetY);
    }

}
