package com.kk.hibernate.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String songName;
	
	@Column(name = "artist")
	private String lyricist;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", lyricist=" + lyricist + "]";
	}

}
