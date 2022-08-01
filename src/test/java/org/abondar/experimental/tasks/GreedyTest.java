package org.abondar.experimental.tasks;


import org.abondar.experimental.tasks.greedy.Greedy;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertEquals(4,coverage.size());
        assertTrue(coverage.contains("ktwo"));
        assertTrue(coverage.contains("kthree"));
        assertTrue(coverage.contains("kone"));
        assertTrue(coverage.contains("kfive"));

    }
}
