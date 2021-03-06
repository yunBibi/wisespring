package co.kr.mono.training.astep30.update;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisUpdate {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void updateMap() throws IOException{

			Map<String, Object> param = new HashMap<>();
			
			param.put("prodid", "621");
			param.put("prodnm", "파주1");
			param.put("salecnt", 622);
			
			try(SqlSession session = sqlSessionFactory.openSession()){
				
				int updateCnt = session.update("UpdateMapper.updateSales", param);
				session.commit();
				logger.info("update 건수 : {} ",updateCnt);
			}
			// UPDATE된 건 수가 리턴되어 온다. 
			
			
		}


}
	
	
	
	
	
	
	
	
	
	
	
	
	

			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

