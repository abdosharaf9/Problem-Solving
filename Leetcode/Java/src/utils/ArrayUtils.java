package utils;

import java.util.List;

public class ArrayUtils {

    public static void printArray(String[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(List<String> array) {
        System.out.print("[");

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i != array.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(char[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(double[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(long[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
