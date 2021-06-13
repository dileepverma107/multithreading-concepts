package com.demo.thread;


class MyThreadA extends Thread{
	 @Override
	 public void run() {
		 for(int i=0;i<10;i++) {
			 System.out.println(Thread.currentThread().getName()+" : "+i);
			 Thread.yield();
			
		 }
	 }
}

public class YieldDemo {
	public static void main(String args[]) {
		MyThreadA t1=new MyThreadA();
		
		t1.start();
		
		
		for(int j=0;j<10;j++) {
			System.out.println(Thread.currentThread().getName()+" : "+j);
		}
		
	}

}
