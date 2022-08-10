package org.abondar.experimental.strcuts.queue;

import org.abondar.experimental.structs.queue.CustomQueue;
import org.abondar.experimental.structs.queue.TwoStackQueue;
import org.abondar.experimental.structs.queue.shelter.AnimalQueue;
import org.abondar.experimental.structs.queue.shelter.Cat;
import org.abondar.experimental.structs.queue.shelter.Dog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {

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


    //TODO: Move to a separate test class
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


    //TODO: Move to a separate test class
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

    //TODO: Move to a separate test class
    @Test
    public void animalShelterTestEmpty() {
        AnimalQueue aq = new AnimalQueue();
        assertNull(aq.dequeueAny());
    }
}
