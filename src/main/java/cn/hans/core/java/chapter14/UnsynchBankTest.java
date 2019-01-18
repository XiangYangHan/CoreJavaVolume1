package cn.hans.core.java.chapter14;

public class UnsynchBankTest {

    private static final int ACCOUNT_NUMBER = 100;
    private static final double INITIAL_BALANCE = 100;
    private static final double MAX_AMOUNT = 100;
    private static final int DELAY = 100;

    public static void main(String[] args) {
        Bank bank = new Bank(ACCOUNT_NUMBER, INITIAL_BALANCE);

        for (int i = 0; i < bank.size(); i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        int from = (int) (bank.size() * Math.random());
                        int to = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(from, to, amount);
                        Thread.sleep((long) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
