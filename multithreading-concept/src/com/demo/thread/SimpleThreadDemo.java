package com.demo.thread;

class DemoOject {
	

	public synchronized void  displayChildThread(String name) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread:::"+name );
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

class MyThread extends Thread {
	DemoOject demoObject;
	String name;
	
	public MyThread(DemoOject demoObject,String name) {
		this.demoObject=demoObject;
		this.name=name;
	}
	
	@Override
	 public void run() {
		demoObject.displayChildThread(name);

	}
}

public class SimpleThreadDemo {
	public static void main(String args[]) {
		DemoOject demoObj=new DemoOject();
		MyThread t1 = new MyThread(demoObj,"Dileep");
		MyThread t2 = new MyThread(demoObj,"Rahul");
		t1.setPriority(9);
		t2.setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread: " + Thread.currentThread().getName());
		}

	}

}
