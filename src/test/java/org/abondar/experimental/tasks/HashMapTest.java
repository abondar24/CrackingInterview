package org.abondar.experimental.tasks;

import org.abondar.experimental.structs.hashmap.CustomHashMap;
import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {

    @Test
    public void hasMapTest(){
        CustomHashMap<String,Integer> map = new CustomHashMap<>();
        map.add("test",1);
        Assert.assertEquals(1,map.size());

        map.add("test1",2);
        Assert.assertEquals(2,map.size());

        map.add("test1",3);
        Assert.assertEquals(2,map.size());
        Assert.assertEquals(Integer.valueOf(3),map.get("test1"));

        Assert.assertNull(map.get("test2"));

        map.remove("test1");
        Assert.assertEquals(1,map.size());

        map.remove("test");
        Assert.assertTrue(map.isEmpty());
    }


}
