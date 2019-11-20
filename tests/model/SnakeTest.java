package model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {

    private Board board = new Board(500, 500);

    @Test
    public void moveRight() {
        // given
        Snake s = new Snake(board, new Point(5,5));

        // when
        s.setHorizontalVelocity(1);
        s.setVerticalVelocity(0);
        s.update();

        // then
        Assert.assertEquals(6, s.getHead().getXCord());
        Assert.assertEquals(5, s.getHead().getYCord());
    }

    @Test
    public void moveRightWrapBoard() {
        // given
        Snake s = new Snake(board, new Point(9,5));

        // when
        s.setHorizontalVelocity(1);
        s.setVerticalVelocity(0);
        s.update();

        // then
        Assert.assertEquals(0, s.getHead().getXCord());
        Assert.assertEquals(5, s.getHead().getYCord());
    }

    @Test
    public void moveLeft() {
        // given
        Snake s = new Snake(board, new Point(5,5));

        // when
        s.setHorizontalVelocity(-1);
        s.setVerticalVelocity(0);
        s.update();

        // then
        Assert.assertEquals(4, s.getHead().getXCord());
        Assert.assertEquals(5, s.getHead().getYCord());
    }

    @Test
    public void moveLeftWrapBoard() {
        // given
        Snake s = new Snake(board, new Point(0,5));

        // when
        s.setHorizontalVelocity(-1);
        s.setVerticalVelocity(0);
        s.update();

        // then
        Assert.assertEquals(9, s.getHead().getXCord());
        Assert.assertEquals(5, s.getHead().getYCord());
    }

    @Test
    public void moveUp() {
        // given
        Snake s = new Snake(board, new Point(5,5));

        // when
        s.setHorizontalVelocity(0);
        s.setVerticalVelocity(-1);
        s.update();

        // then
        Assert.assertEquals(5, s.getHead().getXCord());
        Assert.assertEquals(4, s.getHead().getYCord());
    }

    @Test
    public void moveUpWrapBoard() {
        // given
        Snake s = new Snake(board, new Point(5,0));

        // when
        s.setHorizontalVelocity(0);
        s.setVerticalVelocity(-1);
        s.update();

        // then
        Assert.assertEquals(5, s.getHead().getXCord());
        Assert.assertEquals(9, s.getHead().getYCord());
    }

    @Test
    public void moveDown() {
        // given
        Snake s = new Snake(board, new Point(5,5));

        // when
        s.setHorizontalVelocity(0);
        s.setVerticalVelocity(1);
        s.update();

        // then
        Assert.assertEquals(5, s.getHead().getXCord());
        Assert.assertEquals(6, s.getHead().getYCord());
    }

    @Test
    public void moveDownWrapBoard() {
        // given
        Snake s = new Snake(board, new Point(5,9));

        // when
        s.setHorizontalVelocity(0);
        s.setVerticalVelocity(1);
        s.update();

        // then
        Assert.assertEquals(5, s.getHead().getXCord());
        Assert.assertEquals(0, s.getHead().getYCord());
    }
}