package model;

// TODO - comments, javadocs, loging
public class Board {

    private int WIDTH;
    private int HEIGHT;
    private Snake snake;

    public Board(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH/10;
        this.HEIGHT = HEIGHT/10;
        this.snake = new Snake(this, new Point(WIDTH/2, HEIGHT/2));
        snake.grow();
        snake.grow();
        snake.grow();

    }

    public void update() {
        snake.update();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public Snake getSnake() {
        return snake;
    }
}
