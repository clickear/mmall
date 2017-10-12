package com.mmall.service.impl;

import com.mmall.dao.MusicSongMapper;
import com.mmall.pojo.MusicSong;
import com.mmall.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service(value = "iMusicService")
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private MusicSongMapper musicSongMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(MusicSong record) {
        return musicSongMapper.insert(record);
    }

    @Override
    public int insertSelective(MusicSong record) {
        return 0;
    }

    @Override
    public MusicSong selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(MusicSong record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(MusicSong record) {
        return 0;
    }

    @Override
    public MusicSong selectByTypeAndExtractId(String type, String extractId) {
        return musicSongMapper.selectByTypeAndExtractId(type, extractId);
    }
}
