package cn.hans.core.java.chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class CalendarTest {

    public static void main(String[] args) {
//        LocalDate date = LocalDate.now();
//        int month = date.getMonthValue();
//        int today = date.getDayOfMonth();
//
//        Scanner in = new Scanner(System.in);
//
//        while (true) {
//            System.out.print("请输入要查看的月份：");
//            int Month = in.nextInt();
//            if (Month < 0) {
//                continue;
//            }
//            Month %= 12;
//            month = Month + 1;
//            date = date.withMonth(month).withDayOfMonth(1);
////            date = date.withDayOfMonth(1); // Set to start of month
//            DayOfWeek dayOfWeek = date.getDayOfWeek();
//            int value = dayOfWeek.getValue(); // 1 = Monday, ...7 = Sunday
//
//            System.out.println("Mon Tue Wed Thu Fri Sat Sun");
//            for (int i = 1; i < value; i++) {
//                System.out.print("    ");
//            }
//
//            while (date.getMonthValue() == month) {
//                System.out.printf("%3d", date.getDayOfMonth());
//                if (today == date.getDayOfMonth() && month == LocalDate.now().getMonthValue()) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//                date = date.plusDays(1);
//                if (date.getDayOfWeek().getValue() == 1) {
//                    System.out.println();
//                }
//            }
//            System.out.println();
//        }
        LocalDate now = LocalDate.now();
        now = now.withDayOfMonth(1);
        int monthValue = now.getMonthValue();
        int weekValue = now.getDayOfWeek().getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun ");

        for (int i = 1; i < weekValue; i++) {
            System.out.print("    ");
        }

        while (monthValue == now.getMonthValue()) {
            now.getDayOfMonth();
            System.out.printf("%3d", now.getDayOfMonth());
            if (LocalDate.now().getDayOfMonth() == now.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (now.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
            now = now.plusDays(1);
        }
        System.out.println();
    }
}
