package Yuriy_Tkach_Advanced_Java_Concurrency;

public class BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}