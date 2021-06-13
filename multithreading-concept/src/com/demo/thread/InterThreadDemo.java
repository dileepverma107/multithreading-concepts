package com.demo.thread;

class Account{
	
 float ammount=20000;
 String name;
 
 public synchronized void depositAmmount(float deposit) {
	 this.ammount+=deposit;
	 System.out.println("Ammount Deposited Successfully:");
	 System.out.println("Now Current Balance is:"+ammount);
	 notify();
 }
 
 public synchronized void  withdrawAmmount(float money) {
	 if(this.ammount<money) {
		 System.out.println("Insufficient Balance:");
		 System.out.println("Balance Ammount:"+ammount);
		 try {
			 wait();
		 }catch(InterruptedException e) {
			 e.getMessage();
		 }
	 }
	 
	 this.ammount -= money;
	 System.out.println("withdrawl Completed:"+money);
	 System.out.println("Your current Balance is:"+this.ammount);
 }
 
 
}

 class ThreadDemo2 extends Thread{
	 Account acc;
	 float deposit;
	 public ThreadDemo2(Account acc,float deposit) {
		 this.acc=acc;
		 this.deposit=deposit;
	 }
	 
	@Override 
	public void run() {
		acc.depositAmmount(deposit);
	}
}
 class ThreadDemo3 extends Thread{
	 Account acc;
	 float withdraw;
	 public ThreadDemo3(Account acc, float withdraw) {
		 this.acc=acc;
		 this.withdraw=withdraw;
	 }
	 
	@Override 
	public void run() {
		acc.withdrawAmmount(withdraw);
	}
}

public class InterThreadDemo {
	
	public static void main(String args[]) {
		Account acc=new Account();
		ThreadDemo3 t2=new ThreadDemo3(acc,23000);
		ThreadDemo2 t1=new ThreadDemo2(acc,22000);
		t2.start();
		t1.start();
		
		
	}

}
