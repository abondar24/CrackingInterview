package org.abondar.experimental.strcuts;

import org.abondar.experimental.structs.tree.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
//
//    @Test
//    public void hasRouteBFSTest() {
//
//        GraphNode zero = new GraphNode("0");
//        GraphNode one = new GraphNode("1");
//        GraphNode two = new GraphNode("2");
//        GraphNode three = new GraphNode("3");
//        GraphNode four = new GraphNode("4");
//        GraphNode five = new GraphNode("5");
//
//        List<GraphNode> graph = new ArrayList<>();
//
//        zero.setChildren(List.of(one, four, five));
//        graph.add(zero);
//
//        one.setChildren(List.of(four, three));
//        graph.add(one);
//
//        two.setChildren(List.of(one, three));
//        graph.add(two);
//
//        three.setChildren(List.of(two, four));
//        graph.add(three);
//
//        four.setChildren(List.of());
//        graph.add(four);
//
//        five.setChildren(List.of());
//        graph.add(five);
//
//        assertTrue(tg.hasRouteBFS(graph, zero, three));
//        assertFalse(tg.hasRouteBFS(graph, two, five));
//
//    }
//
//
//    @Test
//    public void hasRouteDFSTest() {
//
//        GraphNode zero = new GraphNode("0");
//        GraphNode one = new GraphNode("1");
//        GraphNode two = new GraphNode("2");
//        GraphNode three = new GraphNode("3");
//        GraphNode four = new GraphNode("4");
//        GraphNode five = new GraphNode("5");
//
//        List<GraphNode> graph = new ArrayList<>();
//
//        zero.setChildren(List.of(one, four, five));
//        graph.add(zero);
//
//        one.setChildren(List.of(four, three));
//        graph.add(one);
//
//        two.setChildren(List.of(one, three));
//        graph.add(two);
//
//        three.setChildren(List.of(two, four));
//        graph.add(three);
//
//        four.setChildren(List.of());
//        graph.add(four);
//
//        five.setChildren(List.of());
//        graph.add(five);
//
//        assertTrue(tg.hasRouteDFS(graph, zero, three));
//        assertFalse(tg.hasRouteDFS(graph, two, five));
//
//    }
//
//    @Test
//    public void findCommonAncestorTest(){
//        GraphNode root = new GraphNode("20");
//
//        GraphNode ch1 = new GraphNode("10");
//        GraphNode ch2 = new GraphNode("30");
//        root.setChildren(List.of(ch1,ch2));
//        ch1.setParent(root);
//        ch2.setParent(root);
//
//        GraphNode ch3 = new GraphNode("5");
//        GraphNode ch4 = new GraphNode("15");
//        ch1.setChildren(List.of(ch3,ch4));
//        ch3.setParent(ch1);
//        ch4.setParent(ch1);
//
//        GraphNode ch5 = new GraphNode("17");
//        ch4.setChildren(List.of(ch5));
//        ch5.setParent(ch4);
//
//        GraphNode ch6 = new GraphNode("3");
//        GraphNode ch7 = new GraphNode("4");
//        ch3.setChildren(List.of(ch6,ch7));
//        ch6.setParent(ch3);
//        ch7.setParent(ch3);
//
//        GraphNode ancestor = tg.findCommonAncestor(ch3,ch2);
//        assertEquals(root.getName(),ancestor.getName());
//
//
//    }
//
//    @Test
//    public void buildOrderTest() {
//        Map<String, List<String>> deps = Map.of("a", List.of("d"),
//                "f", List.of("b","a"),
//                "b",List.of("d"),
//                "d",List.of("c"));
//
//        List<String> res = tg.buildOrder(deps);
//
//        assertEquals(5,res.size());
//        assertEquals("f",res.get(0));
//    }
//
//
//    @Test
//    public void buildOrderTwoRootsTest() {
//        Map<String, List<String>> deps = Map.of("a", List.of("e"),
//                "f", List.of("b","c","a"),
//                "c",List.of("a"),
//                "b",List.of("a"),
//                "d",List.of("g"));
//
//        List<String> res = tg.buildOrder(deps);
//
//        assertEquals(7,res.size());
//
//    }
//

}
