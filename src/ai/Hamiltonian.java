package ai;

import model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Hamiltonian cycle calculation
    - NOTE: Currently in progress
 */

class Hamiltonian {

    List<Point> search(Graph graph, Point root) {

        Point[] path = new Point[graph.map.size()];

        path[0] = (Point) graph.getVertex(root);

        if (!cycle(graph, path, 1)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(path));

    }

    private boolean cycle(Graph graph, Point[] path, int index) {

        if (index == path.length) {
            return path[path.length - 1] == path[0];
        }

        for (Point p : (List<Point>) graph.map.get(path[index-1])) {

            if (isSafe(path, p, index)) {
                path[index] = p;

                if (cycle(graph, path, index + 1)) {
                    return true;
                }

                path[index] = null;
            }
        }

        return false;

    }

    private boolean isSafe(Point[] path, Point e, int index) {
        for(int i = 0; i < index; ++i) {
            if (path[i].equals(e)) return false;
        }
        return true;
    }
}
