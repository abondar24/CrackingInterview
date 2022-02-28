package org.abondar.experimental.algorithms;

import org.abondar.experimental.structs.queue.CustomQueue;
import org.abondar.experimental.structs.tree.GraphNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphAlgs {

    public int dijktstraShortestPath(GraphNode root, GraphNode dest) {

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



    public void dfs(GraphNode root) {
        if (root == null) return;

        root.setVisited(true);
        System.out.println(root);
        for (GraphNode n : root.getChildren()) {
            if (!n.isVisited()) {
                dfs(n);
            }
        }


    }

    public  List<GraphNode> dfsStack(GraphNode root) {
        List<GraphNode> found = new ArrayList<>();
        Stack<GraphNode> stack = new Stack<>();

        root.setVisited(true);
        stack.add(root);

        while (!stack.isEmpty()) {
            GraphNode n = stack.pop();

            n.getChildren().forEach(gn -> {
                if (!gn.isVisited()) {
                    gn.setVisited(true);
                    found.add(gn);
                    stack.add(gn);
                }
            });

        }

        return found;
    }


    public List<GraphNode> bfs(GraphNode root) {
        List<GraphNode> found = new ArrayList<>();
        CustomQueue<GraphNode> queue = new CustomQueue<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();

            n.getChildren().forEach(gn -> {
                if (!gn.isVisited()) {
                    gn.setVisited(true);
                    found.add(gn);
                    queue.add(gn);
                }
            });

        }

        return found;
    }

}
