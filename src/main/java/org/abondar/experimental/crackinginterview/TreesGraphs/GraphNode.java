package org.abondar.experimental.crackinginterview.TreesGraphs;


import java.util.List;

public class GraphNode {

    private String name;
    private List<GraphNode> children;
    private boolean visited;
    private GraphNode parent;

    public GraphNode(String name, List<GraphNode> children) {
        this.name = name;
        this.children = children;
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

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
