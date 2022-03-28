package iaccess.di.ui;

import org.springframework.stereotype.Component;

@Component("monoPrinter")
public class MonoPrinter implements Printer {
	
	public void print(String msg) {
		System.out.println("===MonoPrinter Start===");
		System.out.println(msg);
		System.out.println("===MonoPrinter End===");
	}
}
