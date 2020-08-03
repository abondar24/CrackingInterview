package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.stacksqueues.*;

import org.abondar.experimental.tasks.stacksqueues.shelter.AnimalQueue;
import org.abondar.experimental.tasks.stacksqueues.shelter.Cat;
import org.abondar.experimental.tasks.stacksqueues.shelter.Dog;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StacksQueuesTest {


    @Test
    public void customStackTest() {
        CustomStack<Integer> cs = new CustomStack<>();

        assertTrue(cs.isEmpty());
        cs.push(1);
        cs.push(2);
        cs.push(3);

        assertEquals((Object) 3, cs.peek());

        cs.pop();
        assertEquals((Object) 2, cs.peek());
    }


    @Test
    public void customQueueTest() {
        CustomQueue<Integer> cq = new CustomQueue<>();
        assertTrue(cq.isEmpty());

        cq.add(1);
        cq.add(2);
        cq.add(3);
        assertEquals((Object) 1, cq.peek());
        assertEquals((Object) 1, cq.remove());
        assertEquals((Object) 2, cq.peek());


    }

    @Test
    public void multiStackTest() {
        int[] arr = new int[]{2, 10, 12, 3, 5, 6, 90, 24, 33, 1, 0, 15};
        MultiStack ms = new MultiStack(arr, 3);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(3, stackList.size());
        assertEquals(3, stackList.get(0).peek());
        assertEquals(24, stackList.get(1).peek());
        assertEquals(15, stackList.get(2).peek());
    }


    @Test
    public void multiStackTestStackSizesDiffer() {
        int[] arr = new int[]{2, 10, 12, 3, 5};
        MultiStack ms = new MultiStack(arr, 2);

        List<CustomStack> stackList = ms.splitToStacks();
        assertEquals(2, stackList.size());
        assertEquals(10, stackList.get(0).peek());
        assertEquals(5, stackList.get(1).peek());
    }

    @Test
    public void stackMinTest() {
        MinStack stack = new MinStack();


        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals((Object) 1, stack.min());

    }

    @Test
    public void setOfStacksTest() {
        SetOfStacks ss = new SetOfStacks(3);

        ss.push(1);
        assertEquals((Object) 1, ss.peek());

        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        assertEquals((Object) 5, ss.peek());

        Map<CustomStack, Integer> stackSet = ss.getStackSet();


        assertEquals(2, stackSet.size());
        assertEquals((Object) 5, ss.pop());

    }

    @Test
    public void setOfStacksTestThreeStacks() {
        SetOfStacks ss = new SetOfStacks(3);

        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        ss.push(6);
        ss.push(7);

        Map<CustomStack, Integer> stackSet = ss.getStackSet();

        assertEquals(3, stackSet.size());

    }


    @Test
    public void twoStackQueueTest() {
        TwoStackQueue<Integer> tsq = new TwoStackQueue<>();
        tsq.add(1);

        assertEquals((Object) 1, tsq.peek());


        tsq.add(2);
        tsq.add(3);

        assertEquals((Object) 1, tsq.remove());

        tsq.add(4);
        tsq.add(5);
        assertEquals((Object) 2, tsq.peek());
    }


    @Test
    public void sortStackTest() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(1);
        stack.push(12);
        stack.push(8);
        stack.push(3);

        CustomStack<Integer> sorted = StackUtil.sortStack(stack);

        System.out.println(sorted);
        assertEquals((Object) 12, sorted.peek());
    }


    @Test
    public void sortStackTest1() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(5);
        stack.push(10);
        stack.push(7);
        stack.push(14);


        CustomStack<Integer> sorted = StackUtil.sortStack(stack);

        System.out.println(sorted);
        assertEquals((Object) 14, sorted.peek());
    }

    @Test
    public void animalShelterTest() {
        Dog dog = new Dog("abdi");
        Cat cat = new Cat("saloman");

        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(dog);
        aq.enqueue(cat);

        List<Dog> dogs = aq.getDogList();
        List<Cat> cats = aq.getCatList();

        assertEquals(1, dogs.size());
        assertEquals(1, cats.size());

        Dog dog1 = new Dog("salo");
        Cat cat1 = new Cat("chuckha");


        aq.enqueue(dog1);
        aq.enqueue(cat1);

        assertEquals(dog, aq.dequeueDog());
        assertEquals(cat, aq.dequeueCat());

        aq.enqueue(dog);
        aq.enqueue(cat);
        assertEquals(dog1, aq.dequeueAny());

    }

    @Test
    public void animalShelterTestEmpty() {
        AnimalQueue aq = new AnimalQueue();
        assertEquals(null,aq.dequeueAny());
    }

}
