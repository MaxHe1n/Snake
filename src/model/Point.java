package model;

// TODO - comments, javadocs, loging
public class Point {

    private int xCord;
    private int yCord;

    public Point(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getXCord() {
        return xCord;
    }

    public int getYCord() {
        return yCord;
    }

    public boolean equals(Point point) {
        if (this.xCord == point.xCord && this.yCord == point.yCord) {
            return  true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Point: %d,%d", xCord, yCord);
    }
}
