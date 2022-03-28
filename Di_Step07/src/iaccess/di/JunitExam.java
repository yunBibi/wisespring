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
import iaccess.di.ui.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iaccess/di/config.xml")

public class JunitExam {
	
	@Autowired
	ApplicationContext context;
	
   @Test
   public void test() {
      Hello hello = context.getBean("hello",Hello.class);
      hello.print("HELLO");
      
      /* List */
      
      List<String> list = hello.getNames();
      
      list.forEach(s -> System.out.println(s));
      
      System.out.println("---------------------");
      
      /* 확장 for */
      for (String value : list) {
    	  //nmList.accept(value);
    	  System.out.println(value);
      }
      System.out.println("------------------");
      
      /* Iterator */
      Iterator<String> lst = list.iterator();
      while (lst.hasNext()) {
    	  System.out.println(lst.next());
      }
      System.out.println("------------------");
      
      /* Map */
      
      /* enhanced for */
      Map<String, Integer> ages = hello.getAges();
      for(Map.Entry<String, Integer> entry : ages.entrySet()) {
    	  System.out.println("KEY : " + entry.getKey() + ", VALUE : " + entry.getValue());
      }
      
      // Iterator가 안돼서 set(keyset)을 통해서 iterator를 얻음
      Iterator<String> keys = ages.keySet().iterator();
      while(keys.hasNext()) {
    	  String key = keys.next();
    	  System.out.println("key : " + key + ", value : " + ages.get(key));
      }
      
      /* lamda */
      ages.forEach((key, value) -> System.out.println("key : "+ key + " | value : " + value));
      ages.entrySet().forEach(entry -> System.out.println("key : " + entry.getKey() + " | value : " + entry.getValue()));
      ages.keySet().forEach(key -> System.out.println("key : "+ key));
      ages.values().forEach(value -> System.out.println("value : " + value));
      
      System.out.println("----------------");
      
      /* Set */
      Set<String> hs = hello.getEmails();
      Iterator<String> hi = hs.iterator();
      
      /* lambda */
      hs.forEach(s -> System.out.println(s));
      
      System.out.println("-----------------------");
      
      /* 중복 제거 */
      /* Iterator */
      while (hi.hasNext()) {
    	  System.out.println(hi.next());
      }
      System.out.println("-----------------------");
      
      /* enhanced for */
      
      for(String s : hs) {
    	  System.out.println(s);
      }
      
      /* List 정렬 */
      // <Person> 정렬되기 전
      // Collections.sort(persons); <- 정렬해주는 기능 <- 이 이전에는 정렬 X, 이후에는 정렬 O
      List<Person> persons = hello.getPersons();
      
      System.out.println("---------- person name sort before --------");
      
      persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));
      
      Collections.sort(persons);
      
      System.out.println("---------- person name sort after ----------");
      
      persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));
      
      // persons.forEach(row -> System.out.println(row.getName());
      
      System.out.println("---------------------");
      

	}
}






















