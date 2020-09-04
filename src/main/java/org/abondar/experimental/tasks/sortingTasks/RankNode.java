package org.abondar.experimental.tasks.sortingTasks;

public class RankNode {
    private int leftSize = 0;
    private RankNode left;
    private RankNode right;
    private int data = 0;

    public RankNode(int data) {
        this.data = data;
    }

    public void insert(int d) {
        if (d <= data) {
            if (left != null) left.insert(d);
            else left = new RankNode(d);
            leftSize++;
        } else {
            if (right != null) right.insert(d);
            else right = new RankNode(d);
        }
    }

    public int getRank(int d) {
        if (d == data) {
            return leftSize;
        } else if (d < data) {
            if (left == null) return -1;
            else return left.getRank(d);
        } else {
            int rightRank = right == null ? -1 : right.getRank(d);
            if (rightRank == -1) return -1;
            else return leftSize + 1 + rightRank;
        }
    }
}
