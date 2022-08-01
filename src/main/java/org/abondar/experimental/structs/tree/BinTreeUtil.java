package org.abondar.experimental.structs.tree;

public class BinTreeUtil {

     //todo add tests to all methods after refactoring
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

    public BinTreeNode search(BinTreeNode root, int val){
        if (root==null || root.getVal()==val){
            return root;
        }

        if (val<root.getVal()){
            return search(root.getLeft(),val);
        } else {
            return search(root.getRight(),val);
        }

    }

    public void insert(BinTreeNode root,int val){
        BinTreeNode newNode = new BinTreeNode(String.valueOf(val));
        newNode.setVal(val);

        BinTreeNode tmp = null;
        while (root!=null){
            tmp = root;
            if (newNode.getVal()<root.getVal()){
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
        newNode.setParent(tmp);
        if (tmp==null){
            root = newNode;
        }
        else if (newNode.getVal()<tmp.getVal()){
            tmp.setLeft(newNode);
        } else {
            tmp.setRight(newNode);
        }

    }

    public void delete(BinTreeNode root,BinTreeNode toDelete){
        if (toDelete.getLeft()==null){
            transplant(root,toDelete,toDelete.getRight());
        } else if (toDelete.getRight()==null){
            transplant(root,toDelete,toDelete.getLeft());
        } else {
             BinTreeNode minNode = min(toDelete.getRight());
             if (!minNode.getParent().equals(toDelete)){
                 transplant(root,minNode,minNode.getRight());
             }

            transplant(root,toDelete,minNode);
             minNode.setLeft(toDelete.getLeft());
             minNode.getLeft().setParent(minNode);
        }
    }

    public void transplant(BinTreeNode root,BinTreeNode src,BinTreeNode dst){
        if (src.getParent()==null){
            root = dst;
        } else if (src.equals(src.getParent().getLeft())){
            src.getParent().setLeft(dst);
        } else {
            src.getParent().setRight(dst);
        }
        if (dst!=null){
            dst.setParent(src.getParent());
        }
    }

    public BinTreeNode successor(BinTreeNode node){
        if (node.getRight()!=null){
            return min(node.getRight());
        }

        BinTreeNode succ = node.getParent();
        while (succ!=null && node.equals(succ.getRight())){
            node = succ;
            succ = succ.getParent();
        }

        return succ;
    }

    private BinTreeNode min(BinTreeNode node){
        while (node.getLeft()!=null){
            node = node.getLeft();
        }

        return node;
    }

    private BinTreeNode max(BinTreeNode node){
        while (node.getRight()!=null){
            node = node.getRight();
        }

        return node;
    }

}
