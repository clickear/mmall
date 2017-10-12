package com.mmall.service;


import com.mmall.pojo.MusicSong;

import java.util.List;

/**
 * Created by qtfreet00 on 2017/2/4.
 */
public interface IMusicSearchService {
    List<MusicSong> SongSearch(String key, int page, int size);
    
}
