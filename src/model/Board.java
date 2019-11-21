package model;

// TODO - comments, javadocs, loging
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
            score += 100;
            for (int i = 0; i < food.getValue(); ++i) {
                snake.grow();
            }
            food = new Food(this, 1);
        }
        snake.update();
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
