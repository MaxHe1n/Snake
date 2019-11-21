package model;

public class Board {

    private int width;
    private int height;
    private Snake snake;
    private Food food;
    private int score;

    public Board(int WIDTH, int HEIGHT) {
        this.width = WIDTH/10;
        this.height = HEIGHT/10;
        this.snake = new Snake(this, new Point(width/2, height/2), 4);
        this.food = new Food(this, 1);
        this.score = 0;
    }

    void update() {
        if (snake.getHead().equals(food.getPosition())) {
            food = foodEaten(food);
        }
        snake.update();
    }

    private Food foodEaten(Food f) {
        score += f.getValue();
        snake.grow();
        return new Food(this, f.getValue());
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    Food getFood() {
        return food;
    }

    int getScore() {
        return score;
    }
}
