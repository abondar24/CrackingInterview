package org.abondar.experimental.structs.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//wrapper class for HashMap<T,ArrayList<E>>
public class HashMapList<T, E> {
    private final HashMap<T, ArrayList<E>> map = new HashMap<>();

    public void put(T key, E value) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());

        map.get(key).add(value);
    }

    public void put(T key, ArrayList<E> values) {
        map.put(key, values);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKey(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
