package co.kr.mono.aop.test;

import java.util.Map;
import java.util.Set;

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
	public void bean1() {
		
		// <aop:after-throwing> : 메서드가 예외를 발생시킬 떄 적용되는 어드바이스를 정의
		// try-catch 불록에서 catch 블록과 비슷
		 Person person = context.getBean(Person.class);
		 person.printThrowException();
		
		 
	}
}


