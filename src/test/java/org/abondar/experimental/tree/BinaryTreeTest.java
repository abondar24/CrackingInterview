package org.abondar.experimental.tree;

import org.abondar.experimental.structs.tree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinaryTreeTest {

    @Test
    public void setNodeChildrenTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        assertEquals(0, root.getLeft().getVal());
        assertEquals(3, root.getRight().getVal());

        BinaryTree.BinaryTreeNode left = root.getLeft();
        tree.setNodeChildren(left, 7, 4);

        assertEquals(4, left.getLeft().getVal());
        assertEquals(7, left.getRight().getVal());

    }

    @Test
    public void inOrderTraversalTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        tree.inOderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(0, traversed.get(0));
        assertEquals(1, traversed.get(1));
        assertEquals(3, traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void preOrderTraversalTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        tree.preOderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(1, traversed.get(0));
        assertEquals(0, traversed.get(1));
        assertEquals(3, traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void postOrderTraversalTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        tree.postOrderTraversal(root);
        List<Integer> traversed = tree.getTraversedNodes();

        assertEquals(0, traversed.get(0));
        assertEquals(3, traversed.get(1));
        assertEquals(1, traversed.get(2));

        tree.clearTraversedNodes();
    }

    @Test
    public void searchTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        BinaryTree.BinaryTreeNode res = tree.search(root, 3);

        assertEquals(tree.getRoot().getRight(), res);
        assertEquals(3, res.getVal());
    }


    @Test
    public void getMostLeftTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        BinaryTree.BinaryTreeNode left = root.getLeft();
        tree.setNodeChildren(left, 7, 4);

        int res = tree.getMostLeftValue(root);
        assertEquals(4, res);
    }


    @Test
    public void getMostRightTest() {
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.BinaryTreeNode root = tree.getRoot();
        tree.setNodeChildren(root, 0, 3);

        BinaryTree.BinaryTreeNode left = root.getLeft();
        tree.setNodeChildren(left, 7, 4);

        int res = tree.getMostRightValue(root);
        assertEquals(3, res);
    }


    @Test
    public void minTreeTest() {
        int[] arr = {1, 3, 9, 11, 15, 19, 29};

        BinaryTree tree = new BinaryTree();
        tree.minTree(arr);
        BinaryTree.BinaryTreeNode root = tree.getRoot();

        assertEquals(11, root.getVal());
        assertEquals(3,root.getLeft().getVal());
        assertEquals(19,root.getRight().getVal());
        assertEquals(1,root.getLeft().getLeft().getVal());
        assertEquals(9,root.getLeft().getRight().getVal());
        assertEquals(15, root.getRight().getLeft().getVal());
        assertEquals(29,root.getRight().getRight().getVal());
    }


    @Test
    public void listOfDepthTest() {
        BinaryTree tree = new BinaryTree(11);
        tree.setNodeChildren(tree.getRoot(),3,19);
        tree.setNodeChildren(tree.getRoot().getLeft(),1,9);
        tree.setNodeChildren(tree.getRoot().getRight(),15,29);

        List<List<BinaryTree.BinaryTreeNode>> res = tree.listOfDepth();
        assertEquals(3, res.size());
        assertEquals(4, res.get(2).size());

    }

    @Test
    public void isBalancedTest() {
        BinaryTree tree = new BinaryTree(11);
        tree.setNodeChildren(tree.getRoot(),3,19);
        tree.setNodeChildren(tree.getRoot().getLeft(),1,9);
        tree.setNodeChildren(tree.getRoot().getRight(),15,29);

        assertTrue(tree.isBalanced());

    }


    @Test
    public void isBSTTest() {
        BinaryTree tree = new BinaryTree(11);
        tree.setNodeChildren(tree.getRoot(),3,19);
        tree.setNodeChildren(tree.getRoot().getLeft(),1,9);
        tree.setNodeChildren(tree.getRoot().getRight(),15,29);

        assertTrue(tree.isBST());
    }


    @Test
    public void bstSequenceTest(){
        BinaryTree tree = new BinaryTree(2);
        tree.setNodeChildren(tree.getRoot(),1,3);

        List<List<BinaryTree.BinaryTreeNode>> res = tree.bstSequences(tree.getRoot());
        assertEquals(2,res.size());
        assertEquals(tree.getRoot(),res.get(0).get(0));
    }

}
