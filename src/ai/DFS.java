package ai;

import model.Point;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    Depth first search
 */

class DFS {

    List<Point> search(Graph graph, Point root, Point goal, List<Point> exclusion) {

        // Basic snake avoidance
        for (Point e : exclusion) {
            ((Point) graph.getVertex(e)).setDiscovered(true);
        }

        // Basic BFS - Backtracking variant
        Point r = (Point) graph.getVertex(root);

        Deque<Point> stack = new ArrayDeque<>();
        stack.push(r);

        while (stack.size() != 0) {
            Point v = stack.pop();
            if (!v.isDiscovered()) {
                v.setDiscovered(true);
                if (v.equals(goal)) return backTrace(v);
                for (Point w : (List<Point>) graph.map.get(v)) {
                    if (w.getParent() == null && !w.equals(r)) w.setParent(v);
                    stack.push(w);
                }
            }
        }
        return null;
    }

    private List<Point> backTrace(Point end) {
        List<Point> trace = new ArrayList<>();
        trace.add(end);
        Point point = end;
        while (point.getParent() != null) {
            trace.add(point.getParent());
            point = point.getParent();
        }
        return trace;
    }
}
