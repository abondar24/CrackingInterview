package org.abondar.experimental.algorithms;

import org.abondar.experimental.structs.tree.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GraphTest {

    private GraphAlgs gu = new GraphAlgs();

    @Test
    public void distanceToSourceTest(){
        GraphNode root = new GraphNode("s");

        GraphNode two = new GraphNode("2");
        GraphNode one = new GraphNode("1",Map.of(two,1));
        two.setParent(one);
        one.setParent(root);

        root.setChildrenWithWeight(Map.of(one,1));

        int distToSource = gu.getDistanceToSource(root,two);
        assertEquals(2,distToSource);

        distToSource = gu.getDistanceToSource(root,root);
        assertEquals(0,distToSource);

    }


    @Test
    public void shortestPathTest(){
        GraphNode root = new GraphNode("s");

        GraphNode one = new GraphNode("1");
        GraphNode two = new GraphNode("2");
        GraphNode three = new GraphNode("3");

        one.setParent(root);

        root.setChildrenWithWeight(Map.of(one,6,two,8,three,18));
        two.setChildrenWithWeight(Map.of(three,9));


        GraphNode four = new GraphNode("4");
        four.setParent(one);
        one.setChildrenWithWeight(Map.of(four,11));

        GraphNode five = new GraphNode("5");
        five.setParent(four);
        four.setChildrenWithWeight(Map.of(five,3));
        five.setChildrenWithWeight(Map.of(three,4,two,7));


        //cheat-code: I set as a parent the one with shortest distance
        three.setParent(five);
        three.setChildrenWithWeight(Map.of());

        two.setParent(five);


        assertEquals(6,gu.dijktstraShortestPath(root,one));
        root.setVisited(false);
        one.setVisited(false);
        two.setVisited(false);
        three.setVisited(false);
        four.setVisited(false);
        five.setVisited(false);

        assertEquals(8,gu.dijktstraShortestPath(root,two));
        root.setVisited(false);
        one.setVisited(false);
        two.setVisited(false);
        three.setVisited(false);
        four.setVisited(false);
        five.setVisited(false);

        /*
        assertEquals(17,gu.shortestPath(root,three));
        root.setVisited(false);
        one.setVisited(false);
        two.setVisited(false);
        three.setVisited(false);
        four.setVisited(false);
        five.setVisited(false);
        */

        assertEquals(17,gu.dijktstraShortestPath(root,four));
        root.setVisited(false);
        one.setVisited(false);
        two.setVisited(false);
        three.setVisited(false);
        four.setVisited(false);
        five.setVisited(false);

        assertEquals(20,gu.dijktstraShortestPath(root,five));
        root.setVisited(false);
        one.setVisited(false);
        two.setVisited(false);
        three.setVisited(false);
        four.setVisited(false);
        five.setVisited(false);
    }
}
