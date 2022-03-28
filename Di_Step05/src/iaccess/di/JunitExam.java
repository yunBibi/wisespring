package iaccess.di;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iaccess.di.entity.Hello;
import iaccess.di.ui.Printer;

public class JunitExam {
	
	// jUnit 
	// Spring에서는 왜 이렇게 테스트를 할까?
	// 각각의 단위테스트들은 서로 독립적이어야 하기 때문에 서로 모듈 간에 관계가 안 되도록 프로그래밍 하는 것
	
	// 어노테이션 설정 정보
	// 단정(assert) 메서드로테스트 케이스의 수행 결과를 판별한다. assert = 판정
	// 판정의 요소 1. 예상한 값 2. 실제 값
	
	// 어노테이션 5개
	// @BeforeClass : 딱 1번 수행
	// @Before : 모든 테스트에 적용 (테스트 개수만큼 적용)
	// @Test 
	// @After : 모든 테스트에 적용
	// @AfterClass : 끝날 때 1번 적용
	
	// assertj : chain 패턴을 사용하여 직관적으로 활용이 가능한 라이브러리
	
	ApplicationContext context;
	
	@Before
	public void init() {
		//IoC 컨테이너를 생성
		// 1. ApplicationContext 객체 생성
		context = new ClassPathXmlApplicationContext("iaccess/di/config.xml");
		System.out.println("==================");
		System.out.println("컨테이너생성");
		System.out.println("Before 객체 : " + this);
		System.out.println("컨테이너 객체 : " + context);
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
		assertEquals("SPRING", hello.getName());    // this~ 이런거 사용 안 하는 이유 <= static이라서
		
		
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






















