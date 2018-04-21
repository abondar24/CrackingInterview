package org.abondar.experimental.crackinginterview.stacksqueues.shelter;

/**
 * There are two types of animals which are stored in queue
 * People can adopt either the oldest animal or
 */
public abstract class Animal {

    protected String name;
    private int order;

    public Animal(String name) {
        this.name = name;

    }

    public boolean isOlder(Animal animal){
        return this.order<animal.order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
