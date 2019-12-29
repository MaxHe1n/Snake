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

    public void paint(Board board, GraphicsContext gc) {
        Platform.runLater(() -> {

            // fills background
            gc.setFill(black);
            gc.fillRect(0, 0, 500, 500);

            // food one
            gc.setFill(Color.SPRINGGREEN);
            paintPoint(board.getFood().getPosition(), gc, 0);

            // food two
            if (board.getSuperFood() != null ) {
                gc.setFill(Color.RED);
                paintPoint(board.getSuperFood().getPosition(), gc, 0);
            }

            // snake
            gc.setFill(Color.CORNSILK);
            for (Point p : board.getSnake().getPosition()) {
                paintPoint(p, gc, 0);
            }

        });
    }

    public void paintEndGame(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Game Over", 220, 250);
    }

    private void paintPoint(Point point, GraphicsContext gc, int offset) {
        gc.fillRect((point.getXCord() * 10) + offset, (point.getYCord() * 10) + offset, 10 - offset, 10 - offset);
    }

}
