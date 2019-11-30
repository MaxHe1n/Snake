package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        snake.getPosition().forEach(point -> paintPoint(point, gc));

        // The score
        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + board.getScore() * 10, 10, 490);
    }

    static void paintEndGame(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Game Over", 220, 250);
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect(point.getXCord() * 10, point.getYCord() * 10, 10, 10);
    }
}