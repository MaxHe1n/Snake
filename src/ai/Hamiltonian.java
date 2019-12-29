package ai;

import model.Point;

import java.util.ArrayList;
import java.util.List;

public class Hamiltonian {

    List<Point> search(Graph graph, Point root) {

        return new ArrayList<>();

    }

    boolean cycle(Graph graph, Point[] path, int index) {

        if (path.length == graph.map.size()) {
            if (path[path.length-1] == path[0]) {
                return true;
            } else {
                return false;
            }
        }

        for (Point p : (List<Point>) graph.map.get(path[index])) {

        }

        return true;

    }
}
