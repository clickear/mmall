package com.mmall.service;

import com.mmall.pojo.MusicSong;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface IMusicService {

    int deleteByPrimaryKey(Long id);

    int insert(MusicSong record);

    int insertSelective(MusicSong record);

    MusicSong selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicSong record);

    int updateByPrimaryKey(MusicSong record);

    MusicSong selectByTypeAndExtractId(String songType, String extractId);
}
