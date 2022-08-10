package org.abondar.experimental.tree;

import org.abondar.experimental.structs.tree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinaryTreeTest {

    @Test
    public void setNodeChildrenTest(){
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root,2,3);

        assertEquals(2,root.getLeft().getVal());
        assertEquals(3,root.getRight().getVal());

        BinaryTree.BinaryTreeNode left = root.getLeft();
        tree.setNodeChildren(left,7,4);

        assertEquals(4,left.getLeft().getVal());
        assertEquals(7,left.getRight().getVal());

    }

    @Test
    public void inOrderTraversalTest(){
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root,2,3);

        tree.inOderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(2,traversed.get(0));
        assertEquals(1,traversed.get(1));
        assertEquals(3,traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void preOrderTraversalTest(){
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root,2,3);

        tree.preOderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(1,traversed.get(0));
        assertEquals(2,traversed.get(1));
        assertEquals(3,traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void postOrderTraversalTest(){
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root,2,3);

        tree.postOrderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(2,traversed.get(0));
        assertEquals(3,traversed.get(1));
        assertEquals(1,traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void searchTest(){
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root,2,3);

        BinaryTree.BinaryTreeNode res = tree.search(root,3);

        assertEquals(tree.getRoot().getRight(),res);
        assertEquals(3,res.getVal());
    }
//
//
//    @Test
//    public void minTreeTest() {
//        int[] arr = {1, 3, 9, 11, 15, 19, 29};
//
//        BinTreeNode root = tg.minTree(arr);
//        assertEquals((Object) 11, Integer.valueOf(root.getName()));
//        assertEquals((Object) 3, Integer.valueOf(root.getLeft().getName()));
//        assertEquals((Object) 19, Integer.valueOf(root.getRight().getName()));
//        assertEquals((Object) 1, Integer.valueOf(root.getLeft().getLeft().getName()));
//        assertEquals((Object) 9, Integer.valueOf(root.getLeft().getRight().getName()));
//        assertEquals((Object) 15, Integer.valueOf(root.getRight().getLeft().getName()));
//        assertEquals((Object) 29, Integer.valueOf(root.getRight().getRight().getName()));
//    }
//
//
//    @Test
//    public void listOfDepthTest() {
//        BinTreeNode root = new BinTreeNode("11");
//
//        BinTreeNode l1L = new BinTreeNode("3");
//        BinTreeNode l1R = new BinTreeNode("19");
//        root.setLeft(l1L);
//        root.setRight(l1R);
//
//        BinTreeNode l2l1 = new BinTreeNode("1");
//        BinTreeNode l2r1 = new BinTreeNode("9");
//        l1L.setLeft(l2l1);
//        l1L.setRight(l2r1);
//
//        BinTreeNode l2l2 = new BinTreeNode("15");
//        BinTreeNode l2r2 = new BinTreeNode("29");
//        l1R.setLeft(l2l2);
//        l1R.setRight(l2r2);
//
//
//        List<List<BinTreeNode>> res = tg.listOfDepth(root);
//        assertEquals(3, res.size());
//        assertEquals(4, res.get(2).size());
//
//    }
//
//    @Test
//    public void isBalancedTest() {
//
//        BinTreeNode root = new BinTreeNode("11");
//
//        BinTreeNode l1L = new BinTreeNode("3");
//        BinTreeNode l1R = new BinTreeNode("19");
//        root.setLeft(l1L);
//        root.setRight(l1R);
//
//        BinTreeNode l2l1 = new BinTreeNode("1");
//        BinTreeNode l2r1 = new BinTreeNode("9");
//        l1L.setLeft(l2l1);
//        l1L.setRight(l2r1);
//
//        BinTreeNode l2l2 = new BinTreeNode("15");
//        BinTreeNode l2r2 = new BinTreeNode("29");
//        l1R.setLeft(l2l2);
//        l1R.setRight(l2r2);
//
//        assertTrue(tg.isBalanced(root));
//
//    }
//
//
//    @Test
//    public void isBSTTest() {
//        BinTreeNode root = new BinTreeNode("11");
//
//        BinTreeNode l1L = new BinTreeNode("3");
//        BinTreeNode l1R = new BinTreeNode("19");
//        root.setLeft(l1L);
//        root.setRight(l1R);
//        l1L.setParent(root);
//        l1R.setParent(root);
//
//        BinTreeNode l2l1 = new BinTreeNode("1");
//        BinTreeNode l2r1 = new BinTreeNode("9");
//        l1L.setLeft(l2l1);
//        l1L.setRight(l2r1);
//        l2l1.setParent(l1L);
//        l2r1.setParent(l1L);
//
//        BinTreeNode l2l2 = new BinTreeNode("15");
//        BinTreeNode l2r2 = new BinTreeNode("29");
//        l1R.setLeft(l2l2);
//        l1R.setRight(l2r2);
//        l2l2.setParent(l1R);
//        l2r2.setParent(l1R);
//
//
//        assertTrue(tg.isBST(root));
//    }
//
//
//
//
//    @Test
//    public void bstSeqTest(){
//        BinTreeNode root = new BinTreeNode("2");
//        root.setLeft(new BinTreeNode("1"));
//        root.setRight(new BinTreeNode("3"));
//
//        List<List<BinTreeNode>> res = tg.bstSequences(root);
//        assertEquals(2,res.size());
//        assertEquals(root,res.get(0).get(0));
//    }
//
//    @Test
//    public void treeHeightTest(){
//        BinTreeNode leaf1 = new BinTreeNode("l1");
//        leaf1.setRight(null);
//        leaf1.setLeft(null);
//
//        BinTreeNode leaf2 = new BinTreeNode("l2");
//        leaf2.setRight(null);
//        leaf2.setLeft(null);
//
//
//        BinTreeNode node = new BinTreeNode("n1");
//        node.setRight(null);
//        node.setLeft(leaf1);
//
//        BinTreeNode root = new BinTreeNode("root");
//        root.setLeft(node);
//        root.setRight(leaf2);
//
//        assertEquals(2,root.height());
//    }
}
