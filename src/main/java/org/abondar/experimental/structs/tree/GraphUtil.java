package org.abondar.experimental.structs.tree;

import org.abondar.experimental.structs.queue.CustomQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphUtil {


    public static void doDFS(GraphNode root) {
        if (root == null) return;

        root.setVisited(true);
        System.out.println(root);
        for (GraphNode n : root.getChildren()) {
            if (!n.isVisited()) {
                doDFS(n);
            }
        }


    }

    public static List<GraphNode> doDFSStack(GraphNode root) {
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


    public static List<GraphNode> doBFS(GraphNode root) {
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
