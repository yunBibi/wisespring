package iaccess.di.entity;

import iaccess.di.ui.Printer;

public class Hello {
	private Printer printer;
	private String name = "";
	
	public Hello() {

	};
	
	public Printer getPrinter() {
		return printer;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		System.out.println("Injection => setName(String name)");
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		
		System.out.println("Injection => setPrinter(Printer printer)");
		this.printer = printer;
	}
	
	public Hello(Printer printer, String name) {
		System.out.println("constructor 2 parameter ");
		this.printer = printer;
		this.name = name;
	}
	
	public Hello(Printer printer) {
		System.out.println("constructoer 1 parameter");
		this.printer = printer;
	}
	
	@Override
	public String toString() {
		return "Hello [printer=" + printer + "]";
	}
	
	public void print(String s) {
		
		if(this.name == null)
			printer.print(s);
		else
			printer.print(this.name + " " + s);
	}
}
