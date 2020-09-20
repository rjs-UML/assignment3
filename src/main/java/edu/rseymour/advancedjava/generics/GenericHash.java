package edu.rseymour.advancedjava.generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generic HashMap class for Prompt 2 of Assignment 3.
 * @param <T> Any generic type.
 * @param <V> The generic value associated with the generic type.
 */
public class GenericHash<T, V> {

    private T type;
    private V value;

    /**
     * No-arg constructor.
     */
    public GenericHash() {

    }

    /**
     * Constructor that returns generic hashmap object.
     * @param t the generic type of the hashmap.
     * @param v the generic value associated with the generic type.
     */
    public GenericHash(T t, V v) {
        this.type = t;
        this.value = v;
    }

    /**
     * @return the Type stored in the Generic Hashmap.
     */
    public T getType() {
        return type;
    }

    /**
     * Sets the Type stored in the Generic Hashmap.
     * @param type the generic type to store.
     */
    public void setType(T type) {
        this.type = type;
    }

    /**
     * @return the Value associated with the generic type.
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the Value associated with the generic type in the HashMap.
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {

        GenericHash<Integer, String> genericHash = new GenericHash<>();

    }
}
