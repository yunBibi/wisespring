package co.kr.mono.training.astep15.mapping.copy;

public class Song {
	
	private String albumId;
	private Album album;
	private String songName;
	private Long playTime;
	
	public Song() {
		super();
	}
	public Song(String albumId, Album album, String songName, Long playTime) {
		super();
		this.albumId = albumId;
		this.album = album;
		this.songName = songName;
		this.playTime = playTime;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Long getPlayTime() {
		return playTime;
	}
	public void setPlayTime(Long playTime) {
		this.playTime = playTime;
	}
//	@Override
//	public String toString() {
//		return "Song [albumId=" + albumId + ", album=" + album + ", songName=" + songName + ", playTime=" + playTime
//				+ "]";
//	}
	
	

}
