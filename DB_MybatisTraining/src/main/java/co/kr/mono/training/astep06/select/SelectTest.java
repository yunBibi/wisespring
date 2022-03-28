package co.kr.mono.training.astep06.select;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.mono.training.nvo.DateMappingDTO;
import co.kr.mono.training.vo.SimpleVO;

public class SelectTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	// @Ignore
	// @Test
	public void timeConvert() {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + sqlDate);
		System.out.println(utilDate.getTime()); // java.util.Date msec // 1648014210325/(24*60*60*1000) + 9/24
		System.out.println(sqlDate.getTime()); // java.sql.Date msec // epoch time : 1970년 1월 1일부터 현재까지 누적되어 오는 시간 ( + /
												// - )
	}

	// @Ignore
	// @Test
	public void selectMapDate() throws IOException {

		try (SqlSession session = sqlSessionFactory.openSession()) {

			SimpleVO saleDate = session.selectOne("SelectCdataMapper.examDate");
			System.out.println("현재시간 | db to_char(sysdate) =>String : " + saleDate.getCurrentStrDate());
			System.out.println("현재시간 | db sysdate => java.util.Date 매핑 :" + saleDate.getUtilCurrentDate());
			System.out.println("현재시간 | db sysdate => java.sql.Date 매핑 (시분초 x):" + saleDate.getSqlCurrentDate());
			System.out.println("현재시간 | db sysdate => java.sql.TimeStamp 매핑 :" + saleDate.getSqlCurrentTimeStamp());
			System.out.println("현재시간 | db timestamp => java.sql.TimeStamp 매핑 :" + saleDate.getSqlDbCurrentTimeStamp());

			java.sql.Timestamp cvtSaleDate = new java.sql.Timestamp(saleDate.getUtilCurrentDate().getTime());
			// java.sql.Timestamp cvtSaleDate = new java.sql.Timestamp(1626146846000L);
			System.out.println("util.date => sql.date : " + cvtSaleDate);

			cvtSaleDate = new java.sql.Timestamp(
					saleDate.getUtilCurrentDate().getTime() + (long) (1000 * 60 * 60 * 24) * 3);
			System.out.println("util.date 다음날 => sql.date : " + cvtSaleDate);
			System.out.println(saleDate.getUtilCurrentDate().getTime());
		}
	}

	
	@Test
	public void selectLocalDateMapping() throws IOException {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			DateMappingDTO date = session.selectOne("SelectCdataMapper.localDateMapping");
			logger.info("LocalDateTime : {}",date.getLocalDateTime());
			System.out.println(date.getSqlTimeStamp());
		}
	}
}
