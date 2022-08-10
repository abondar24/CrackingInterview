package org.abondar.experimental.strcuts.queue.shelter;

import org.abondar.experimental.structs.queue.shelter.AnimalQueue;
import org.abondar.experimental.structs.queue.shelter.Cat;
import org.abondar.experimental.structs.queue.shelter.Dog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AnimalQueueTest {

    @Test
    public void shelterTest() {
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
    public void shelterEmptyTest() {
        AnimalQueue aq = new AnimalQueue();
        assertNull(aq.dequeueAny());
    }
}
