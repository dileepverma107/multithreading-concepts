package com.demo.thread;

class Display {
	public synchronized void wish() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + "Good Morning");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	public void wish2() {
		for (int j = 0; j < 3; j++) {
			System.out.println(Thread.currentThread().getName() + ":" + "Good Night");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class DemoThread extends Thread {
	Display d;

	public DemoThread(Display d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.wish2();
		d.wish();

	}

}

public class ObjectLockDemo {
	public static void main(String args[]) {
		Display d = new Display();
		DemoThread t1 = new DemoThread(d);
		DemoThread t2 = new DemoThread(d);
		t1.start();
		t2.start();

	}

}
