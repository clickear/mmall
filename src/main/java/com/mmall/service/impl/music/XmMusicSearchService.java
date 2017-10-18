package com.mmall.service.impl.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mmall.pojo.MusicSong;
import com.mmall.pojo.music.xm.XiamiDatas;
import com.mmall.pojo.music.xm.XiamiIds;
import com.mmall.service.IMusicSearchService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfreet on 2017/2/8.
 */
public class XmMusicSearchService implements IMusicSearchService {
    //虾米不支持mv和无损解析
    private static List<MusicSong> search(String key, int page, int size) throws Exception {
        String url = "http://api.xiami.com/web?v=2.0&app_key=1&key=" + key + "&page=" + page + "&limit=" + size + "&r=search/songs";
        String s = NetUtil.GetHtmlWithRefer(url, "http://m.xiami.com");
        if (s.isEmpty()) {
            return null;  //搜索歌曲失败
        }
        XiamiDatas xiamiDatas = JSON.parseObject(s, XiamiDatas.class);
        if (xiamiDatas == null) {
            return null;//没有找到符合的歌曲
        }
        return GetListByJson(xiamiDatas.getData().getSongs());

    }

    private static List<MusicSong> GetListByJson(List<XiamiDatas.DataBean.SongsBean> songs) throws Exception {
        List<MusicSong> list = new ArrayList<>();
        int len = songs.size();
        if (len <= 0) {
            return null;
        }
        for(XiamiDatas.DataBean.SongsBean songsBean:songs){
            String SongId = String.valueOf(songsBean.getSong_id());
            MusicSong MusicSong = SearchSong(SongId);
            if (MusicSong != null) {
                list.add(MusicSong);
            }
        }
        return list;
    }

    private static MusicSong GetResultsByIds(String ids, int type) {
        String albumUrl = "http://www.xiami.com/song/playlist/id/" + ids + "/type/" + type + "/cat/json";
        String html = NetUtil.GetHtmlContent(albumUrl);
        if (html.isEmpty() || html.contains("应版权方要求，没有歌曲可以播放")) {
            return null;
        }
        try {
            XiamiIds xiamiIds = JSON.parseObject(html, XiamiIds.class);
            List<XiamiIds.DataBean.TrackListBean> trackList = xiamiIds.getData().getTrackList();
            if (trackList == null) {
                return null;
            }
            XiamiIds.DataBean.TrackListBean trackListBean = trackList.get(0);
            MusicSong song = new MusicSong();
            String songId = trackListBean.getSong_id();
            String songName = trackListBean.getSongName();
            String songLink = "http://www.xiami.com/song/" + songId;
            String artistId = String.valueOf(trackListBean.getArtistId());
            String artistName = trackListBean.getSingers();
            String ablum = String.valueOf(trackListBean.getAlbumId());
            String album = trackListBean.getAlbum_name();
            String length = Util.secTotime(trackListBean.getLength());
            String lyric = trackListBean.getLyric();
            String picUrl = trackListBean.getPic();//此处为小图
            //trackListBean.getAlbum_pic()//大图

            song.setSongExtraId(songId);

            song.setSongName(songName);
            song.setSongLink(songLink);
            song.setArtistId(artistId);
            song.setArtistName(artistName);
            song.setAlbumId(ablum);
            song.setAlbumName(album);
            song.setSongLength(length);
            song.setLrcUrl(lyric);
            song.setPicUrl(picUrl);
            String location = trackListBean.getLocation();
            if(!location.isEmpty()){
                song.setLqUrl(Util.getXiaMp3Url(location));
                song.setBitRate("128K");
            }
            String hqUrl = songUrl(songId);
            if(!hqUrl.isEmpty()){
                song.setHqUrl(Util.getXiaMp3Url(hqUrl));
                song.setSqUrl(Util.getXiaMp3Url(hqUrl));
                song.setBitRate("320K");
            }
            song.setSongType("xm");
            return song;
        } catch (Exception ignored) {

        }
        return null;
    }

    private static MusicSong SearchSong(String songId) {
        MusicSong song = GetResultsByIds(songId, 0);
        if (song == null) {
            return null;
        }
        return song;
    }

    private static String songUrl(String songId){
        String url = String.format("http://www.xiami.com/song/gethqsong/sid/%s",songId);
        String s = NetUtil.GetHtmlWithRefer(url, "http://www.xiami.com/");
        JSONObject ret = JSON.parseObject(s);
        return ret.getString("location");
    }


    @Override
    public List<MusicSong> SongSearch(String key, int page, int size) {
        try {
            return search(key, page, size);
        } catch (Exception e) {
            return null;  //解析歌曲失败
        }
    }
}
