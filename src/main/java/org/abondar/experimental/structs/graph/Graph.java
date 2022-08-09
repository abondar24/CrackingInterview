package org.abondar.experimental.structs.graph;

import org.abondar.experimental.structs.queue.CustomQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

//TODO split with bin tree
public class Graph {

    private GraphNode root;

    public Graph() {
    }

    public Graph(GraphNode root) {
        this.root = root;
    }

    public void setNodeChildren(GraphNode parentNode, List<GraphNode> children) {
        parentNode.children = children;

        children.forEach(ch -> {
            ch.parent = parentNode;
        });
    }

    public void setNodeChildrenWithWeight(GraphNode parentNode, Map<GraphNode,Integer> children) {
        List<GraphNode> nodeChildren = new ArrayList<>();


        children.forEach((ch,weight) -> {
            ch.parent = parentNode;
            ch.weight = weight;
            nodeChildren.add(ch);
        });

        parentNode.children = nodeChildren;
    }

    public List<GraphNode> bfs(GraphNode root) {
        List<GraphNode> found = new ArrayList<>();
        CustomQueue<GraphNode> queue = new CustomQueue<>();

        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();

            if (n.children != null) {
                n.children.forEach(gn -> {
                    if (!gn.visited) {
                        gn.visited = true;
                        found.add(gn);
                        queue.add(gn);
                    }
                });
            }


        }

        return found;
    }

    public boolean hasRouteBFS(GraphNode start, GraphNode end) {
        return bfs(start).contains(end);
    }


    public List<GraphNode> dfs(GraphNode root) {
        List<GraphNode> found = new ArrayList<>();
        Stack<GraphNode> stack = new Stack<>();

        root.visited = true;
        stack.add(root);

        while (!stack.isEmpty()) {
            GraphNode n = stack.pop();

            if (n.children != null) {
                n.children.forEach(gn -> {
                    if (!gn.visited) {
                        gn.visited = true;
                        found.add(gn);
                        stack.add(gn);
                    }
                });
            }


        }

        return found;
    }

    public boolean hasRouteDFS(GraphNode start, GraphNode end) {
        return dfs(start).contains(end);
    }


    public List<String> buildOrder(Map<String, List<String>> dependencies) {

        List<GraphNode> roots = new ArrayList<>();

        List<String> depVals = new ArrayList<>();
        dependencies.forEach((k, v) -> depVals.addAll(v));

        dependencies.forEach((k, v) -> {
            if (!depVals.contains(k)) {
                roots.add(new GraphNode(k));
            }
        });

        if (!roots.isEmpty()) {
            buildTrees(roots, dependencies);
        }


        return createOrder(roots);
    }

    private void buildTrees(List<GraphNode> roots, Map<String, List<String>> dependencies) {
        roots.forEach(r -> {
            List<GraphNode> children = new ArrayList<>();
            dependencies.forEach((k, v) -> {
                if (k.equals(r.name)) {
                    v.forEach(c -> {
                        GraphNode child = new GraphNode(c);
                        if (!roots.contains(child)) {
                            children.add(child);
                        }
                    });
                }
                r.children = children;
            });

            buildTrees(children, dependencies);
        });


    }


    private List<String> createOrder(List<GraphNode> nodes) {
        List<String> res = new ArrayList<>();

        nodes.forEach(r -> {
            res.add(r.name);
            dfs(r).forEach(n -> res.add(n.name));
        });


        return res.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    public GraphNode findCommonAncestor(GraphNode node1, GraphNode node2) {

        int delta = depth(node1) - depth(node2);

        GraphNode shallowNode = delta > 0 ? node2 : node1;
        GraphNode deepNode = delta > 0 ? node1 : node2;

        deepNode = goUp(deepNode, Math.abs(delta));


        while (shallowNode != deepNode && deepNode != null) {
            shallowNode = shallowNode.parent;
            deepNode = deepNode.parent;

        }

        return deepNode == null ? null : shallowNode;
    }

    private GraphNode goUp(GraphNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }

        return node;
    }


    private int depth(GraphNode n) {
        int depth = 0;
        while (n != null) {
            n = n.parent;
            depth++;
        }

        return depth;
    }

    public int getDistanceToSource(GraphNode dest) {

        if (root.equals(dest)) {
            return 0;
        }


        if (root.children.contains(dest)) {
            return
                    root.children.stream()
                            .filter(ch -> ch.equals(dest))
                            .findFirst().get().weight;

        }

        int distance = 0;
        GraphNode parent = new GraphNode();
        GraphNode child = dest;
        while (parent != null) {
            parent = child.parent;

            for (GraphNode ch : parent.children) {
                distance += ch.weight;
            }


            child = parent;
            parent = parent.parent;
        }

        return distance;
    }


    public int dijktstraShortestPath(GraphNode dest) {

        Queue<GraphNode> toVisit = new PriorityQueue<>();
        toVisit.add(root);
        int res = 0;

        while (!toVisit.isEmpty()) {
            GraphNode min = toVisit.remove();
            if (min == dest) {
                return getDistanceToSource(min);
            }
            if (min.visited) {
                continue;
            }
            min.visited = true;

            for (GraphNode child : min.children) {
                int adjDistance = getDistanceToSource(min) + child.weight;

                if (getDistanceToSource(child) >= adjDistance && !child.visited) {
                    res = adjDistance;
                    toVisit.add(child);
                }
            }

        }

        return res;
    }


    public static class GraphNode implements Comparable<GraphNode> {
        private String name;
        private List<GraphNode> children;
        private boolean visited;
        private GraphNode parent;

        private Integer weight;

        public GraphNode() {

        }

        public GraphNode(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(GraphNode node) {

            if (this.children.contains(node)) {
                return node.weight;
            }

            return 0;
        }
    }
}

