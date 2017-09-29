package com.mmall;

import com.alibaba.fastjson.JSON;
import com.mmall.pojo.MusicSong;
import com.mmall.pojo.music.SearchResult;
import com.mmall.service.impl.music.MusicService;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class SearchSong {
    public static void main(String[] args) throws UnsupportedEncodingException {
        List<MusicSong> wy = MusicService.GetMusic("xm").SongSearch("寂寞寂寞就好", 1, 15);
        SearchResult searchResult = new SearchResult();
        if (wy == null) {
            searchResult.setStatus(404);
            searchResult.setSongs(null);
        } else {
            searchResult.setStatus(200);
            searchResult.setSongs(wy);
        }
        System.out.println(JSON.toJSONString(searchResult));
    }
}
