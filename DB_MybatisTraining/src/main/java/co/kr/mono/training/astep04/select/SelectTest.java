package co.kr.mono.training.astep04.select;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.mono.training.vo.MsalesVO;

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
	/* resultType="map" */
	public void selectMapTest() throws IOException{
		try(SqlSession session = sqlSesionFactory.openSession()){
			
			List<Map<String, Object>> sale = session.selectList("SelectVOMapper.findMsaleMap");
			
			sale.forEach(row -> {
				logger.info("------------");
				row.forEach((key,val) -> {
					logger.info("* {} : {} ", key, val);
				});
			});
			logger.info("--------------");
		}
	}
	
	//@Test
	public void selectOneParm() throws IOException{
		
		try (SqlSession session = sqlSesionFactory.openSession()){
			
			List<MsalesVO> sale = session.selectList("SelectVOMapper.findMsale","200");
			
			sale.forEach(row -> {
				logger.info("------------");
				logger.info("Data : {} | {} | {} ", row.getProdId(), row.getProdNm(),
					row.getSaleCnt());
			logger.info("--------------");
			});
		}
	}
	
	
	
	//@Test
	public void selectMultiParm() throws IOException{
		
		MsalesVO msale = new MsalesVO("10", "세탁기", ' ');
		
		try (SqlSession session = sqlSesionFactory.openSession()){
			
			List<MsalesVO> sale = session.selectList("SelectVOMapper.findMsaleByMultiParm", msale);
			//logger.info("Sale Cnt2 : {} ",sale);
			
			sale.forEach(row -> {
				logger.info("---------------------");
				logger.info("Data : {} | {} | {} ", row.getProdId(), row.getProdNm(),row.getSaleCnt());
				logger.info("---------------------");
			});
		
		}
	}
	
	@Test
	public void selectMultiParmMap() throws IOException {
		
		Map<String, Object> param = new HashMap<>();
		param.put("prodId", "10");
		param.put("prodNm", "세탁기");
		
		try (SqlSession session = sqlSesionFactory.openSession()){
			
			List<MsalesVO> sale = session.selectList("SelectVOMapper.findMsaleByMultiParm", param);
			//logger.info("Sale Cnt2 : {} ",sale);
			
			sale.forEach(row -> {
				logger.info("---------------------");
				logger.info("Data : {} | {} | {} ", row.getProdId(), row.getProdNm(),row.getSaleCnt());
				logger.info("---------------------");
			});
		
		}
	}
}

