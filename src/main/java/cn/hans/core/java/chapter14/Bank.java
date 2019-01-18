package cn.hans.core.java.chapter14;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;

    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int form, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[form] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread().getName());
            accounts[form] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, form, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f\n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;

        bankLock.lock();
        try {
            for (double balance : accounts)
                sum += balance;
        } finally {
            bankLock.unlock();
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
