package com.mmall.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "music_index",type="music")
public class MusicSong {

    @Id
    private Long id;

    private String type;

    private String songExtraId;

    private String songName;

    private String artistId;

    private String artistName;

    private String albumId;

    private String albumName;

    private String songLink;

    private String length;

    private String bitRate;

    private String flacUrl;

    private String sqUrl;

    private String hqUrl;

    private String lqUrl;

    private String picUrl;

    private String lrcUrl;

    private String mvId;

    private String mvHdUrl;

    private String mvLdUrl;

    public MusicSong(Long id, String type, String songExtraId, String songName, String artistId, String artistName, String albumId, String albumName, String songLink, String length, String bitRate, String flacUrl, String sqUrl, String hqUrl, String lqUrl, String picUrl, String lrcUrl, String mvId, String mvHdUrl, String mvLdUrl) {
        this.id = id;
        this.type = type;
        this.songExtraId = songExtraId;
        this.songName = songName;
        this.artistId = artistId;
        this.artistName = artistName;
        this.albumId = albumId;
        this.albumName = albumName;
        this.songLink = songLink;
        this.length = length;
        this.bitRate = bitRate;
        this.flacUrl = flacUrl;
        this.sqUrl = sqUrl;
        this.hqUrl = hqUrl;
        this.lqUrl = lqUrl;
        this.picUrl = picUrl;
        this.lrcUrl = lrcUrl;
        this.mvId = mvId;
        this.mvHdUrl = mvHdUrl;
        this.mvLdUrl = mvLdUrl;
    }

    public MusicSong() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSongExtraId() {
        return songExtraId;
    }

    public void setSongExtraId(String songExtraId) {
        this.songExtraId = songExtraId == null ? null : songExtraId.trim();
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId == null ? null : artistId.trim();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName == null ? null : artistName.trim();
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink == null ? null : songLink.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate == null ? null : bitRate.trim();
    }

    public String getFlacUrl() {
        return flacUrl;
    }

    public void setFlacUrl(String flacUrl) {
        this.flacUrl = flacUrl == null ? null : flacUrl.trim();
    }

    public String getSqUrl() {
        return sqUrl;
    }

    public void setSqUrl(String sqUrl) {
        this.sqUrl = sqUrl == null ? null : sqUrl.trim();
    }

    public String getHqUrl() {
        return hqUrl;
    }

    public void setHqUrl(String hqUrl) {
        this.hqUrl = hqUrl == null ? null : hqUrl.trim();
    }

    public String getLqUrl() {
        return lqUrl;
    }

    public void setLqUrl(String lqUrl) {
        this.lqUrl = lqUrl == null ? null : lqUrl.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getLrcUrl() {
        return lrcUrl;
    }

    public void setLrcUrl(String lrcUrl) {
        this.lrcUrl = lrcUrl == null ? null : lrcUrl.trim();
    }

    public String getMvId() {
        return mvId;
    }

    public void setMvId(String mvId) {
        this.mvId = mvId == null ? null : mvId.trim();
    }

    public String getMvHdUrl() {
        return mvHdUrl;
    }

    public void setMvHdUrl(String mvHdUrl) {
        this.mvHdUrl = mvHdUrl == null ? null : mvHdUrl.trim();
    }

    public String getMvLdUrl() {
        return mvLdUrl;
    }

    public void setMvLdUrl(String mvLdUrl) {
        this.mvLdUrl = mvLdUrl == null ? null : mvLdUrl.trim();
    }
}