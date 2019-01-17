package cn.hans.core.java.chapter6;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        new String();
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
//        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        Arrays.sort(planets, Comparator.comparingInt(String::length));
//        Arrays.sort(planets, Comparator.comparingInt(s -> s.length()));
//        Arrays.sort(planets, Comparator.comparing(String::length));
        System.out.println(Arrays.toString(planets));

        new Timer(1000, e -> System.out.println("The time is " + new Date())).start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
