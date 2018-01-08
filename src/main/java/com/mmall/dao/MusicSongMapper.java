package com.mmall.dao;

import com.mmall.pojo.MusicSong;
import org.apache.ibatis.annotations.Param;

public interface MusicSongMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicSong record);

    int insertSelective(MusicSong record);

    MusicSong selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicSong record);

    int updateByPrimaryKey(MusicSong record);

    MusicSong selectByTypeAndExtractId(@Param(value="songType")String songType,@Param(value="extractId") String extractId);

}