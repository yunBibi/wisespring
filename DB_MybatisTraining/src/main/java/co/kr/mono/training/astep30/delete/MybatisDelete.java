package co.kr.mono.training.astep30.delete;

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


public class MybatisDelete {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void delete() throws IOException{

			try(SqlSession session = sqlSessionFactory.openSession()){
				
				int cnt = session.delete("DeleteMapper.deleteSales", "621");
				logger.info("delete : {} ",cnt);   // 삭제되는 건수가 리턴된다.
				session.commit();
			}
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

