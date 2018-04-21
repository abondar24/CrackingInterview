package org.abondar.experimental.crackinginterview.treesgraphs;

public class BinTreeNode {

    private String name;
    private BinTreeNode left;
    private BinTreeNode right;
    private BinTreeNode parent;

    public BinTreeNode(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }

    public BinTreeNode getParent() {
        return parent;
    }

    public void setParent(BinTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BinTreeNode{" +
                "name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
