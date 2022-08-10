package org.abondar.experimental.strcuts.graph;

import org.abondar.experimental.structs.graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {


    @Test
    public void bfsTest() {
        Graph.GraphNode root = new Graph.GraphNode("0");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");
        Graph.GraphNode three = new Graph.GraphNode("3");
        Graph.GraphNode four = new Graph.GraphNode("4");
        Graph.GraphNode five = new Graph.GraphNode("5");

        graph.setNodeChildren(root, List.of(one, four, five));
        graph.setNodeChildren(one, List.of(four, three));
        graph.setNodeChildren(two, List.of(one, three));
        graph.setNodeChildren(three, List.of(two, four));

        List<Graph.GraphNode> res = graph.bfs(root);

        assertTrue(res.size() > 1);
    }

    @Test
    public void hasRouteBFSTest() {


        Graph.GraphNode root = new Graph.GraphNode("0");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");
        Graph.GraphNode three = new Graph.GraphNode("3");
        Graph.GraphNode four = new Graph.GraphNode("4");
        Graph.GraphNode five = new Graph.GraphNode("5");

        graph.setNodeChildren(root, List.of(one, four, five));
        graph.setNodeChildren(one, List.of(four, three));
        graph.setNodeChildren(two, List.of(one, three));
        graph.setNodeChildren(three, List.of(two, four));

        assertTrue(graph.hasRouteBFS(root, three));
        assertFalse(graph.hasRouteBFS(two, five));

    }

    @Test
    public void dfsTest() {
        Graph.GraphNode root = new Graph.GraphNode("0");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");
        Graph.GraphNode three = new Graph.GraphNode("3");
        Graph.GraphNode four = new Graph.GraphNode("4");
        Graph.GraphNode five = new Graph.GraphNode("5");

        graph.setNodeChildren(root, List.of(one, four, five));
        graph.setNodeChildren(one, List.of(four, three));
        graph.setNodeChildren(two, List.of(one, three));
        graph.setNodeChildren(three, List.of(two, four));

        List<Graph.GraphNode> res = graph.dfs(root);

        assertTrue(res.size() > 1);
    }

    @Test
    public void hasRouteDFSTest() {
        Graph.GraphNode root = new Graph.GraphNode("0");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");
        Graph.GraphNode three = new Graph.GraphNode("3");
        Graph.GraphNode four = new Graph.GraphNode("4");
        Graph.GraphNode five = new Graph.GraphNode("5");

        graph.setNodeChildren(root, List.of(one, four, five));
        graph.setNodeChildren(one, List.of(four, three));
        graph.setNodeChildren(two, List.of(one, three));
        graph.setNodeChildren(three, List.of(two, four));

        assertTrue(graph.hasRouteDFS(root, three));
        assertFalse(graph.hasRouteDFS(two, five));

    }

    @Test
    public void buildOrderTest() {
        Map<String, List<String>> deps = Map.of("a", List.of("d"),
                "f", List.of("b", "a"),
                "b", List.of("d"),
                "d", List.of("c"));

        Graph graph = new Graph();
        List<String> res = graph.buildOrder(deps);

        assertEquals(5, res.size());
        assertEquals("f", res.get(0));
    }


    @Test
    public void buildOrderTwoRootsTest() {
        Map<String, List<String>> deps = Map.of("a", List.of("e"),
                "f", List.of("b", "c", "a"),
                "c", List.of("a"),
                "b", List.of("a"),
                "d", List.of("g"));

        Graph graph = new Graph();
        List<String> res = graph.buildOrder(deps);

        assertEquals(7, res.size());

    }

    @Test
    public void findCommonAncestorTest() {
        Graph.GraphNode root = new Graph.GraphNode("20");
        Graph graph = new Graph(root);

        Graph.GraphNode ch1 = new Graph.GraphNode("10");
        Graph.GraphNode ch2 = new Graph.GraphNode("30");
        Graph.GraphNode ch3 = new Graph.GraphNode("5");
        Graph.GraphNode ch4 = new Graph.GraphNode("15");
        Graph.GraphNode ch5 = new Graph.GraphNode("17");
        Graph.GraphNode ch6 = new Graph.GraphNode("3");
        Graph.GraphNode ch7 = new Graph.GraphNode("4");

        graph.setNodeChildren(root, (List.of(ch1, ch2)));
        graph.setNodeChildren(ch1, List.of(ch3, ch4));
        graph.setNodeChildren(ch4, List.of(ch5));
        graph.setNodeChildren(ch3, List.of(ch6, ch7));

        Graph.GraphNode ancestor = graph.findCommonAncestor(ch3, ch2);
        assertEquals(root, ancestor);
    }

    @Test
    public void distanceToSourceTest() {
        Graph.GraphNode root = new Graph.GraphNode("s");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");

        graph.setNodeChildrenWithWeight(root, Map.of(one,1));
        graph.setNodeChildrenWithWeight(one, Map.of(two,1));

        int distToSource = graph.getDistanceToSource(two);
        assertEquals(2, distToSource);

        distToSource = graph.getDistanceToSource(root);
        assertEquals(0, distToSource);

    }

    @Test
    public void shortestPathTest() {
        Graph.GraphNode root = new Graph.GraphNode("s");
        Graph graph = new Graph(root);

        Graph.GraphNode one = new Graph.GraphNode("1");
        Graph.GraphNode two = new Graph.GraphNode("2");
        Graph.GraphNode three = new Graph.GraphNode("3");
        Graph.GraphNode four = new Graph.GraphNode("5");

        graph.setNodeChildrenWithWeight(root, Map.of(one,6, two,8, three,18));
        graph.setNodeChildrenWithWeight(two, Map.of(three,9));
        graph.setNodeChildren(three,List.of(four));
        graph.setNodeChildren(two,List.of(four));

        assertEquals(6, graph.dijktstraShortestPath(one));

    }


}
