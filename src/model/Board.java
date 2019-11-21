package model;

public class Board {

    private int width;
    private int height;
    private Snake snake;
    private Food food;
    private Food superFood;
    private int superFoodTimer;
    private int score;

    public Board(int WIDTH, int HEIGHT) {
        this.width = WIDTH/10;
        this.height = HEIGHT/10;
        this.snake = new Snake(this, new Point(width/2, height/2), 4);
        this.food = new Food(this, 1);
        this.superFoodTimer = 0;
        this.score = 0;
    }

    void update() {
        if (snake.getHead().equals(food.getPosition())) {
            score += food.getValue();
            snake.grow();
            food = new Food(this, 1);

            if (superFood == null) {
                if (((int) (Math.random()*10)) == 5) {
                    superFood = new Food(this, 3);
                    superFoodTimer = 100;
                }
            }
        }

        if (superFood != null && snake.getHead().equals(superFood.getPosition())) {
            score += superFood.getValue();
            snake.grow();
            superFood = null;
            superFoodTimer = 0;
        } else if (superFood != null && superFoodTimer > 0) {
            superFoodTimer--;
        } else if (superFood != null && superFoodTimer == 0) {
            superFood = null;
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

    Food getSuperFood() {
        return superFood;
    }

    int getScore() {
        return score;
    }
}
