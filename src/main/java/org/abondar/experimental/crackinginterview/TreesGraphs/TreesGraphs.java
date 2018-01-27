package org.abondar.experimental.crackinginterview.TreesGraphs;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class TreesGraphs {


    public boolean hasRouteBFS(List<GraphNode> graph, GraphNode start, GraphNode end) {

        return graph.contains(start) && graph.contains(end) && GraphUtil.doBFS(start).contains(end);

    }

    public boolean hasRouteDFS(List<GraphNode> graph, GraphNode start, GraphNode end) {

        return graph.contains(start) && graph.contains(end) && GraphUtil.doDFSStack(start).contains(end);

    }

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


    public List<List<BinTreeNode>> listOfDepth(BinTreeNode root) {
        List<List<BinTreeNode>> res = new ArrayList<>();

        List<BinTreeNode> currentLevel = new ArrayList<>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (currentLevel.size() > 0) {
            res.add(currentLevel);
            List<BinTreeNode> parentLevel = currentLevel;
            currentLevel = new ArrayList<>();
            for (BinTreeNode p : parentLevel) {
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


    public boolean isBalanced(BinTreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }


    private int checkHeight(BinTreeNode root) {
        if (root == null) return -1;

        //height of left subtree
        int leftHeight = checkHeight(root.getLeft());

        // return error
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }


    public boolean isBST(BinTreeNode root) {
        return checkNode(root);
    }

    private boolean checkNode(BinTreeNode root) {

        if (root == null) return true;

        Integer curVal = Integer.valueOf(root.getName());

        if (root.getLeft() != null && root.getRight() != null) {
            Integer leftVal = Integer.valueOf(root.getLeft().getName());
            Integer rightVal = Integer.valueOf(root.getRight().getName());

            if (leftVal <= curVal && curVal < rightVal) {

                if (root.getParent() != null && root.equals(root.getParent().getLeft())) {
                    Integer parentVal = Integer.valueOf(root.getParent().getName());
                    if (rightVal > parentVal) {
                        return false;
                    }
                }

                return checkNode(root.getRight()) && checkNode(root.getLeft());
            }
        } else {
            return true;
        }

        return false;
    }


    public List<String> buildOrder(Map<String, List<String>> dependencies) {

        List<GraphNode> roots = new ArrayList<>();

        List<String> depVals = new ArrayList<>();
        dependencies.forEach((k, v) -> depVals.addAll(v));

        dependencies.forEach((k, v) -> {
            if (!depVals.contains(k)) {
                roots.add(new GraphNode(k));
            }
        });

        if (!roots.isEmpty()) {
            buildTrees(roots, dependencies);
        }


        return createOrder(roots);
    }

    private void buildTrees(List<GraphNode> roots, Map<String, List<String>> dependencies) {
        roots.forEach(r -> {
            List<GraphNode> children = new ArrayList<>();
            dependencies.forEach((k, v) -> {
                if (k.equals(r.getName())) {
                    v.forEach(c -> {
                        GraphNode child = new GraphNode(c);
                        if (!roots.contains(child)) {
                            children.add(child);
                        }
                    });
                }
                r.setChildren(children);
            });

            buildTrees(children, dependencies);
        });


    }


    private List<String> createOrder(List<GraphNode> roots) {
        List<String> res = new ArrayList<>();

        roots.forEach(r -> {
            res.add(r.getName());
            GraphUtil.doDFSStack(r).forEach(n -> res.add(n.getName()));
        });


        return res.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    public GraphNode findCommonAncestor(GraphNode node1, GraphNode node2) {

        int delta = depth(node1) - depth(node2);

        GraphNode shallowNode = delta > 0 ? node2 : node1;
        GraphNode deepNode = delta > 0 ? node1 : node2;

        deepNode = goUp(deepNode, Math.abs(delta));


        while (shallowNode!=deepNode && deepNode != null) {
            shallowNode = shallowNode.getParent();
            deepNode = deepNode.getParent();

        }

        return deepNode == null ? null:shallowNode;
    }

    private GraphNode goUp(GraphNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.getParent();
            delta--;
        }

        return node;
    }


    private int depth(GraphNode n) {
        int depth = 0;
        while (n != null) {
            n = n.getParent();
            depth++;
        }

        return depth;
    }


    public  List<List<BinTreeNode>> bstSequences(BinTreeNode root){
        List<List<BinTreeNode>> res = new ArrayList<>();

        if (root==null){
            res.add(new ArrayList<>());
            return res;
        }

        List<List<BinTreeNode>> leftSeq = bstSequences(root.getLeft());
        List<List<BinTreeNode>> rightSeq = bstSequences(root.getRight());

        List<BinTreeNode> prefix = new ArrayList<>();
        prefix.add(root);

        //weave lists from left and right
        leftSeq.forEach(ls-> rightSeq.forEach(rs->{
            List<List<BinTreeNode>> weaved = new ArrayList<>();
            weaveLists(ls,rs,weaved,prefix);
            res.addAll(weaved);
        }));

        return res;
    }

    //get all possible list combos. remove head from ls,recurse, than do the same with rs
    private void weaveLists(List<BinTreeNode> ls, List<BinTreeNode> rs, List<List<BinTreeNode>> weaved,List<BinTreeNode>prefix) {
        if (ls.size()==0 || rs.size()==0){
            List<BinTreeNode> res = new ArrayList<>();
            res.addAll(prefix);
            res.addAll(ls);
            res.addAll(rs);
            weaved.add(res);
            return;
        }

        BinTreeNode headLS = ls.remove(0);
        prefix.add(headLS);
        weaveLists(ls,rs,weaved,prefix);
        prefix.remove(prefix.size()-1);
        ls.add(0,headLS);

        BinTreeNode headRS = ls.remove(0);
        prefix.add(headRS);
        weaveLists(ls,rs,weaved,prefix);
        prefix.remove(prefix.size()-1);
        rs.add(0,headRS);


    }

}

