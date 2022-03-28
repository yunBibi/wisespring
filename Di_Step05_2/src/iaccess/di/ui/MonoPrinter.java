package iaccess.di.ui;

public class MonoPrinter implements Printer {
	
	public void print(String msg) {
		System.out.println("===MonoPrinter Start===");
		System.out.println(msg);
		System.out.println("===MonoPrinter End===");
	}
}
