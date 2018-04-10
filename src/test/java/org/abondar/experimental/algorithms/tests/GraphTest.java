package org.abondar.experimental.algorithms.tests;

import org.abondar.experimental.algorithms.GraphAlgUtil;
import org.abondar.experimental.crackinginterview.TreesGraphs.GraphNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GraphTest {

    @Test
    public void distanceToSourceTest(){
        GraphNode root = new GraphNode("s");

        GraphNode two = new GraphNode("2");
        GraphNode one = new GraphNode("1",Map.of(two,1));
        two.setParent(one);
        one.setParent(root);

        root.setChildrenWithPath(Map.of(one,1));

        int distToSource = GraphAlgUtil.getDistanceToSource(root,two);

        assertEquals(2,distToSource);
    }


    @Test
    public void shortestPathTest(){
        GraphNode root = new GraphNode("s");

        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");

        one.setParent(root);
        two.setParent(root);

        root.setChildrenWithPath(Map.of(one,6,two,8,three,18));
        two.setChildrenWithPath(Map.of(three,9));

        GraphNode four = new GraphNode("4");
        four.setParent(one);
        one.setChildrenWithPath(Map.of(four,11));

        GraphNode five = new GraphNode("5");
        five.setParent(four);
        four.setChildrenWithPath(Map.of(five,3));
        five.setChildrenWithPath(Map.of(three,4,two,7));


        //cheat-code: I set as a parent the one with shortest distance
        three.setParent(five);

        assertEquals(6,GraphAlgUtil.shortestPath(root,one));
        assertEquals(8,GraphAlgUtil.shortestPath(root,two));
        assertEquals(17,GraphAlgUtil.shortestPath(root,three));
        assertEquals(17,GraphAlgUtil.shortestPath(root,four));
        assertEquals(20,GraphAlgUtil.shortestPath(root,five));
    }
}
