package co.kr.mono.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import co.kr.mono.aop.test.AopTest;
import co.kr.mono.aop.util.Utillib;

public class SecurityAop {
	
	public void displayLine() {
		System.out.println(Utillib.lpad("*", 50, "*"));
	}
	
	// around 호출해줄 수 있는 권한을 위임
	// ProceedingJoinPoint proceed 메소드로 호출
	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable{
		
		 System.out.println(" ### 조회 : " + AopTest.loginName); 
		 System.out.println(" ### 날짜 : " + Utillib.currentDateTime());
		 displayLine();
		 
		 String signatureStr = joinpoint.getSignature().toShortString();
		 System.out.println(" ### : " + signatureStr + " 시작.");
		 
		 // 핵심 기능 시작 실행 시간 측정
		 long start = System.currentTimeMillis();
		 
		 try {
			// 핵심기능
			 Object result = joinpoint.proceed();
			 return result;
		} finally {
				
			// 핵심기능 종료 실행시간 측정
			long finish = System.currentTimeMillis();
			System.out.println(" ### : " + signatureStr + " 종료.");
			System.out.println(" ### : " + signatureStr + " 실행시간 : " + (finish - start) + "ms");
			
			//System.out.println(start);
			
		}
		
		
		
	}
	
	
}
