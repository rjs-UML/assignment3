package edu.rseymour.advancedjava.generics;

import java.lang.reflect.Method;

/**
 * Class that prints Generic types.
 */
public class GenericPrinter {

    /**
     * Prints elements in an array of Generic Types.
     * @param array an array of Generic Elements.
     * @param <T> Generic Type in array.
     */
    public static <T> void printArray(T[] array) {
        for (T element : array)
            System.out.printf("%s\n", element);
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        GenericPrinter myPrinter = new GenericPrinter();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;


        for (Method method : GenericPrinter.class.getDeclaredMethods()) {
            String name = method.getName();
            if(name.equals("printArray"))
                count++;
        }
        if(count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}
