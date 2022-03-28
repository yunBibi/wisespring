package iaccess.di.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import iaccess.di.ui.Printer;

@Component("hello")
public class Hello {
	
	@Autowired
	@Qualifier("monoPrinter") 

	private Printer printer;
	String name;
	
	public Hello() {
		System.out.println("default 생성자");
	}
	
	public Hello(Printer printer) {
		System.out.println("생성자 인젝션");
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}
	
	public void setPrinter(Printer printer) {
		System.out.println("Setter Method Printer Inject");
		this.printer = printer;
	}

	public void xxxMalPrinter(Printer printer) {
		System.out.println("특정 메소드 인젝션");
		this.printer = printer;
	}

	public void print(String s) {
		printer.print(s);
	}
}
