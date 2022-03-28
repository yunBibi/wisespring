package iaccess.di.ui;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("colorPrinter")
//@Primary
public class ColorPrinter implements Printer {

	public void print(String msg) {
		System.out.println("===ColorPrinter Start===");
		System.out.println(msg);
		System.out.println("===ColorPrinter End===");
	}
}
