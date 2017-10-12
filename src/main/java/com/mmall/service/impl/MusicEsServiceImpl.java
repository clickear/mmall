package com.mmall.service.impl;

import com.mmall.pojo.MusicSong;
import com.mmall.repository.IMusicEsRepository;
import com.mmall.service.IMusicEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/10/11.
 */

@Service("iMusicEsService")
public class MusicEsServiceImpl implements IMusicEsService{

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private IMusicEsRepository iMusicEsRepository;


    @Override
    public MusicSong save(MusicSong musicSong) {
        return  iMusicEsRepository.save(musicSong);
    }


}
