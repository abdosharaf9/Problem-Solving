package utils;

public class ArrayUtils {

    public static void printArray(String[] array) {
        System.out.print("[");

        for (String x : array) {
            if (x.equals(array[array.length - 1])) {
                System.out.print(x);
            } else {
                System.out.print(x + ", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(char[] array) {
        System.out.print("[");

        for (char x : array) {
            if (x == array[array.length - 1]) {
                System.out.print(x);
            } else {
                System.out.print(x + ", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(int[] array) {
        System.out.print("[");

        for (int x : array) {
            if (x == array[array.length - 1]) {
                System.out.print(x);
            } else {
                System.out.print(x + ", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(double[] array) {
        System.out.print("[");

        for (double x : array) {
            if (x == array[array.length - 1]) {
                System.out.print(x);
            } else {
                System.out.print(x + ", ");
            }
        }

        System.out.println("]");
    }

    public static void printArray(long[] array) {
        System.out.print("[");

        for (long x : array) {
            if (x == array[array.length - 1]) {
                System.out.print(x);
            } else {
                System.out.print(x + ", ");
            }
        }

        System.out.println("]");
    }
}
