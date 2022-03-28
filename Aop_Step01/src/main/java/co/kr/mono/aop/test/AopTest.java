package co.kr.mono.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.mono.aop.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/kr/mono/aop/test/config.xml")
public class AopTest {

	@Autowired
	ApplicationContext context;
	public static String loginName="강감찬";
	
	@Test
	//@Ignore
	public void bean1() {
		 // <aop:before>
		
		// 2. getBean 호출
		Person person = context.getBean(Person.class);
		person.print();
		
		System.out.println("================");
		
		String [] names = context.getBeanDefinitionNames();
		
		for(String name : names) {
			System.out.println(name);
		}
	}

}
