package org.abondar.experimental.tasks.sortingTasks;

public class MatrixElement {

    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "MatrixElement{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
