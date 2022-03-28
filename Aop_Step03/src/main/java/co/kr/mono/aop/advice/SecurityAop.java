package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;

import co.kr.mono.aop.test.AopTest;
import co.kr.mono.aop.util.Utillib;

public class SecurityAop {
	
	public void displayLine() {
		System.out.println(Utillib.lpad("*", 50, "*"));
	}
	
	public void logAfterReturning(JoinPoint joinpoint, Object retVal){
		
		 displayLine();
		 System.out.println(" ### 조회 : " + AopTest.loginName); 
		 System.out.println(" ### 날짜 : " + Utillib.currentDateTime());
		 displayLine();
		 
		 String signatureStr = joinpoint.getSignature().toShortString();
		 System.out.println("After Returning 내부 결과 출력");
		 System.out.println("### : " + signatureStr + "\n### : 실행 결과 [" + retVal + "]");

	}

}
	
	
