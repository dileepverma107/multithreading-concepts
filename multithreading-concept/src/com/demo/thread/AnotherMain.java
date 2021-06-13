package com.demo.thread;

public class AnotherMain {

	public static void main(String[] args) {
		DisplayDemo d=DisplayDemo.getInstance();
		ThreadClassLock t1=new ThreadClassLock(d,"Rahul");
		ThreadClassLock t2=new ThreadClassLock(d,"Rahul");
		t1.start();
		t2.start();
	}

}
