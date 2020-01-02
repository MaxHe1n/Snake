package model;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Board board;
    private Point head;
    private List<Point> position;
    private boolean isSafe;
    private int horizontalVelocity;
    private int verticalVelocity;
    private int currentHorizontalVelocity;
    private int currentVerticalVelocity;

    public Snake(Board board, Point initPosition, int initLength) {
        this.board = board;
        this.head = initPosition;
        this.position = new ArrayList<>();
        this.position.add(initPosition);
        this.isSafe = true;
        this.horizontalVelocity = 1;
        this.verticalVelocity = 0;
        this.currentHorizontalVelocity = 1;
        this.currentVerticalVelocity = 0;

        for (int i = 1; i < initLength; ++i) {
            grow();
        }
    }

    void update() {
        Point point = board.wrapBoard(head.getXCord() + horizontalVelocity,
                head.getYCord() + verticalVelocity);
        move(point);
        currentHorizontalVelocity = horizontalVelocity;
        currentVerticalVelocity = verticalVelocity;
        updateSafety();
    }

    /**
     * Sets the snake velocity in the y direction to -1. Every iteration the snake will update based on this velocity
     * value.
     */
    public void moveUp() {
        if (!(currentHorizontalVelocity == 0 && currentVerticalVelocity == 1)) {
            setHorizontalVelocity(0);
            setVerticalVelocity(-1);
        }
    }

    /**
     * Sets the snake velocity in the x direction to 1. Every iteration the snake will update based on this velocity
     * value.
     */
    public void moveRight() {
        if (!(currentHorizontalVelocity == -1 && currentVerticalVelocity == 0)) {
            setHorizontalVelocity(1);
            setVerticalVelocity(0);
        }
    }

    /**
     * Sets the snake velocity in the y direction to 1. Every iteration the snake will update based on this velocity
     * value.
     */
    public void moveDown() {
        if (!(currentHorizontalVelocity == 0 && currentVerticalVelocity == -1)) {
            setHorizontalVelocity(0);
            setVerticalVelocity(1);
        }
    }

    /**
     * Sets the snake velocity in the x direction to -1. Every iteration the snake will update based on this velocity
     * value.
     */
    public void moveLeft() {
        if (!(currentHorizontalVelocity == 1 && currentVerticalVelocity == 0)) {
            setHorizontalVelocity(-1);
            setVerticalVelocity(0);
        }
    }

    void grow() {
        Point p = position.get(0);
        position.add(0, p);
    }

    public Point getHead() {
        return head;
    }

    /**
     *
     * @return An ordered list of Point objects that represent the position of the snake.
     * The last element in the list is the head.
     */
    public List<Point> getPosition() {
        return position;
    }

    /**
     * @return Decides if the snake is in a valid position on the board.
     */
    public boolean isSafe() {
        return isSafe;
    }

    boolean contains(Point point) {
        for (Point p : position) {
            if (point.equals(p)) {
                return true;
            }
        }
        return false;
    }

    private void setHorizontalVelocity(int horizontalVelocity) {
        if (horizontalVelocity <= 1 && horizontalVelocity >= -1) {
            this.horizontalVelocity = horizontalVelocity;
        }
    }

    private void setVerticalVelocity(int verticalVelocity) {
        if (verticalVelocity <= 1 && verticalVelocity >= -1) {
            this.verticalVelocity = verticalVelocity;
        }
    }

    private void move(Point point) {
        position.remove(0);
        position.add(point);
        head = point;
    }

    private void updateSafety() {
        for (int index = 0; index < position.size()-1; ++index) {
            if (head.equals(position.get(index))) {
                isSafe = false;
                return;
            }
        }
        isSafe = true;
    }
}
