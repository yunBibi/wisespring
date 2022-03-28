package iaccess.di.ui;

public class AopPrinter implements Printer {
	
	private Printer printer;
	
	
	public AopPrinter(Printer printer) {
		super();
		this.printer = printer;
	}



	public void print(String s) {
		System.out.println("=== 실행 전 적용사항 ===");
		printer.print(s);
		System.out.println("=== 실행 후 적용사항 ===");
	}
}
