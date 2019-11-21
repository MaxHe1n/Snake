package model;

class Food {

    private Board board;
    private int value;
    private Point position;

    Food(Board board, int value) {
        this.board = board;
        this.value = value;
        this.position = getRandomPoint();
    }

    int getValue() {
        return value;
    }

    Point getPosition() {
        return position;
    }

    private Point getRandomPoint() {
        double randomX = Math.random()*board.getWidth();
        double randomy = Math.random()*board.getHeight();
        return new Point((int) randomX, (int) randomy);
    }
}
