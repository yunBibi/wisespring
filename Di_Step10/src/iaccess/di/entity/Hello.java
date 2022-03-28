package iaccess.di.entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import iaccess.di.ui.Printer;

public class Hello {
	
	@Autowired  // 타입을 보고 인젝션해준다. 
	//@Qualifier("monoPrinter") 
	//@Resource(name="colorPrinter")   //이름을 인젝션 받는다. 
	private Printer printer;
	String name;
	
	public Hello() {
		System.out.println("default 생성자");
	}
	
	// 생성자에 인젝션
	//@Autowired
	public Hello(Printer printer) {
		System.out.println("생성자 인젝션");
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}
	
	// setter 인젝션
	// @Autowired
	public void setPrinter(Printer printer) {
		System.out.println("Setter Method Printer Inject");
		this.printer = printer;
	}

	// 아무 메소드나 인젝션
	// @Autowired
	public void xxxMalPrinter(Printer printer) {
		System.out.println("특정 메소드 인젝션");
		this.printer = printer;
	}

	public void print(String s) {
		printer.print(s);
	}
}
