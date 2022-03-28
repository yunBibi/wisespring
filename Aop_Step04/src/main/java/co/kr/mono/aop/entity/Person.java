package co.kr.mono.aop.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.kr.mono.aop.ui.Printer;

public class Person {
	
	String name;
	String major;
	List<ExamScore> examList;
	private Printer printer;
		
	public Person() {

	}

	public Person(String name, String major, List<ExamScore> examList, Printer printer) {
		super();
		this.name = name;
		this.major = major;
		this.examList = examList;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public List<ExamScore> getExamList() {
		return examList;
	}


	public void setExamList(List<ExamScore> examList) {
		this.examList = examList;
	}


	public Printer getPrinter() {
		return printer;
	}


	public void setPrinter(Printer printer) {
		this.printer = printer;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", major=" + major + ", examList=" + examList + ", printer=" + printer + "]";
	
	}
	
	public void print() {
		
		String str = "Person [name=" + name + ", major=" + major + ", examList=" + examList + ", printer=" + printer + "]";
		
		printer.print(str);
	}
	
	public Map<String, Float> getTot(){
		
		List<ExamScore> exams = this.getExamList();
		Map<String, Float> gradeAvg = new HashMap<>();
		
		for(ExamScore exam : exams) {
			Float avg = (float) (exam.getKor() + exam.getEng() + exam.getMat()) / 3;
			gradeAvg.put(exam.getGrade(), avg);
		}
		System.out.println("===> getTot 내부 진행 : " + gradeAvg);
		return gradeAvg;
	}
	
	public Map<String, Float> getTot(String grade){
		
		List<ExamScore> exams = this.getExamList();
		Map<String, Float> gradeAvg = new HashMap<>();
		
		for(ExamScore exam : exams) {
			if(exam.getGrade().equals(grade)) {
				Float avg = (float) (exam.getKor() + exam.getEng() + exam.getMat()) / 3;
				gradeAvg.put(exam.getGrade(), avg);
			}
		}
		System.out.println("===> getTot(인자) 내부 진행 : " + gradeAvg);
		return gradeAvg;
	}
	
	// return으로 넘겨주는게 아니라 JVM이 받아서 호출했던 쪽으로 넘겨준다. 
	public void printThrowException() {
		System.out.println(" => 핵심코드 실행 중 ");
		throw new IllegalArgumentException(" => 고의로 발생시켰음 ");
	}
	

}






















