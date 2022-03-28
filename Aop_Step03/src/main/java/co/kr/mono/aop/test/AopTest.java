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
		// <aop:after-returning> : 메서드가 정상적으로 실행된 후에 적용되는 어드바이스를 정의
		 Person person = context.getBean(Person.class);
		 
		 // 별표 개수가 파라미터 개수
		 
		 //Map<String , Float> map = person.getTot();
		 Map<String , Float> map = person.getTot("1"); // 파라미터 1개 적용
		 
		 //Set<Map.Entry<String, Float>> entries = person.getTot().entrySet(); // 파라미터 0개 
		 System.out.println("Clietn Test 결과 출력");
		 //System.out.println(entries);
		 
		 for(Map.Entry<String, Float> entry : map.entrySet()) {
			 System.out.println("학년 : " + entry.getKey());
			 System.out.println(", 평균 " + String.format("%.1f", entry.getValue()));
		 }
	}
}


