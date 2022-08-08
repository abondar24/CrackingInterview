package org.abondar.experimental.structs.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

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


    public BinTreeNode minTree(int[] arr) {

        return minTree(arr, 0, arr.length - 1);
    }

    private BinTreeNode minTree(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        BinTreeNode root = new BinTreeNode(String.valueOf(arr[mid]));

        root.setLeft(minTree(arr, start, mid - 1));
        root.setRight(minTree(arr, mid + 1, end));
        return root;

    }


    public List<List<BinTreeNode>> listOfDepth(BinTreeNode root) {
        List<List<BinTreeNode>> res = new ArrayList<>();

        List<BinTreeNode> currentLevel = new ArrayList<>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (currentLevel.size() > 0) {
            res.add(currentLevel);
            List<BinTreeNode> parentLevel = currentLevel;
            currentLevel = new ArrayList<>();
            for (BinTreeNode p : parentLevel) {
                if (p.getLeft() != null) {
                    currentLevel.add(p.getLeft());
                }

                if (p.getRight() != null) {
                    currentLevel.add(p.getRight());
                }
            }

        }

        return res;
    }


    public boolean isBalanced(BinTreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }


    private int checkHeight(BinTreeNode root) {
        if (root == null) return -1;

        //height of left subtree
        int leftHeight = checkHeight(root.getLeft());

        // return error
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }


    public boolean isBST(BinTreeNode root) {
        return checkNode(root);
    }

    private boolean checkNode(BinTreeNode root) {

        if (root == null) return true;

        Integer curVal = Integer.valueOf(root.getName());

        if (root.getLeft() != null && root.getRight() != null) {
            Integer leftVal = Integer.valueOf(root.getLeft().getName());
            Integer rightVal = Integer.valueOf(root.getRight().getName());

            if (leftVal <= curVal && curVal < rightVal) {

                if (root.getParent() != null && root.equals(root.getParent().getLeft())) {
                    Integer parentVal = Integer.valueOf(root.getParent().getName());
                    if (rightVal > parentVal) {
                        return false;
                    }
                }

                return checkNode(root.getRight()) && checkNode(root.getLeft());
            }
        } else {
            return true;
        }

        return false;
    }

    public List<List<BinTreeNode>> bstSequences(BinTreeNode root) {
        List<List<BinTreeNode>> res = new ArrayList<>();

        if (root == null) {
            res.add(new ArrayList<>());
            return res;
        }

        List<List<BinTreeNode>> leftSeq = bstSequences(root.getLeft());
        List<List<BinTreeNode>> rightSeq = bstSequences(root.getRight());

        List<BinTreeNode> prefix = new ArrayList<>();
        prefix.add(root);

        //weave lists from left and right
        leftSeq.forEach(ls -> rightSeq.forEach(rs -> {
            List<List<BinTreeNode>> weaved = new ArrayList<>();
            weaveLists(ls, rs, weaved, prefix);
            res.addAll(weaved);
        }));

        return res;
    }

    //get all possible lists combos. remove head from ls,recurse, than do the same with rs
    private void weaveLists(List<BinTreeNode> ls, List<BinTreeNode> rs, List<List<BinTreeNode>> weaved, List<BinTreeNode> prefix) {
        if (ls.size() == 0 || rs.size() == 0) {
            List<BinTreeNode> res = new ArrayList<>();
            res.addAll(prefix);
            res.addAll(ls);
            res.addAll(rs);
            weaved.add(res);
            return;
        }

        BinTreeNode headLS = ls.remove(0);
        prefix.add(headLS);
        weaveLists(ls, rs, weaved, prefix);
        prefix.remove(prefix.size() - 1);
        ls.add(0, headLS);

        BinTreeNode headRS = ls.remove(0);
        prefix.add(headRS);
        weaveLists(ls, rs, weaved, prefix);
        prefix.remove(prefix.size() - 1);
        rs.add(0, headRS);


    }


}
