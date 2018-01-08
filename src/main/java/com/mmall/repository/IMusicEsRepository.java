package com.mmall.repository;

import com.mmall.pojo.MusicSong;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface  IMusicEsRepository extends ElasticsearchRepository<MusicSong, Long> {

    List<MusicSong> findBySongNameLike(String songName);

    List<MusicSong> findByArtistName(String artistName);

}
