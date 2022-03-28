package iaccess.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iaccess.di.entity.Hello;
import iaccess.di.ui.ColorPrinter;
import iaccess.di.ui.MonoPrinter;

@Configuration
public class Iass_di_config {
	
	// <bean id = hello />
	@Bean
	public Hello hello() {
		// colorPrinter 가 4개 만들어지는게 아님
		//new Hello(colorPrinter());
		//new Hello(colorPrinter());
		//new Hello(colorPrinter());
		
		// return new Hello();     autowired 방식
		return new Hello(colorPrinter());    // 생성자 방식
	}

	@Bean
	//@Primary
	private ColorPrinter colorPrinter() {
		return new ColorPrinter();
	}
	
	@Bean
	private MonoPrinter monoPrinter() {
		return new MonoPrinter();
	}
}
