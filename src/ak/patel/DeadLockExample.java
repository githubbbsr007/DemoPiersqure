package ak.patel;

public class DeadLockExample {
public static void main(String[] args) {
	BankAccount account= new BankAccount(1000);
	
	Thread t1=new Thread(new Runnable() {
		@Override
		public void run() {
			account.deposite(700);
			
		}		
	});
	
	Thread t2=new Thread(new Runnable() {
		@Override
		public void run() {
			account.withdraw(500);
			
		}		
	});
	t1.start();
	t2.start();
}
}
