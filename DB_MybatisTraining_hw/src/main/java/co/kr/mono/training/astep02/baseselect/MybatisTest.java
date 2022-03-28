package co.kr.mono.training.astep02.baseselect;

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

import co.kr.mono.training.vo.RankVO;

public class MybatisTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	static private SqlSessionFactory sqlSesionFactory;
	
	@BeforeClass
	public static void setUp() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSesionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void selectRank() throws IOException {
		
		try(SqlSession session = sqlSesionFactory.openSession()){
			List<RankVO> rank = session.selectList("SelectBaseMapper.findRank");
			
			rank.forEach(r -> logger.info("데이터 : {} | {} | {} | {} | {} | {} | {} | {}", 
					r.getName(), r.getD_rank(), r.getClass(),r.getKor(),r.getEng(),r.getMat(),r.getTot(),r.getLag_cha()));
			
		}
		
	}
	
	
	
	
}












