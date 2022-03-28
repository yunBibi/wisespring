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
		// String은 Compare가 이미 구현되어있기 때문에 compare to 메소드를 바로 사용할 수 있다. 
		return this.name.compareTo(o.name)*-1;

	}
	
}
