package edu.rseymour.advancedjava.generics;

/**
 * Class that can hold any type and return it.
 * Prompt 1 of Assignment 3.
 *
 * @param <T> Any Generic type that this class returns.
 */
public class GenericContainer<T> {

    // The type that this container holds.
    private T t;

    /**
     * Sets the Type.
     * @param t
     */
    public void set(T t) { this.t = t; }

    /**
     * @return the type stored in this container.
     */
    public T get(){ return t; }
}
