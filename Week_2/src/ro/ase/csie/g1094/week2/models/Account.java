package ro.ase.csie.g1094.week2.models;

public abstract class Account {
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract Object getBalance();
	public abstract void transfer(Account destination, Double amount);
}
