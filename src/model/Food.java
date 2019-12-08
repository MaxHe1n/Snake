package model;

public class Food {

    private int value;
    private Point position;

    Food(Point point, int value) {
        this.position = point;
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
    }

}
