package org.abondar.experimental.crackinginterview.StacksQueues.AnimalShelter;

import java.util.LinkedList;
import java.util.List;

/**
 * In fact it's a priority queue
 */
public class AnimalQueue {

    private int order = 0;
    private LinkedList<Dog> dogList = new LinkedList<>();
    private LinkedList<Cat> catList = new LinkedList<>();

    public void enqueue(Animal a) {
        a.setOrder(order++);

        if (a instanceof Dog) {
            dogList.add((Dog) a);
        } else {
            catList.add((Cat) a);
        }
    }


    public Animal dequeueAny() {

        Dog dog = dogList.peek();
        Cat cat = catList.peek();

        if (dog != null && cat != null) {
            if (dog.isOlder(cat)) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }

        } else return null;

    }

    /**
     * returns the oldest one(with the smallest order)
     */
    public Dog dequeueDog() {
        return dogList.poll();
    }

    /**
     * returns the oldest one(with the smallest order)
     */
    public Cat dequeueCat() {
        return catList.poll();
    }


    public List<Dog> getDogList() {
        return dogList;
    }

    public List<Cat> getCatList() {
        return catList;
    }
}
