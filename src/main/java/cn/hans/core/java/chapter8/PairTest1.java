package cn.hans.core.java.chapter8;

import java.io.Serializable;

public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> minmax = ArrayAlg.minmax(words);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());

        System.out.println(ArrayAlg.getMiddle(words));
    }

}

class ArrayAlg {
/*
    public static Pair<String> minmax(String[] a) {
        if (null == a || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
*/
    public static <T> T getMiddle(T... a) {
        return a[a.length >>> 1];
    }

    public static <T extends Object & Comparable & Serializable> T min(T... a) {
        if (null == a || a.length == 0) {
            return  null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }

    public static <T extends Comparable> Pair<T> minmax(T... a) {
        if (null == a ||
                a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[1];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) <0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
