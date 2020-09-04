package org.abondar.experimental.tasks.treesgraphs;

public class BinTreeUtil {


    /**
     * Visit left,current,right
     */
    public static void inOderTraversal(BinTreeNode node) {
        if (node != null) {
            inOderTraversal(node.getLeft());
            visit(node);
            inOderTraversal(node.getRight());
        }
    }

    private static void visit(BinTreeNode n) {
        System.out.println(n);
    }

    /**
     * Visit left,current,right
     */
    public void preOderTraversal(BinTreeNode node) {
        if (node != null) {
            visit(node);
            preOderTraversal(node.getLeft());
            preOderTraversal(node.getRight());
        }
    }

    /**
     * Visit left,right,current
     */
    public void postOrderTraversal(BinTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            visit(node);
        }
    }

}
