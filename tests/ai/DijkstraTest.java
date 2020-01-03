package ai;

import model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DijkstraTest {

    @Test
    public void minimumDistanceTest() {
        // given
        Graph graph = generateGraph(5,5);
        Dijkstra dijkstra = new Dijkstra();

        // when
        List<Point> path = dijkstra.search(graph,
                new Point(0,0, -1, false),
                new Point(4,4, -1, false),
                new ArrayList<>());

        // then
        Assert.assertEquals(9, path.size());
    }

    @Test
    public void minimumDistanceToSelfTest() {
        // given
        Graph graph = generateGraph(5,5);
        Dijkstra dijkstra = new Dijkstra();

        // when
        List<Point> path = dijkstra.search(graph,
                new Point(0,0, -1, false),
                new Point(0,0, -1, false),
                new ArrayList<>());

        // then
        Assert.assertEquals(1, path.size());
    }

    @Test
    public void minimumDistanceWithSnakeTest() {
        // given
        Graph graph = generateGraph(5,5);
        Dijkstra dijkstra = new Dijkstra();
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(1,2, -1, false));
        snake.add(new Point(2,2, -1, false));
        snake.add(new Point(3,2, -1, false));

        // when
        List<Point> path = dijkstra.search(graph,
                new Point(3,2, -1, false),
                new Point(0,0, -1, false),
                snake);

        // then
        Assert.assertEquals(6, path.size());
    }

    @Test
    public void minimumDistanceWithCircularSnakeTest() { // Disconected graph test
        // given
        Graph graph = generateGraph(5,5);
        Dijkstra dijkstra = new Dijkstra();
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(1,1, -1, false));
        snake.add(new Point(1,2, -1, false));
        snake.add(new Point(1,3, -1, false));
        snake.add(new Point(2,3, -1, false));
        snake.add(new Point(3,3, -1, false));
        snake.add(new Point(4,3, -1, false));
        snake.add(new Point(4,2, -1, false));
        snake.add(new Point(4,1, -1, false));
        snake.add(new Point(3,1, -1, false));
        snake.add(new Point(2,1, -1, false));
        snake.add(new Point(2,0, -1, false));

        // when
        List<Point> path = dijkstra.search(graph,
                new Point(2,0, -1, false),
                new Point(4,4, -1, false),
                snake);

        // then
        Assert.assertEquals(11, path.size());
    }

    @Test
    public void noValidPathTest() {
        // given
        Graph graph = generateGraph(5,5);
        Dijkstra dijkstra = new Dijkstra();
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(1,0, -1, false));
        snake.add(new Point(1,1, -1, false));
        snake.add(new Point(1,2, -1, false));
        snake.add(new Point(1,3, -1, false));
        snake.add(new Point(2,3, -1, false));
        snake.add(new Point(3,3, -1, false));
        snake.add(new Point(4,3, -1, false));
        snake.add(new Point(4,2, -1, false));
        snake.add(new Point(4,1, -1, false));
        snake.add(new Point(3,1, -1, false));
        snake.add(new Point(2,1, -1, false));
        snake.add(new Point(2,0, -1, false));

        // when
        List<Point> path = dijkstra.search(graph,
                new Point(2,0, -1, false),
                new Point(4,4, -1, false),
                snake);

        // then
        Assert.assertNull(path);
    }

    private Graph generateGraph(int width, int height) {
        Point p[][] = new Point[width][height];
        Graph<Point> g = new Graph<>();
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                p[x][y] = new Point(x,y,-1, false);
            }
        }
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {

                // Dose not allow board wrapping, no edges between edge vertices
                if (y-1 >= 0) g.addEdge(p[x][y], p[x][y - 1], false);
                if (x+1 < width) g.addEdge(p[x][y], p[x + 1][y], false);
                if (y+1 < height) g.addEdge(p[x][y], p[x][y + 1], false);
                if (x-1 >= 0) g.addEdge(p[x][y], p[x - 1][y], false);

            }
        }
        return g;
    }
}
