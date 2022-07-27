package Yuriy_Tkach_Advanced_Java_Concurrency;

public class BankAccount {

    public int getBalance() {
        return balance;
    }

    private int balance;

    public String getName() {
        return name;
    }

    private String name;

    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}