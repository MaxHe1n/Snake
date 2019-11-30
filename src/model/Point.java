package model;

public class Point {

    private int xCord;
    private int yCord;

    Point(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    int getXCord() {
        return xCord;
    }

    int getYCord() {
        return yCord;
    }

    boolean equals(Point point) {
        return this.xCord == point.xCord && this.yCord == point.yCord;
    }

    @Override
    public String toString() {
        return String.format("Point: %d,%d", xCord, yCord);
    }
}
