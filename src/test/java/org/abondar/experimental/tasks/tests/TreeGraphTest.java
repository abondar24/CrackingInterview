package org.abondar.experimental.tasks.tests;

import org.abondar.experimental.tasks.treesgraphs.BinTreeNode;
import org.abondar.experimental.tasks.treesgraphs.GraphNode;
import org.abondar.experimental.tasks.treesgraphs.TreesGraphs;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeGraphTest {

    private TreesGraphs tg = new TreesGraphs();


    @Test
    public void hasRouteBFSTest() {

        GraphNode zero = new GraphNode("0");
        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        List<GraphNode> graph = new ArrayList<>();

        zero.setChildren(List.of(one, four, five));
        graph.add(zero);

        one.setChildren(List.of(four, three));
        graph.add(one);

        two.setChildren(List.of(one, three));
        graph.add(two);

        three.setChildren(List.of(two, four));
        graph.add(three);

        four.setChildren(List.of());
        graph.add(four);

        five.setChildren(List.of());
        graph.add(five);

        assertTrue(tg.hasRouteBFS(graph, zero, three));
        assertFalse(tg.hasRouteBFS(graph, two, five));

    }


    @Test
    public void hasRouteDFSTest() {

        GraphNode zero = new GraphNode("0");
        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        List<GraphNode> graph = new ArrayList<>();

        zero.setChildren(List.of(one, four, five));
        graph.add(zero);

        one.setChildren(List.of(four, three));
        graph.add(one);

        two.setChildren(List.of(one, three));
        graph.add(two);

        three.setChildren(List.of(two, four));
        graph.add(three);

        four.setChildren(List.of());
        graph.add(four);

        five.setChildren(List.of());
        graph.add(five);

        assertTrue(tg.hasRouteDFS(graph, zero, three));
        assertFalse(tg.hasRouteDFS(graph, two, five));

    }

    @Test
    public void minTreeTest() {
        int[] arr = {1, 3, 9, 11, 15, 19, 29};

        BinTreeNode root = tg.minTree(arr);
        assertEquals((Object) 11, Integer.valueOf(root.getName()));
        assertEquals((Object) 3, Integer.valueOf(root.getLeft().getName()));
        assertEquals((Object) 19, Integer.valueOf(root.getRight().getName()));
        assertEquals((Object) 1, Integer.valueOf(root.getLeft().getLeft().getName()));
        assertEquals((Object) 9, Integer.valueOf(root.getLeft().getRight().getName()));
        assertEquals((Object) 15, Integer.valueOf(root.getRight().getLeft().getName()));
        assertEquals((Object) 29, Integer.valueOf(root.getRight().getRight().getName()));
    }


    @Test
    public void listOfDepthTest() {
        BinTreeNode root = new BinTreeNode("11");

        BinTreeNode l1L = new BinTreeNode("3");
        BinTreeNode l1R = new BinTreeNode("19");
        root.setLeft(l1L);
        root.setRight(l1R);

        BinTreeNode l2l1 = new BinTreeNode("1");
        BinTreeNode l2r1 = new BinTreeNode("9");
        l1L.setLeft(l2l1);
        l1L.setRight(l2r1);

        BinTreeNode l2l2 = new BinTreeNode("15");
        BinTreeNode l2r2 = new BinTreeNode("29");
        l1R.setLeft(l2l2);
        l1R.setRight(l2r2);


        List<List<BinTreeNode>> res = tg.listOfDepth(root);
        assertEquals(3, res.size());
        assertEquals(4, res.get(2).size());

    }

    @Test
    public void isBalancedTest() {

        BinTreeNode root = new BinTreeNode("11");

        BinTreeNode l1L = new BinTreeNode("3");
        BinTreeNode l1R = new BinTreeNode("19");
        root.setLeft(l1L);
        root.setRight(l1R);

        BinTreeNode l2l1 = new BinTreeNode("1");
        BinTreeNode l2r1 = new BinTreeNode("9");
        l1L.setLeft(l2l1);
        l1L.setRight(l2r1);

        BinTreeNode l2l2 = new BinTreeNode("15");
        BinTreeNode l2r2 = new BinTreeNode("29");
        l1R.setLeft(l2l2);
        l1R.setRight(l2r2);

        assertTrue(tg.isBalanced(root));

    }


    @Test
    public void isBSTTest() {
        BinTreeNode root = new BinTreeNode("11");

        BinTreeNode l1L = new BinTreeNode("3");
        BinTreeNode l1R = new BinTreeNode("19");
        root.setLeft(l1L);
        root.setRight(l1R);
        l1L.setParent(root);
        l1R.setParent(root);

        BinTreeNode l2l1 = new BinTreeNode("1");
        BinTreeNode l2r1 = new BinTreeNode("9");
        l1L.setLeft(l2l1);
        l1L.setRight(l2r1);
        l2l1.setParent(l1L);
        l2r1.setParent(l1L);

        BinTreeNode l2l2 = new BinTreeNode("15");
        BinTreeNode l2r2 = new BinTreeNode("29");
        l1R.setLeft(l2l2);
        l1R.setRight(l2r2);
        l2l2.setParent(l1R);
        l2r2.setParent(l1R);


        assertTrue(tg.isBST(root));
    }


    @Test
    public void isBSTTest1() {

        BinTreeNode root = new BinTreeNode("8");
        BinTreeNode l1L = new BinTreeNode("4");
        BinTreeNode l1R = new BinTreeNode("10");
        root.setLeft(l1L);
        root.setRight(l1R);
        l1L.setParent(root);
        l1R.setParent(root);

        BinTreeNode l2l1 = new BinTreeNode("2");
        BinTreeNode l2r1 = new BinTreeNode("6");
        l1L.setLeft(l2l1);
        l1L.setRight(l2r1);
        l2l1.setParent(l1L);
        l2r1.setParent(l1L);

        BinTreeNode l2r2 = new BinTreeNode("20");
        l1R.setRight(l2r2);
        l2r2.setParent(l1R);
        assertTrue(tg.isBST(root));


    }

    @Test
    public void isBSTTest2() {

        BinTreeNode root = new BinTreeNode("8");
        BinTreeNode l1L = new BinTreeNode("4");
        BinTreeNode l1R = new BinTreeNode("10");
        root.setLeft(l1L);
        root.setRight(l1R);
        l1L.setParent(root);
        l1R.setParent(root);

        BinTreeNode l2l1 = new BinTreeNode("2");
        BinTreeNode l2r1 = new BinTreeNode("12");
        l1L.setLeft(l2l1);
        l1L.setRight(l2r1);
        l2l1.setParent(l1L);
        l2r1.setParent(l1L);

        BinTreeNode l2r2 = new BinTreeNode("20");
        l1R.setRight(l2r2);
        l2r2.setParent(l1R);

        assertFalse(tg.isBST(root));

    }


    @Test
    public void buildOrderTest() {
        Map<String, List<String>> deps = Map.of("a", List.of("d"),
                "f", List.of("b","a"),
                "b",List.of("d"),
                "d",List.of("c"));

        List<String> res = tg.buildOrder(deps);

        System.out.println(res);
        assertEquals(5,res.size());
        assertEquals("f",res.get(0));
    }


    @Test
    public void buildOrderTwoRootsTest() {
        Map<String, List<String>> deps = Map.of("a", List.of("e"),
                "f", List.of("b","c","a"),
                "c",List.of("a"),
                "b",List.of("a"),
                "d",List.of("g"));

        List<String> res = tg.buildOrder(deps);

        System.out.println(res);
        assertEquals(7,res.size());

    }


    @Test
    public void findCommonAncestorTest(){
        GraphNode root = new GraphNode("20");

        GraphNode ch1 = new GraphNode("10");
        GraphNode ch2 = new GraphNode("30");
        root.setChildren(List.of(ch1,ch2));
        ch1.setParent(root);
        ch2.setParent(root);

        GraphNode ch3 = new GraphNode("5");
        GraphNode ch4 = new GraphNode("15");
        ch1.setChildren(List.of(ch3,ch4));
        ch3.setParent(ch1);
        ch4.setParent(ch1);

        GraphNode ch5 = new GraphNode("17");
        ch4.setChildren(List.of(ch5));
        ch5.setParent(ch4);

        GraphNode ch6 = new GraphNode("3");
        GraphNode ch7 = new GraphNode("4");
        ch3.setChildren(List.of(ch6,ch7));
        ch6.setParent(ch3);
        ch7.setParent(ch3);

        GraphNode ancestor = tg.findCommonAncestor(ch3,ch2);
        assertEquals(root.getName(),ancestor.getName());


    }


    @Test
    public void bstSeqTest(){
        BinTreeNode root = new BinTreeNode("2");
        root.setLeft(new BinTreeNode("1"));
        root.setRight(new BinTreeNode("3"));

        List<List<BinTreeNode>> res = tg.bstSequences(root);
        assertEquals(2,res.size());
        assertEquals(root,res.get(0).get(0));
    }
}
