package model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
}