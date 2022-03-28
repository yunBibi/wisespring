package co.kr.mono.training.astep30.insert;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisInsert {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	//@Test
	public void insertMap() throws IOException{
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			// Map Insert
			Map<String, Object> param = new HashMap<>();
			
			param.put("prodid", "621");
			param.put("prodnm", "건조기6-2");
			param.put("salecnt", 621);
			
			session.insert("InsertMapper.create", param);
			session.commit();
			
			}
		}
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	

			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

