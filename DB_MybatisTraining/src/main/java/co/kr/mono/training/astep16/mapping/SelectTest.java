package co.kr.mono.training.astep16.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
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
			
			List<Album> albums = session.selectList("SelectObjectMapper1.selectArtistByPrimaryKey1", "BTS");
			
			for(Album album : albums) {
				logger.info("Artist 매핑 : {} " , album.getArtist());
				logger.info(" |- Album 매핑 : {} ", album);
			}
		}
	}
	
	//@Test
	public void selectArtistByPrimary() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			Artist artist = session.selectOne("SelectObjectMapper1.selectArtistByPrimaryKey2", "BTS");
			System.out.println(artist);
			
			logger.info("Artist 매핑 : {} {} " , artist.getMstId(), artist.getMstName());
			
			List<Album> albums = artist.getAlbum();
			
			albums.forEach(album -> logger.info(" |- Album 매핑 : {}, {}", 
					album.getAlbumTitle(), album.getOpenDate() ));
		}
	}
	
	
	//@Test
	public void selectSong() throws IOException{
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			Album album = session.selectOne("SelectObjectMapper1.selectAlbumByPrimaryKey1", "BS1");
			
			logger.info("album 매핑 : {} " , album);
			
			album.getSongs().forEach(song -> logger.info(" |- song 매핑 : {}", song));
		}
	}
	
	@Test
	public void selectMstAlbumSong() throws IOException{
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			
			Album album = session.selectOne("SelectObjectMapper1.selectAlbumByPrimaryKey2", "BS1");
			
			logger.info("album 매핑 : {} ", album);
			
			logger.info("<Musician 매핑> : {}", album.getArtist().getMstName());
			logger.info("<album 매핑> 앨범id : {} , 앨범순서 : {}, 앨범타이틀 : {}, 발매일자 : {}",
					album.getAlbumId(), 
					album.getAlbumSeq(), album.getAlbumTitle(), album.getOpenDate());
			
			album.getSongs().forEach(song -> 
			logger.info(" |- <song 매핑> 노래제목 : {} => 노래길이 : {}",  
					song.getSongName(), song.getPlayTime()));

			System.out.println("-------------------");
			album.getSongs().stream()
			.filter(song -> song.getPlayTime() > 2.0f )
			.forEach(System.out::println);
			System.out.println("-------------------");
			
				
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

