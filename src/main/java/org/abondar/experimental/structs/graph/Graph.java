package org.abondar.experimental.structs.graph;

import org.abondar.experimental.structs.queue.CustomQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TODO split with bin tree
public class Graph {

    private GraphNode root;

    public Graph(){}

    public Graph(GraphNode root){
        this.root = root;
    }

    public void setNodeChildren(GraphNode node, List<GraphNode> children){
        node.children = children;
    }

    public List<GraphNode> bfs(GraphNode root) {
        List<GraphNode> found = new ArrayList<>();
        CustomQueue<GraphNode> queue = new CustomQueue<>();

        root.visited=true;
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();

            if (n.children!=null){
                n.children.forEach(gn -> {
                    if (!gn.visited) {
                        gn.visited=true;
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


//    public boolean hasRouteDFS(List<GraphNode> graph, GraphNode start, GraphNode end) {
//
//        return graph.contains(start) && graph.contains(end) && algs.dfsStack(start).contains(end);
//
//    }


//    public List<String> buildOrder(Map<String, List<String>> dependencies) {
//
//        List<GraphNode> roots = new ArrayList<>();
//
//        List<String> depVals = new ArrayList<>();
//        dependencies.forEach((k, v) -> depVals.addAll(v));
//
//        dependencies.forEach((k, v) -> {
//            if (!depVals.contains(k)) {
//                roots.add(new GraphNode(k));
//            }
//        });
//
//        if (!roots.isEmpty()) {
//            buildTrees(roots, dependencies);
//        }
//
//
//        return createOrder(roots);
//    }

//    private void buildTrees(List<GraphNode> roots, Map<String, List<String>> dependencies) {
//        roots.forEach(r -> {
//            List<GraphNode> children = new ArrayList<>();
//            dependencies.forEach((k, v) -> {
//                if (k.equals(r.getName())) {
//                    v.forEach(c -> {
//                        GraphNode child = new GraphNode(c);
//                        if (!roots.contains(child)) {
//                            children.add(child);
//                        }
//                    });
//                }
//                r.setChildren(children);
//            });
//
//            buildTrees(children, dependencies);
//        });
//
//
//    }


//    private List<String> createOrder(List<GraphNode> roots) {
//        List<String> res = new ArrayList<>();
//
//        roots.forEach(r -> {
//            res.add(r.getName());
//            algs.dfsStack(r).forEach(n -> res.add(n.getName()));
//        });
//
//
//        return res.stream()
//                .distinct()
//                .collect(Collectors.toList());
//    }


//    public GraphNode findCommonAncestor(GraphNode node1, GraphNode node2) {
//
//        int delta = depth(node1) - depth(node2);
//
//        GraphNode shallowNode = delta > 0 ? node2 : node1;
//        GraphNode deepNode = delta > 0 ? node1 : node2;
//
//        deepNode = goUp(deepNode, Math.abs(delta));
//
//
//        while (shallowNode != deepNode && deepNode != null) {
//            shallowNode = shallowNode.getParent();
//            deepNode = deepNode.getParent();
//
//        }
//
//        return deepNode == null ? null : shallowNode;
//    }
//
//    private GraphNode goUp(GraphNode node, int delta) {
//        while (delta > 0 && node != null) {
//            node = node.getParent();
//            delta--;
//        }
//
//        return node;
//    }
//
//
//    private int depth(GraphNode n) {
//        int depth = 0;
//        while (n != null) {
//            n = n.getParent();
//            depth++;
//        }
//
//        return depth;
//    }
//
//
//    public int dijktstraShortestPath(GraphNode root, GraphNode dest) {
//
//        Queue<GraphNode> toVisit = new PriorityQueue<>();
//        toVisit.add(root);
//        int res = 0;
//
//        while (!toVisit.isEmpty()) {
//            GraphNode min = toVisit.remove();
//            if (min == dest) {
//                return getDistanceToSource(root, min);
//            }
//            if (min.isVisited()) {
//                continue;
//            }
//            min.setVisited(true);
//            for (Map.Entry<GraphNode, Integer> entry : min.getChildrenWithWeight().entrySet()) {
//                int adjDistance = getDistanceToSource(root, min) + entry.getValue();
//
//                if (getDistanceToSource(root, entry.getKey()) >= adjDistance && !entry.getKey().isVisited()) {
//                    res = adjDistance;
//                    toVisit.add(entry.getKey());
//                }
//            }
//
//        }
//
//        return res;
//    }
//
//
//    public int getDistanceToSource(GraphNode root, GraphNode dest) {
//
//        if (root.equals(dest)) {
//            return 0;
//        }
//
//        if (root.getChildrenWithWeight().containsKey(dest)) {
//            return root.getChildrenWithWeight().get(dest);
//        }
//
//        int distance = 0;
//        GraphNode parent = new GraphNode();
//        GraphNode child = dest;
//        while (parent != null) {
//            parent = child.getParent();
//            distance += parent.getChildrenWithWeight().getOrDefault(child, 0);
//            child = parent;
//            parent = parent.getParent();
//        }
//
//        return distance;
//    }
//
//
//
//    public void dfs(GraphNode root) {
//        if (root == null) return;
//
//        root.setVisited(true);
//        for (GraphNode n : root.getChildren()) {
//            if (!n.isVisited()) {
//                dfs(n);
//            }
//        }
//
//
//    }
//
//    public  List<GraphNode> dfsStack(GraphNode root) {
//        List<GraphNode> found = new ArrayList<>();
//        Stack<GraphNode> stack = new Stack<>();
//
//        root.setVisited(true);
//        stack.add(root);
//
//        while (!stack.isEmpty()) {
//            GraphNode n = stack.pop();
//
//            n.getChildren().forEach(gn -> {
//                if (!gn.isVisited()) {
//                    gn.setVisited(true);
//                    found.add(gn);
//                    stack.add(gn);
//                }
//            });
//
//        }
//
//        return found;
//    }
//
//



    public static class GraphNode implements Comparable<GraphNode> {
        private String name;
        private List<GraphNode> children;
        private boolean visited;
        private GraphNode parent;
        private Map<GraphNode, Integer> childrenWithWeight;

        public GraphNode() {

        }

        public GraphNode(String name, List<GraphNode> children) {
            this.name = name;
            this.children = children;
        }

        public GraphNode(String name, Map<GraphNode, Integer> childrenWithPath) {
            this.name = name;
            this.childrenWithWeight = childrenWithPath;
        }

        public GraphNode(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(GraphNode node) {

            if (this.childrenWithWeight.entrySet().contains(node)) {
                return this.childrenWithWeight.get(node);
            }

            return 0;
        }
    }
}

