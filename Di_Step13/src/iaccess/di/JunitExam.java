package iaccess.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import iaccess.di.entity.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iaccess/di/config.xml")

public class JunitExam {
	
	@Autowired
	ApplicationContext context;
	
   @Test
   public void bean1() {
	   
	   // @Autowired(required=false) 테스트
      Hello hello = (Hello)context.getBean("hello");
      
      hello.print("hello"); // nullPointerException
      
      String [] beanNames = context.getBeanDefinitionNames();
      
      for(String name : beanNames) {
    	  System.out.println(name);
      }
      
	}
}






















