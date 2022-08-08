package org.abondar.experimental.structs.graph;


import java.util.List;
import java.util.Map;

public class  GraphNode implements Comparable<GraphNode> {
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    public void setChildren(List<GraphNode> children) {
        this.children = children;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public Map<GraphNode, Integer> getChildrenWithWeight() {
        return childrenWithWeight;
    }

    public void setChildrenWithWeight(Map<GraphNode, Integer> childrenWithWeight) {
        this.childrenWithWeight = childrenWithWeight;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(GraphNode node) {

        if (this.childrenWithWeight.entrySet().contains(node)) {
            return this.childrenWithWeight.get(node);
        }

        return 0;
    }
}
