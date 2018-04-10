package org.abondar.experimental.algorithms;

import org.abondar.experimental.crackinginterview.TreesGraphs.GraphNode;
import org.abondar.experimental.crackinginterview.TreesGraphs.GraphUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphAlgUtil {

    public static int shortestPath(GraphNode root,GraphNode dest){

        PriorityQueue<GraphNode> toVisit = new PriorityQueue<>();
        toVisit.add(root);
         int res=0;
        while (!toVisit.isEmpty()){
            GraphNode min = toVisit.remove();
            if (min==dest){
                return getDistanceToSource(root,min);
            }
            if (min.isVisited()){
                continue;
            }
            min.setVisited(true);

            for (Map.Entry<GraphNode, Integer> entry: min.getChildrenWithPath().entrySet()){
                int adjDistance = getDistanceToSource(root,min) + entry.getValue();
                if (getDistanceToSource(root, entry.getKey())>adjDistance && !entry.getKey().isVisited()){
                    res = adjDistance;
                    toVisit.add(entry.getKey());
                }
            }

        }

        return res;
    }



    public static int getDistanceToSource(GraphNode root,GraphNode dest){
        if (dest.getParent()==root){
            return root.getChildrenWithPath().get(dest);
        }

        int distance = 0;
        GraphNode parent = new GraphNode();
        GraphNode child = dest;
        while (parent!=null){
            parent = child.getParent();
            distance += parent.getChildrenWithPath().get(child);

            child = parent;
            parent = parent.getParent();
        }

        return distance;
    }
}
