package iaccess.di.ui;

public class ColorPrinter implements Printer {

	public void print(String msg) {
		System.out.println("===ColorPrinter Start===");
		System.out.println(msg);
		System.out.println("===ColorPrinter End===");
	}
}
