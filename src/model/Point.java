package model;

public class Point {

    private int xCord;
    private int yCord;
    // These 2 are used as apart of the AI path finding
    private boolean discovered;
    private Point parent;

    public Point(int xCord, int yCord, boolean discovered) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.discovered = discovered;
    }

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

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object point) {
        return this.xCord == ((Point)point).xCord && this.yCord == ((Point)point).yCord;
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
