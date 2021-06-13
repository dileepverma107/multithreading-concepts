package com.demo.thread;

class BlockDemo {

	public void display() {
		System.out.println("Before Synchronized Block");

		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+":"+"Child thread");
			}
		}
		System.out.println("After Synchronized Block");
	}
}

class ThreadDemo extends Thread{
	BlockDemo d;
	public ThreadDemo(BlockDemo d) {
		this.d=d;
	}
	@Override
	public void run() {
		d.display();
	}
}

public class SynchronizedBlock {
  public static void main(String args[]) {
	  BlockDemo d=new BlockDemo();
	  ThreadDemo t=new ThreadDemo(d);
	  ThreadDemo t2=new ThreadDemo(d);
	  t.start();
	  t2.start();
	  
	  synchronized(d) {
		  for(int j=0;j<10;j++) {
			  System.out.println(Thread.currentThread().getName()+": Main Thread");
		  }
	  }
	  
  }
}
