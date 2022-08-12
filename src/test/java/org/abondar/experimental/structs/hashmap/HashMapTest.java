package org.abondar.experimental.structs.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {

    @Test
    public void hasMapTest(){
        CustomHashMap<String,Integer> map = new CustomHashMap<>();
        map.add("test",1);
        assertEquals(1,map.size());

        map.add("test1",2);
        assertEquals(2,map.size());

        map.add("test1",3);
        assertEquals(2,map.size());
        assertEquals(Integer.valueOf(3),map.get("test1"));

        assertNull(map.get("test2"));

        map.remove("test1");
        assertEquals(1,map.size());

        map.remove("test");
        assertTrue(map.isEmpty());
    }


}
