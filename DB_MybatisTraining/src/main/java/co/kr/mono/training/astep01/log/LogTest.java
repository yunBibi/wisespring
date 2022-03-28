package co.kr.mono.training.astep01.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	static Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		logger.info("로그메세지 : {}", "Hello world");
		
		int result = sum(2,2);
		System.out.println("2 + 2 =" + result);
		logger.info("로그메세지 : {}, {} ", result, result+10);
	}
	static int sum(int a, int b) {
		return a + b ;
	}
}
