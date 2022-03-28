package co.kr.mono.training.astep03.select;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.mono.training.nvo.AreaSalesNVO;
import co.kr.mono.training.nvo.MsalesNVO;
import co.kr.mono.training.vo.ExamListDTO;

public class SelectAlias {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	static private SqlSessionFactory sqlSesionFactory;
	
	@BeforeClass
	public static void setUp() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSesionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void selectTestOne() throws IOException{
		try(SqlSession session = sqlSesionFactory.openSession()){
			AreaSalesNVO areaSaleVo = session.selectOne("SelectNVOMapper.findAreaSales", "10");
			
			logger.info("Sale Cnt1 : {}" , areaSaleVo);
		}
	}
	
	///@Test
	public void selectOneVO() throws IOException{
		try (SqlSession session = sqlSesionFactory.openSession()){
			MsalesNVO sale = session.selectOne("SelectBaseMapper.findMsale");
			logger.info("Sale Cnt2 : {} ",sale);
		}
	}
	
	//@Test
	public void selectTestList() throws IOException{
		try (SqlSession session = sqlSesionFactory.openSession()){
			List<MsalesNVO> sale = session.selectList("SelectBaseMapper.findMsale");
			//logger.info("Sale Cnt2 : {} ",sale);
			
			sale.forEach(r -> logger.info("데이터 : {} | {} | {}", 
					r.getProdId(),r.getProdNm(),r.getSaleCnt()));
		
		}
	}
	
	//@Test
	public void selectExamListTest() throws IOException {
		
		try(SqlSession session = sqlSesionFactory.openSession()){
			List<ExamListDTO> sale = session.selectList("SelectBaseMapper.findClass", "별림반");
			
			sale.forEach(r -> logger.info("데이터 : {} | {} | {} | {} | {}", 
					r.getName(),r.getClassName(),r.getKor(),r.getEng(),r.getMat() ));
			
		}
		
	}
	
}
