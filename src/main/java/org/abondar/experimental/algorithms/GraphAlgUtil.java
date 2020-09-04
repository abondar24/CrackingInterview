package org.abondar.experimental.algorithms;

import org.abondar.experimental.tasks.treesgraphs.GraphNode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphAlgUtil {

    public int shortestPath(GraphNode root, GraphNode dest) {

        Queue<GraphNode> toVisit = new PriorityQueue<>();
        toVisit.add(root);
        int res = 0;

        while (!toVisit.isEmpty()) {
            GraphNode min = toVisit.remove();
            if (min == dest) {
                return getDistanceToSource(root, min);
            }
            if (min.isVisited()) {
                continue;
            }
            min.setVisited(true);
            for (Map.Entry<GraphNode, Integer> entry : min.getChildrenWithPath().entrySet()) {
                int adjDistance = getDistanceToSource(root, min) + entry.getValue();

                if (getDistanceToSource(root, entry.getKey()) >= adjDistance && !entry.getKey().isVisited()) {
                    res = adjDistance;
                    toVisit.add(entry.getKey());
                }
            }

        }

        return res;
    }


    public int getDistanceToSource(GraphNode root, GraphNode dest) {

        if (root.equals(dest)) {
            return 0;
        }

        if (root.getChildrenWithPath().containsKey(dest)) {
            return root.getChildrenWithPath().get(dest);
        }

        int distance = 0;
        GraphNode parent = new GraphNode();
        GraphNode child = dest;
        while (parent != null) {
            parent = child.getParent();
            distance += parent.getChildrenWithPath().getOrDefault(child, 0);
            child = parent;
            parent = parent.getParent();
        }

        return distance;
    }
}
