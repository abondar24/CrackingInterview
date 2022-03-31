package org.abondar.experimental.structs.tree;

public class BinTreeNode {

    private String name;
    private BinTreeNode left;
    private BinTreeNode right;
    private BinTreeNode parent;

    //Refactor to store int value
    private int val;
    public BinTreeNode(String name) {
        this.name = name;
    }

    public int height() {
        return height(this);
    }

    private int height(BinTreeNode node) {
        if (node == null)
            return -1;
        else {
            /* compute the depth of each subtree */
            int lHeight = height(node.getLeft());
            int rHeight = height(node.getRight());

            /* use the larger one */
            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
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
