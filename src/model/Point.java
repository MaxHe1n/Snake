package model;

public class Point {

    private int xCord;
    private int yCord;
    // These 3 fields are used as apart of the path finding (AI)
    private boolean discovered;
    private Point parent;
    private int weight;

    public Point(int xCord, int yCord, int weight, boolean discovered) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.discovered = discovered;
        this.weight = weight;
    }

    Point(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.discovered = false;
        this.weight = -1;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object point) {
        return this.xCord == ((Point)point).xCord && this.yCord == ((Point)point).yCord;
    }

    public boolean isLeftOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point point = board.wrapBoard(oriant.getXCord() - 1, oriant.getYCord());
        return point.equals(this);
    }

    public boolean isRightOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point point = board.wrapBoard(oriant.getXCord() + 1, oriant.getYCord());
        return point.equals(this);
    }

    public boolean isAboveOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point pointLeft = board.wrapBoard(oriant.getXCord(), oriant.getYCord() - 1);
        return pointLeft.equals(this);
    }

    public boolean isBelowOf(Board board, Point oriant) {
        if (oriant == null) return false;
        Point pointRight = board.wrapBoard(oriant.getXCord(), oriant.getYCord() + 1);
        return pointRight.equals(this);
    }

    @Override
    public String toString() {
        return String.format("Point: %d,%d,%d,%s", xCord, yCord, weight, discovered);
    }
}
