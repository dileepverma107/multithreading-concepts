package com.demo.thread;

class DisplayDemo{
	
	private static DisplayDemo d;
	private DisplayDemo() {}
	static int counter=0;
	public static DisplayDemo getInstance() {
		if(d==null) {
			counter++;
			d=new DisplayDemo();
					}
		return d;
	}
	
	public static synchronized void displayWish(String name) {
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+name);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
	
	public static synchronized void displayWish2(String name) {
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+name);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
	
	public static void displayWish3(String name) {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+"Good Morning");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
	
}
class ThreadClassLock extends Thread{
	DisplayDemo d;
	String name;
	public ThreadClassLock(DisplayDemo d,String name) {
		this.d=d;
		this.name=name;
		
	}
	@Override
	public void run() {
		d.displayWish3(name);
		d.displayWish2(name);
		d.displayWish(name);
	}
}
public class ClassLevelLock {
	
	public static void main(String args[]) {
		DisplayDemo d=DisplayDemo.getInstance();
		System.out.println(d.counter);
		DisplayDemo d2=DisplayDemo.getInstance();
		System.out.println(d.counter);
		ThreadClassLock t1=new ThreadClassLock(d,"Dileep");
		ThreadClassLock t2=new ThreadClassLock(d,"Ankit");
		t1.start();
		t2.start();
		
		
	}

}
