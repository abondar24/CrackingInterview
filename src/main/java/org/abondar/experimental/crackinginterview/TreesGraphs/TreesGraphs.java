package org.abondar.experimental.crackinginterview.TreesGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TreesGraphs {


    /**
     * Check if a graph has route between two nodes.
     */
    public boolean hasRouteBFS(List<GraphNode> graph, GraphNode start, GraphNode end) {

        return graph.contains(start) && graph.contains(end) && GraphUtil.doBFS(start).contains(end);

    }

    public boolean hasRouteDFS(List<GraphNode> graph, GraphNode start, GraphNode end) {

        return graph.contains(start) && graph.contains(end) && GraphUtil.doDFSStack(start).contains(end);

    }

    /**
     * Build a tree with min height from sorted array
     */
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

    /**
     * Get list of lists of nodes on every depth of the tree
     * */
    public List<List<BinTreeNode>> listOfDepth(BinTreeNode root) {
        List<List<BinTreeNode>> res = new ArrayList<>();

        List<BinTreeNode> currentLevel = new ArrayList<>();

        if (root!=null){
            currentLevel.add(root);
        }

        while (currentLevel.size()>0){
            res.add(currentLevel);
            List<BinTreeNode> parentLevel = currentLevel;
            currentLevel = new ArrayList<>();
            for(BinTreeNode p: parentLevel) {
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


}
