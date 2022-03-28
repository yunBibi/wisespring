package iaccess.di.entity;

import iaccess.di.ui.Printer;

public class Hello {
	private Printer printer;
	private String name = "";
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Hello() {

	};
	
	public Hello(Printer printer, String name) {
		System.out.println("constructor 2 parameter ");
		this.printer = printer;
		this.name = name;
	}
	
	public Hello(Printer printer) {
		System.out.println("constructor 1 parameter");
		this.printer = printer;
	}
	
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
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
