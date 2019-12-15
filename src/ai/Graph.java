package ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph<T> {

    Map<T, List<T>> map;

    Graph() {
        this.map = new HashMap<>();
    }

    void addEdge(T source, T destination, Boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    T getVertex(T vertex) {
        for(T v : map.keySet()) {
            if(v.equals(vertex)) return v;
        }
        return null;
    }

    private void addVertex(T vertex) {
        map.put(vertex, new ArrayList<T>());
    }
}
