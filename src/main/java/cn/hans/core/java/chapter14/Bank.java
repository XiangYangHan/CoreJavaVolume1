package cn.hans.core.java.chapter14;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int form, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            if (accounts[form] < amount) {
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[form] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, form, to);
//            Thread.sleep(5);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f\n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
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
