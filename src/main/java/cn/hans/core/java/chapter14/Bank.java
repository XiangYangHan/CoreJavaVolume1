package cn.hans.core.java.chapter14;

import java.util.Arrays;

public class Bank {

    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int form, int to, double amount) throws InterruptedException {
        if (accounts[form] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[form] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, form, to);
        Thread.sleep(5);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f\n", getTotalBalance());

    }

    public double getTotalBalance() {
        double sum = 0;

        for (double balance : accounts)
            sum += balance;

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
