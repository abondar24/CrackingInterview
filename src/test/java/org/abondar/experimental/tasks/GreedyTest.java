package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.greedy.Greedy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GreedyTest {

    private final Greedy greedy = new Greedy();

    @Test
    public void setCoverageTest(){
        Set<String> states = new HashSet<>(List.of("mt","wa","or","id","nv","ut","ca","az"));

        Map<String,Set<String>> stationMap = Map.of(
                "kone",Set.of("id","nv","ut"),
                "ktwo",Set.of("wa","id","mt"),
                "kthree",Set.of("or","nv","ca"),
                "kfour",Set.of("nv","ut"),
                "kfive",Set.of("ca","az")
        );

        List<String> coverage = greedy.setCoverage(states,stationMap);

        System.out.println(coverage);

        Assert.assertEquals(4,coverage.size());
        Assert.assertTrue(coverage.contains("ktwo"));
        Assert.assertTrue(coverage.contains("kthree"));
        Assert.assertTrue(coverage.contains("kone"));
        Assert.assertTrue(coverage.contains("kfive"));

    }
}
