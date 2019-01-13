package cn.hans.core.java.chapter5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTest {

    public static void main(String[] args) {
        Method square, sqrt;
        try {
            square = MethodTableTest.class.getDeclaredMethod("square", double.class);
            sqrt = Math.class.getDeclaredMethod("sqrt", double.class);

            printTable(1, 10, 20, square);
            printTable(1, 10, 20, sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double form, double to, int n, Method f) {
        System.out.println(f);

        double dx = (to - form) / (n - 1);

        for (double x = form; x <= to; x += dx) {
            try {
                double y = (double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f\n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
