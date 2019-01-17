package cn.hans.core.java.chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        new TalkingClock2().start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }

}

class TalkingClock2 {
    public void start(int interval, boolean beep) {
        new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
                System.out.println(beep + " " + interval);
            }
        }).start();
//        new Timer(interval, e -> {
//            System.out.println("At the tone, the time is " + new Date());
//            if (beep) {
//                Toolkit.getDefaultToolkit().beep();
//            }
//        }).start();
    }
}
