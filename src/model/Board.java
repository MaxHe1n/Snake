package model;

import java.util.List;

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

//    public void printBoard() {
//        List<Point> points = snake.getPosition();
//        for (int y = 0; y < HEIGHT; ++y) {
//            for (int x = 0; x < WIDTH; ++x) {
//                Point temp = new Point(x,y);
//                String res = contains(points, temp) ? "-" : " ";
//                System.out.print(res);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//    private boolean contains(List<Point> points, Point point) {
//        for (Point p : points) {
//            if (p.equals(point)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
