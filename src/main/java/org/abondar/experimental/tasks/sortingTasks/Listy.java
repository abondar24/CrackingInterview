package org.abondar.experimental.tasks.sortingTasks;

public class Listy{

    private int[] arr;

    public Listy(int[] arr) {
        this.arr = arr.clone();
    }

    public int elementAt(int index) {
            if (index >=arr.length){
                return -1;
            }
        return arr[index];
    }
}
