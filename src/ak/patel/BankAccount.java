package ak.patel;

public class BankAccount {

	private double balance;
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposite(double amount) {
		synchronized (lock1) {
			System.out.println("money deposite: " + amount);
		synchronized (lock2) {
		System.out.println("thread accuring lock2 for deposite:");	
		balance+=amount;
		}
		}
	}

	public void withdraw(double amount) {
		synchronized (lock2) {
			System.out.println("money withdraw: " + amount);
		synchronized (lock1) {
		System.out.println("thread accuring lock 1 for withdraw");	
		if(balance>=amount) {
			balance-=amount;
		}
		else {
			System.out.println("insufficient balance");
		}
		}
		}
	}

}
