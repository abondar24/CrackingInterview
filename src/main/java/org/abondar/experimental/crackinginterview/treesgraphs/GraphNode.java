package org.abondar.experimental.crackinginterview.treesgraphs;


import java.util.List;
import java.util.Map;

public class GraphNode implements Comparable {

    private String name;
    private List<GraphNode> children;
    private boolean visited;
    private GraphNode parent;
    private Map<GraphNode,Integer> childrenWithPath;

    public GraphNode(){

    }

    public GraphNode(String name, List<GraphNode> children) {
        this.name = name;
        this.children = children;
    }

    public GraphNode(String name, Map<GraphNode, Integer> childrenWithPath) {
        this.name = name;
        this.childrenWithPath = childrenWithPath;
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

    public Map<GraphNode, Integer> getChildrenWithPath() {
        return childrenWithPath;
    }

    public void setChildrenWithPath(Map<GraphNode, Integer> childrenWithPath) {
        this.childrenWithPath = childrenWithPath;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
