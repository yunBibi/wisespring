package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;
import co.kr.mono.aop.util.Utillib;

public class SecurityAop {
	
	public void displayLine() {
		System.out.println(Utillib.lpad("*", 50, "*"));
	}
	
	public void logAfterThrowing(Exception ex){
		
		 displayLine();
		 System.out.println("### => 공통코드 실행중");
		 System.out.println("### 예외발생 : " + ex.toString());
		 displayLine();

	}
	
	public void logAfter(JoinPoint joinpoint){
		 displayLine();
		 System.out.println(" ### 날짜 : " + Utillib.currentDateTime());
		
		 System.out.println("### after 실행");
		 String signatureStr = joinpoint.getSignature().toShortString();
		 System.out.println("### : after " + signatureStr + "완료.");
		 displayLine();

	}
}
	
	
