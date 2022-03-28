package com.mono.aop;

import iaccess.di.ui.AopPrinter;
import iaccess.di.ui.ColorPrinter;
import iaccess.di.ui.Printer;

public class AopTest {

	public static void main(String[] args) {
		
		Printer printer = new ColorPrinter();
		printer.print("Hello");
		
		System.out.println("====================");
		
		Printer aopPrinter = new AopPrinter(new ColorPrinter());
		aopPrinter.print("Hello");

	}
}
