package iaccess.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import iaccess.di.entity.Hello;

public class DiExam {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// GenericXmlApplicationContext class : XML 파일로부터 정보를 읽어와 객체를 생성하고 초기화 
		ApplicationContext ctx =
				new GenericXmlApplicationContext("iaccess/di/test/config.xml");
		
		
		// 3가지 방식 중 하나로 꺼내 씀
		
		// Hello hello = (Hello)ctx.getBean("hello");
		Hello hello = ctx.getBean(Hello.class);
		// Hello hello = ctx.getBean("hello", Hello.class);
		
		hello.print("korea");
		
		// System.out.println(ctx.getBeanDefinitionCount());
		
		String [] str = ctx.getBeanDefinitionNames() ;
		
		for(String val : str) {
			System.out.println(val);
		}
	}
}
