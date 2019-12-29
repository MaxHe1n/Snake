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

    List<Point> search(Graph graph, Point root, Point goal) {
        Point r = (Point) graph.getVertex(root);
        return DFSIterative(graph, r, goal);
    }

    List<Point> DFSIterative(Graph g, Point root, Point goal) {
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.size() != 0) {
            Point v = stack.pop();
            if (!v.isDiscovered()) {
                v.setDiscovered(true);
                if (v.equals(goal)) return backTrace(v);
                for (Point w : (List<Point>) g.map.get(v)) {
                    if (w.getParent() == null && !w.equals(root)) w.setParent(v);
                    stack.push(w);
                }
            }
        }
        return null;
    }

    List<Point> DFSRecursive(Graph g, Point parent, Point goal) {

        if (parent.equals(goal)) return backTrace(goal);

        for (Point p : (List<Point>) g.map.get(parent)) {
            if (!p.isDiscovered()) {
                p.setDiscovered(true);
                p.setParent(parent);
                DFSRecursive(g, p, goal);
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
