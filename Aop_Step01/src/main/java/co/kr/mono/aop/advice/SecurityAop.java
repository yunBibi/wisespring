package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;

import co.kr.mono.aop.test.AopTest;
import co.kr.mono.aop.util.Utillib;

public class SecurityAop {
	
	public void displayLine() {
		System.out.println(Utillib.lpad("*", 50, "*"));
	}
	
	public void logBefore(JoinPoint jointPoint) {
		String signatureString = jointPoint.getSignature().getName();
		displayLine();
		
		System.out.println("### 조회 : " + AopTest.loginName); // class 변수
		System.out.println("### 날짜 : " + Utillib.currentDateTime());
		System.out.println("### Before [" + jointPoint + "] 메서드 실행 전처리 수행");
		
		for(Object arg : jointPoint.getArgs()) {
			System.out.println("Before [" + jointPoint + "] 아규먼트 : " + arg);
		}
		
		displayLine();
	}
	
}
