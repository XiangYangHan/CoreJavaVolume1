package cn.hans.core.java.chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int i = (int) new Object();
//        a = badCopyOf(a, 10); // 提示int[]无法转换成为Object[]
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
//        b = (String[]) badCopyOf(b, 5);
        b = (String[]) goodCopyOf(b, 5);
        System.out.println(Arrays.toString(b));

    }

    public static Object[] badCopyOf(Object[] arr, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(arr, 0, newArray, 0, Math.min(arr.length, newLength));
        return newArray;
    }

    public static Object goodCopyOf(Object arr, int newLength) {
        Class<?> arrClass = arr.getClass();
        if (!arrClass.isArray()) {
            return null;
        }
        Class<?> componentType = arrClass.getComponentType();
        Object newArr = Array.newInstance(componentType, newLength);
        System.arraycopy(arr, 0, newArr, 0, Math.min(Array.getLength(arr), newLength));
        return newArr;
    }

}
