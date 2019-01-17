package cn.hans.core.java.chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        new TalkingClock(2000, true).start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class  TalkingClock {
    private int interval;
    private boolean beep;

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public TalkingClock(int interval, boolean beep) {
        this.beep = beep;
        this.interval = interval;
    }

    public void start() {
        ActionListener listener = this.new TimePrinter();
        new Timer(interval, listener).start();
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (TalkingClock.this.isBeep()) {
                Toolkit.getDefaultToolkit().beep();
            }
            System.out.println(TalkingClock.this.beep + " " + TalkingClock.this.interval);
        }
    }
}
