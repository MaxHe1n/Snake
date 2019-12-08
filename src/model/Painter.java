package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

// TODO - tidy up
class Painter {

    static void paint(Board board, GraphicsContext gc) {
        gc.setFill(new Color(0.1, 0.1, 0.1, 1));
        gc.fillRect(0, 0, 500, 500);

        // Now the food
        Food food = board.getFood();
        gc.setFill(Color.SPRINGGREEN);
        paintPoint(food.getPosition(), gc);

        Food superFood = board.getSuperFood();
        if (superFood != null ) {
            gc.setFill(Color.RED);
            paintPoint(superFood.getPosition(), gc);
        }

        // Now the snake
        Snake snake = board.getSnake();
        gc.setFill(Color.CORNSILK);
        List<Point> position = snake.getPosition();
        paintSnakePoint(board, position.get(0), null, position.get(1), gc);
        for (int i = 1; i < position.size() - 1; ++i) {
            gc.setFill(Color.CORNSILK);
            paintSnakePoint(board, position.get(i), position.get(i-1), position.get(i+1), gc);
        }
        gc.setFill(Color.CORNSILK);
        paintSnakePoint(board, position.get(position.size()-1), position.get(position.size()-2), null, gc);

        // The score
        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + board.getScore() * 10, 10, 490);
    }

    static void paintEndGame(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Game Over", 220, 250);
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect((point.getXCord() * 10) + 1, (point.getYCord() * 10) + 1, 8, 8);
    }

    private static void paintSnakePoint(Board board, Point point, Point pointHistoric, Point pointFuture, GraphicsContext gc) {

        gc.fillRect(point.getXCord() * 10, point.getYCord() * 10, 10, 10);

        if (pointHistoric != null || pointFuture != null) {
            gc.setFill(new Color(0.1, 0.1, 0.1, 1));
            //was horazontal going to be vertical
            if (!point.isLeftOf(board, pointHistoric) && !point.isLeftOf(board, pointFuture))
                gc.fillRect((point.getXCord() * 10) + 9, point.getYCord() * 10, 1, 10);
                //was vertical going to be horazontal
            if (!point.isrRightOf(board, pointHistoric) && !point.isrRightOf(board, pointFuture))
                gc.fillRect(point.getXCord() * 10, point.getYCord() * 10, 1, 10);
                // was horozontal going to be horazontal
            if (!point.isAboveOf(board, pointHistoric) && !point.isAboveOf(board, pointFuture))
                gc.fillRect(point.getXCord() * 10, (point.getYCord() * 10) + 9, 10, 1);
                //was vertical going to be vertical
            if (!point.isBelowOf(board, pointHistoric) && !point.isBelowOf(board, pointFuture))
                gc.fillRect(point.getXCord() * 10, point.getYCord() * 10, 10, 1);
        }
    }
}