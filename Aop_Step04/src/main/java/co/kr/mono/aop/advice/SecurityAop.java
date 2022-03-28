package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;
import co.kr.mono.aop.util.Utillib;

public class SecurityAop {
	
	public void displayLine() {
		System.out.println(Utillib.lpad("*", 50, "*"));
	}
	
	public void logAfterThrowing(JoinPoint joinpoint, Exception ex){
		
		 displayLine();
		 System.out.println(" ### 날짜 : " + Utillib.currentDateTime());
		 
		 String signatureStr = joinpoint.getSignature().toShortString();
		 System.out.println("### : " + signatureStr + "실행");
		 System.out.println("### => 공통코드 실행중");
		 System.out.println("### 예외발생 : " + ex.toString());
		 displayLine();

	}
}
	
	
