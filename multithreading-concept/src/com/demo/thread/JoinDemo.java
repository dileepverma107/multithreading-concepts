package com.demo.thread;

class MyThreadC extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			
		}
	}
}
public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThreadC t=new MyThreadC();
		t.start();
		t.join();
		
		for(int j=0;j<10;j++) {
			System.out.println(Thread.currentThread().getName()+":"+j);
		}
	}

}
