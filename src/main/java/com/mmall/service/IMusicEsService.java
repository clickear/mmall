package com.mmall.service;

import com.mmall.pojo.MusicSong;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface IMusicEsService {
    MusicSong save(MusicSong musicSong);

    List<MusicSong> findBySongName(String songName);
}
