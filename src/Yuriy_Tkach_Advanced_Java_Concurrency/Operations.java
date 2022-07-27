package Yuriy_Tkach_Advanced_Java_Concurrency;

public class Operations {
    public static void main(String[] args) {
        final BankAccount a = new BankAccount("a",1000);
        final BankAccount b = new BankAccount("b",2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(a, b, 500);
            }
        }).start();

        transfer(b, a, 300);

    }

    public static void transfer(BankAccount from, BankAccount to, int amount){
        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Not enough money!");
        }
        System.out.println(String.format("Transfer from %s to %s started", from.getName(), to.getName()));
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(String.format("Transfer from %s to %s finished. Transferred %d$", from.getName(), to.getName(), amount));
    }

}
