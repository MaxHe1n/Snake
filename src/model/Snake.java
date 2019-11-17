package model;

import java.util.ArrayList;
import java.util.List;

// TODO - comments, javadocs, loging, testing
public class Snake {

    private Board board;
    private Point head;
    private List<Point> position;
    private boolean isSafe;
    private int horizontalVelocity;
    private int verticalVelocity;

    public Snake(Board board, Point initPosition) {
        this.board = board;
        this.position = new ArrayList<>();
        this.head = initPosition;
        this.position.add(initPosition);
        this.horizontalVelocity = 1;
        this.verticalVelocity = 0;
    }

    public void update() {
        Point pointRight = new Point((head.getXCord() + horizontalVelocity + board.getSize()) % board.getSize(),
                                     (head.getYCord() + verticalVelocity + board.getSize()) % board.getSize());
        move(pointRight);
        updateSafety();
    }

    public void setHorizontalVelocity(int horizontalVelocity) {
        if (horizontalVelocity <= 1 && horizontalVelocity >= -1) {
            this.horizontalVelocity = horizontalVelocity;
        }
    }

    public void setVerticalVelocity(int verticalVelocity) {
        if (verticalVelocity <= 1 && verticalVelocity >= -1) {
            this.verticalVelocity = verticalVelocity;
        }
    }

    public Point getHead() {
        return head;
    }

    public List<Point> getPosition() {
        return position;
    }

    public boolean isSafe() {
        return isSafe;
    }

    private void move(Point point) {
        position.remove(0);
        position.add(point);
        head = point;
    }

    // TODO - test
    private void updateSafety() {
        for (Point point : position) {
            if (head.equals(point)) {
                isSafe = false;
                return;
            }
        }
        isSafe = true;
    }
}
