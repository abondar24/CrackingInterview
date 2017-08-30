package org.abondar.experimental.crackinginterview.tests;

import org.abondar.experimental.crackinginterview.ArraysStrings;
import org.junit.Assert;
import org.junit.Test;

public class ArraysStringsTest {

    private ArraysStrings as = new ArraysStrings();

    @Test
    public void inUniqueTest(){

        boolean res1 = as.isUniqque("hello world");
        Assert.assertFalse(res1);

        boolean res2 = as.isUniqque("formula");
        Assert.assertTrue(res2);

    }
}
