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

    List<Point> search(Graph graph, Point root, Point goal) {

        Deque<Point> q = new ArrayDeque<>();
        Point r = (Point) graph.getVertex(root);
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

    List<Point> backTrace(Point end) {
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
