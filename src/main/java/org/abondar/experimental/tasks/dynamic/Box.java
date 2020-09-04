package org.abondar.experimental.tasks.dynamic;

public class Box implements Comparable<Box> {

    private int height;

    private int width;

    private int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int compareTo(Box b) {
        return b.getHeight() - this.height;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                '}';
    }
}
