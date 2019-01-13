package cn.hans.core.java.chapter9;

import java.util.*;

public class LinkListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        new ArrayList<>(100);
        new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

//        add方法在当前索引前出处插入输入，无论是通过next()还是previous()方法到达当前位置
//        System.out.println(aIter.previousIndex());
//        System.out.println(aIter.hasPrevious());
//        aIter.add("1");
//        System.out.println(aIter.previousIndex());
//        System.out.println(aIter.hasPrevious());
//        aIter.previous();
//        System.out.println(aIter.previousIndex());
//        System.out.println(aIter.hasPrevious());
//        aIter.add("1");
//        System.out.println(aIter.previousIndex());
//        System.out.println(aIter.hasPrevious());


        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            } else {
                System.out.println(aIter.nextIndex());
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();

        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

//        System.out.println(a.lastIndexOf("Bob"));
//        a.removeAll(b);
//        System.out.println(a.lastIndexOf("Bob"));

        System.out.println(a);
    }
}
