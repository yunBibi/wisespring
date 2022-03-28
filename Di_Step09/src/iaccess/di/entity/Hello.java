package iaccess.di.entity;

import org.springframework.beans.factory.annotation.Autowired;

import iaccess.di.ui.Printer;

public class Hello {
	
//	Autowired 어노테이션 붙일 수 있는 곳
//	1. 아무 메소드
//	2. 세터
//	3. 생성자
//	4. 필드
	
	// 필드에 바로 인젝션
	//@Autowired
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
	@Autowired
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
