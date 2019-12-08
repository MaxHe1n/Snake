package model;

public class Point {

    private int xCord;
    private int yCord;

    Point(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getXCord() {
        return xCord;
    }

    public int getYCord() {
        return yCord;
    }

    boolean equals(Point point) {
        return this.xCord == point.xCord && this.yCord == point.yCord;
    }

    boolean isLeftOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point point = new Point((oriant.getXCord() - 1 + board.getWidth()) % board.getWidth(),
                (oriant.getYCord() + board.getHeight()) % board.getHeight());

        return point.equals(this);
    }

    boolean isrRightOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point point = new Point((oriant.getXCord() + 1 + board.getWidth()) % board.getWidth(),
                (oriant.getYCord() + board.getHeight()) % board.getHeight());

        return point.equals(this);
    }

    boolean isAboveOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point pointLeft = new Point((oriant.getXCord() + board.getWidth()) % board.getWidth(),
                (oriant.getYCord() - 1 + board.getHeight()) % board.getHeight());

        return pointLeft.equals(this);
    }

    boolean isBelowOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point pointRight = new Point((oriant.getXCord() + board.getWidth()) % board.getWidth(),
                (oriant.getYCord() + 1 + board.getHeight()) % board.getHeight());

        return pointRight.equals(this);
    }

    @Override
    public String toString() {
        return String.format("Point: %d,%d", xCord, yCord);
    }
}
