package ai;

import model.Point;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    Breadth first search
 */

class BFS {

    List<Point> search(Graph graph, Point root, Point goal, List<Point> exclusion) {

        // Basic snake avoidance
        for (Point e : exclusion) {
            ((Point) graph.getVertex(e)).setDiscovered(true);
        }

        // Basic BFS - Backtracking variant
        Point r = (Point) graph.getVertex(root);

        Deque<Point> q = new ArrayDeque<>();
        r.setDiscovered(true);
        q.add(r);

        while(q.size() != 0) {
            Point v = q.removeFirst();
            if (v.equals(goal)) return backTrace(v);
            for(Point w : (List<Point>) graph.map.get(v)) {
                if(!w.isDiscovered()) {
                    w.setParent(v);
                    w.setDiscovered(true);
                    q.addLast(w);
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
