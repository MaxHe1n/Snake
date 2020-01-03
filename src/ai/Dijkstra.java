package ai;

import model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Dijkstra {

    List<Point> search(Graph graph, Point root, Point goal, List<Point> exclusion) {

        // Basic snake avoidance
        for (Point e : exclusion) {
            ((Point) graph.getVertex(e)).setDiscovered(true);
        }

        Point r = (Point) graph.getVertex(root);
        r.setDiscovered(false);
        r.setWeight(0);

        int graphSize = graph.map.keySet().size() - exclusion.size() + 1; // +1 ??
        for(int i = 0; i < graphSize ; ++i) {
            Point minimumVertex = getMinimumVertex(graph);
            if (graph.map.get(minimumVertex) == null) {
                break;
            }
            for(Point p : (List<Point>) graph.map.get(minimumVertex)) {
                // All edges are of weight 1
                int pathWeight = minimumVertex.getWeight() + 1;
                if (!p.isDiscovered() && (pathWeight < minimumVertex.getWeight() || p.getWeight() == -1)) {
                    p.setWeight(pathWeight);
                    p.setParent(minimumVertex);
                }
            }
            minimumVertex.setDiscovered(true);
        }

        return backTrace((Point) graph.getVertex(goal));
    }

    private Point getMinimumVertex(Graph g) {
        // This assumes the start vertex weight will always be zero
        Point minPoint = new Point(-1,-1,-1,false);
        for (Point p : (Set<Point>) g.map.keySet()) {
            if ((p.getWeight() < minPoint.getWeight() || minPoint.getWeight() == -1) && p.getWeight() > -1 && !p.isDiscovered()) {
                minPoint = p;
            }
        }
        return minPoint;
    }

    private List<Point> backTrace(Point end) {
        List<Point> trace = new ArrayList<>();
        trace.add(end);
        Point point = end;
        while (point.getParent() != null) {
            trace.add(point.getParent());
            point = point.getParent();
        }

        if (trace.size() == 1) {
            return null;
        } else {
            return trace;
        }
    }
}
