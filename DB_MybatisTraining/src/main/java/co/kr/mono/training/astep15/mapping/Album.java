package co.kr.mono.training.astep15.mapping;

import java.util.List;

public class Album {

	private String albumId;
	private Artist artist;
	private int albumSeq;
	private String albumTitle;
	private String openDate;
	private List<Song> songs;
	private String mstId;
	private String mstName;
	
	
	
	
	public String getMstId() {
		return mstId;
	}

	public void setMstId(String mstId) {
		this.mstId = mstId;
	}

	public Album() {
		super();
	}

	public Album(String albumId, Artist artist, int albumSeq, String albumTitle, String openDate, List<Song> songs) {
		super();
		this.albumId = albumId;
		this.artist = artist;
		this.albumSeq = albumSeq;
		this.albumTitle = albumTitle;
		this.openDate = openDate;
		this.songs = songs;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getAlbumSeq() {
		return albumSeq;
	}

	public void setAlbumSeq(int albumSeq) {
		this.albumSeq = albumSeq;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumSeq=" + albumSeq + ", albumTitle="
				+ albumTitle + ", openDate=" + openDate + ", songs=" + songs + "]";
	}

	public String getMstName() {
		return mstName;
	}

	public void setMstName(String mstName) {
		this.mstName = mstName;
	}
	
	
}
