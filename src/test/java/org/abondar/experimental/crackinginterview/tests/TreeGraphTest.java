package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.TreesGraphs.BinTreeNode;
import org.abondar.experimental.crackinginterview.TreesGraphs.GraphNode;
import org.abondar.experimental.crackinginterview.TreesGraphs.TreesGraphs;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeGraphTest {

    private TreesGraphs tg = new TreesGraphs();


    @Test
    public void hasRouteBFSTest(){

        GraphNode zero = new GraphNode("0");
        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        List<GraphNode> graph = new ArrayList<>();

        zero.setChildren(Arrays.asList(one,four,five));
        graph.add(zero);

        one.setChildren(Arrays.asList(four,three));
        graph.add(one);

        two.setChildren(Arrays.asList(one,three));
        graph.add(two);

        three.setChildren(Arrays.asList(two,four));
        graph.add(three);

        four.setChildren(Collections.emptyList());
        graph.add(four);

        five.setChildren(Collections.emptyList());
        graph.add(five);

        assertTrue(tg.hasRouteBFS(graph,zero,three));
        assertFalse(tg.hasRouteBFS(graph,two,five));

    }


    @Test
    public void hasRouteDFSTest(){

        GraphNode zero = new GraphNode("0");
        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");
        GraphNode four = new GraphNode("4");
        GraphNode five = new GraphNode("5");

        List<GraphNode> graph = new ArrayList<>();

        zero.setChildren(Arrays.asList(one,four,five));
        graph.add(zero);

        one.setChildren(Arrays.asList(four,three));
        graph.add(one);

        two.setChildren(Arrays.asList(one,three));
        graph.add(two);

        three.setChildren(Arrays.asList(two,four));
        graph.add(three);

        four.setChildren(Collections.emptyList());
        graph.add(four);

        five.setChildren(Collections.emptyList());
        graph.add(five);

        assertTrue(tg.hasRouteDFS(graph,zero,three));
        assertFalse(tg.hasRouteDFS(graph,two,five));

    }

    @Test
    public void minTreeTest(){
        int[] arr = {1,3,9,11,15,19,29};

        BinTreeNode root = tg.minTree(arr);
        assertEquals((Object) 11,Integer.valueOf(root.getName()));
        assertEquals((Object) 3,Integer.valueOf(root.getLeft().getName()));
        assertEquals((Object) 19,Integer.valueOf(root.getRight().getName()));
        assertEquals((Object) 1,Integer.valueOf(root.getLeft().getLeft().getName()));
        assertEquals((Object) 9,Integer.valueOf(root.getLeft().getRight().getName()));
        assertEquals((Object) 15,Integer.valueOf(root.getRight().getLeft().getName()));
        assertEquals((Object) 29,Integer.valueOf(root.getRight().getRight().getName()));
    }


    @Test
    public void listOfDepthTest(){
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
        assertEquals(3,res.size());
        assertEquals(4,res.get(2).size());

    }
}
