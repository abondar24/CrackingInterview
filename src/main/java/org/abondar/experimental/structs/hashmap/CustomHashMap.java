package org.abondar.experimental.structs.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomHashMap<K, V> {

    private static final double MIN_LOAD = 0.7;
    private static final double MAX_LOAD = 1.0;
    private List<HashNode<K, V>> buckets;
    private int numBuckets;
    private int size;


    public CustomHashMap() {
        buckets = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void remove(K key) {
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key,hashCode);

        HashNode<K, V> head = buckets.get(bucketIndex);

        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                break;
            }

            prev = head;
            head = head.next;
        }

        if (head==null){
            return;
        }

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets.set(bucketIndex, head.next);
        }

    }

    public V get(K key) {
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key,hashCode);


        HashNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int hashCode = hashCode(key);
        int bucketIndex = getBucketIndex(key,hashCode);

        HashNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        size++;
        head = buckets.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        if ((MAX_LOAD * size) / numBuckets >= MIN_LOAD) {
            List<HashNode<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                buckets.add(null);
            }

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }

    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key,int hashCode) {
        int index = hashCode % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }


    private class HashNode<K, V> {
        final int hashCode;
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }


    }

}
