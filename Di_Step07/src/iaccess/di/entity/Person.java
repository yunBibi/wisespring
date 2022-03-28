package iaccess.di.entity;

public class Person implements Comparable<Person> {
	
	// Comparable 비교 가능한 Person을 만들겠다는 뜻
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		// return this.name.comparTo(o.name)*1 ;
		/*
		 * Assert.assertThat(10,is(10)); 
		 */
		return (this.age - o.getAge())*1;
		//return (this.age - o.getAge())*-1;
	}
	
}
