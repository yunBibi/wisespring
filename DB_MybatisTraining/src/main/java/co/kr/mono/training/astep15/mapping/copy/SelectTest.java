package co.kr.mono.training.astep15.mapping.copy;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	//@Test
	public void selectArtist() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			Artist artist = session.selectOne("SelectObjectMapper.selectArtistByPrimaryKey", "BTS");
			
			logger.info("Artist 매핑 : {}", artist);
		}
	}
	
	//@Test
	public void selectAlbum() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			Album album = session.selectOne("SelectObjectMapper.selectAlbumByPrimaryKey", "BS1");
			
			logger.info("Artist 매핑 : {} " , album.getArtist());
			
			logger.info("album 매핑 : {} ", album);
			for(Song song : album.getSongs()) {
				logger.info("  |- song 매핑 : {} ", song);
			}
		}
	}
	
	
	//@Test
	public void selectSong() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			List<Song> songList = session.selectList("SelectObjectMapper.selectSongByAlbumKey", "BS1");
			
			logger.info("Song 매핑 : {} " , songList);
			
				songList.forEach(s -> {
					logger.info("song 매핑 : {}" , s);
					logger.info("  |- Album 매핑 : {} ", s.getAlbum());
				});
			
		}
	}
	
	//@Test
	public void selectAlbums() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			List<Album> albumList = session.selectList("SelectObjectMapper.selectAlbumByArtistKey", "BTS");			
			
				
			
				albumList.forEach(s -> {
					logger.info("  |-  {} | {} ", s.getMstId(), s.getAlbumTitle());
				});
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

