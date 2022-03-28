package iaccess.di.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import iaccess.di.ui.Printer;

public class Hello {
	private Printer printer;
	private List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Printer getPrinter() {
		return printer;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public Hello(Printer printer, List<Person> persons) {
		super();
		this.printer = printer;
		this.persons = persons;
	}

	public Hello() {
		
	}

	public void print(String s) {
		printer.print(s);
	}
	
}
