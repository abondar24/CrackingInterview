package org.abondar.experimental.problems.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Greedy {

    public List<String> setCoverage(Set<String> states, Map<String, Set<String>> stationMap) {


        List<String> stations = new ArrayList<>();

        while (!states.isEmpty()) {
            String bestStation = "";
            List<String> coveredStates = new ArrayList<>();
            for (Map.Entry<String, Set<String>> entry : stationMap.entrySet()) {
                Set<String> covered = new HashSet<>(states);
                covered.retainAll(entry.getValue());
                if (covered.size() > coveredStates.size()) {
                    bestStation = entry.getKey();
                    coveredStates = new ArrayList<>(covered);
                }
            }

            states.removeIf(coveredStates::contains);

            if (!bestStation.isBlank()) {
                stations.add(bestStation);
            }


        }


        return stations;
    }
}
