package model;

// TODO - comments, javadocs, loging
public class Board {

    private int size;
    private Snake snake;

    public Board(int size){
        this.size = size;
        this.snake = new Snake(this, new Point(size/2, size/2));
    }

    public void update() {
        snake.update();
    }

    public int getSize() {
        return size;
    }
}
