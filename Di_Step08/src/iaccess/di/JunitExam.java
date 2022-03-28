package iaccess.di;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import iaccess.di.entity.Hello;
import iaccess.di.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iaccess/di/config.xml")

public class JunitExam {
	
	@Autowired
	ApplicationContext context;
	
   @Test
   public void test() {
      Hello hello = context.getBean(Hello.class);

      List<Person> persons = hello.getPersons();
      
      System.out.println("---------- before sort --------");
      
      persons.forEach(p -> hello.print(p.getName() + " | " + p.getAge() + " | " ));
      
      // 이름으로 정렬
      Collections.sort(persons);
      
      System.out.println("---------- after sort ----------");
      
      System.out.println("\n ===== after Sort =====");
      persons.forEach(p -> hello.print(p.getName() + " | " + p.getAge() + " | "));

	}
}






















