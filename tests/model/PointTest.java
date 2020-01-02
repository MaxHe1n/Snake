package model;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void equals() {
        // given
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.equals(point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void notEquals() {
        // given
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,0);

        // when
        boolean res = point1.equals(point2);

        // then
        Assert.assertFalse(res);
    }

    @Test
    public void isRightOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(1,0);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isRightOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isRightOfWrapBoardTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(9,0);

        // when
        boolean res = point1.isRightOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isNotRightOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(2,0);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isRightOf(board, point2);

        // then
        Assert.assertFalse(res);
    }

    @Test
    public void isLeftOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,0);

        // when
        boolean res = point1.isLeftOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isLeftOfWrapBoardTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(9,0);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isLeftOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isNotLeftOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(2,0);

        // when
        boolean res = point1.isLeftOf(board, point2);

        // then
        Assert.assertFalse(res);
    }

    @Test
    public void isAboveOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,1);

        // when
        boolean res = point1.isAboveOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isAboveOfWrapBoardTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,9);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isAboveOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isNotAboveOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);

        // when
        boolean res = point1.isAboveOf(board, point2);

        // then
        Assert.assertFalse(res);
    }

    @Test
    public void isBelowOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,1);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isBelowOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isBelowOfWrapBoardTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,9);

        // when
        boolean res = point1.isBelowOf(board, point2);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public void isNotBelowOfTest() {
        // given
        Board board = new Board(10, 10);
        Point point1 = new Point(0,2);
        Point point2 = new Point(0,0);

        // when
        boolean res = point1.isBelowOf(board, point2);

        // then
        Assert.assertFalse(res);
    }
}