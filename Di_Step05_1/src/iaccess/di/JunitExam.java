package iaccess.di;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iaccess.di.entity.Hello;
import iaccess.di.ui.Printer;

public class JunitExam {
	
	static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		//IoC 컨테이너를 생성
		// 1. ApplicationContext 객체 생성
		context = new ClassPathXmlApplicationContext("iaccess/di/config.xml");
		
		System.out.println("==================");
		System.out.println("@BeforeClass : " + context);
		System.out.println("==================");
	}
	
	//@Ignore 이번에 테스트를 하지 않겠다는 것
	@Test
	public void bean1(){
		
		System.out.println("==================");
		System.out.println("Bean 객체 : " + this);
		System.out.println("컨테이너 객체 : " + context);
		
		// 2. getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		// 3. Hello의 getName() 호출
		assertEquals("SPRING", hello.getName());
		// 4. Hello의 printer() 호출
		hello.print("hello");

	}
	
	@Test
	public void bean2() {
		System.out.println("==================");
		System.out.println("Bean2 객체 : " + this);
		System.out.println("컨테이너 객체 : " + context);
		System.out.println("==================");
		
		Printer printer = (Printer)context.getBean("printer");
		
		Printer printer2 = context.getBean("printer", Printer.class);
		
		assertSame(printer, printer2);
	}
}






















