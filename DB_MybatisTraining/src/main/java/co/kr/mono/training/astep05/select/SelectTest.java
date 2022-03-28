package co.kr.mono.training.astep05.select;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SelectTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	static private SqlSessionFactory sqlSesionFactory;
	
	@BeforeClass
	public static void setUp() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSesionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//@Ignore
	//@Test
	public void selectMapCnt() throws IOException{
		try(SqlSession session = sqlSesionFactory.openSession()){
			
			int saleCnt = session.selectOne("SelectDepRtypeMapper.examCount");
			logger.info("출력 건수 : {} ", saleCnt );
		}
	}
	
	//@Test
	public void selectMapDate() throws IOException{
		
		try (SqlSession session = sqlSesionFactory.openSession()){
			
			Date saleDate = session.selectOne("SelectDepRtypeMapper.examDate");
			logger.info("java.uti.Date를 이용한 현재 시간 org:{} ", saleDate);
			logger.info("ms total{} ", saleDate.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String decodeSdf = sdf.format(saleDate);
			logger.info("SimpleDateFormat 을 이용한 현재 시간 convert : {} ", decodeSdf);
			
			
		}
	}
	
	@Test
	public void selectLocalDate() throws IOException {
		try(SqlSession session = sqlSesionFactory.openSession()){
			
			Date saleDate = session.selectOne("SelectDepRtypeMapper.examDate");
			
			logger.info("java.uti.Date를 이용한 현재 시간 org:{} ", saleDate);
			
			java.time.LocalDateTime localDateTime = convertLocalDateTime(saleDate);
			
			logger.info("java.time.LocalDateTime를 이용한 현재 시간 convert : {} ", localDateTime);
		}
	}
	
	
	public static java.time.LocalDateTime convertLocalDateTime(Date date){
		java.time.LocalDateTime localDateTime = date.toInstant() // Date -> Instant
				.atZone(ZoneId.systemDefault()) // Instant -> ZonedDateTime
				.toLocalDateTime();  // ZonedDateTime -> LocalDateTime
		
		return localDateTime;
	}

}

