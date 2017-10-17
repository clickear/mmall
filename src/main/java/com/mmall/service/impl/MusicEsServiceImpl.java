package com.mmall.service.impl;

import com.mmall.pojo.MusicSong;
import com.mmall.repository.IMusicEsRepository;
import com.mmall.service.IMusicEsService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

@Service("iMusicEsService")
public class MusicEsServiceImpl implements IMusicEsService{

    /* 分页参数 */
    Integer PAGE_SIZE = 12;          // 每页数量
    Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码

    /* 搜索模式 */
    String SCORE_MODE_SUM = "sum"; // 权重分求和模式
    Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private IMusicEsRepository iMusicEsRepository;


    @Override
    public MusicSong save(MusicSong musicSong) {
        return  iMusicEsRepository.save(musicSong);
    }

    @Override
    public List<MusicSong> findBySongName(String songName) {
        return getSongSearchQuery(DEFAULT_PAGE_NUMBER, PAGE_SIZE, songName);
//        return iMusicEsRepository.search(searchQuery).getContent();
    }


    /**
     * 根据搜索词构造搜索查询语句
     *
     * 代码流程：
     *      - 权重分查询
     *      - 短语匹配
     *      - 设置权重分最小值
     *      - 设置分页参数
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    private List<MusicSong> getSongSearchQuery(Integer pageNumber, Integer pageSize, String searchContent) {
        // 短语匹配到的搜索词，求和模式累加权重分
        // 权重分查询 https://www.elastic.co/guide/cn/elasticsearch/guide/current/function-score-query.html
        //   - 短语匹配 https://www.elastic.co/guide/cn/elasticsearch/guide/current/phrase-matching.html
        //   - 字段对应权重分设置，可以优化成 enum
        //   - 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.matchAllQuery())
//                .add(QueryBuilders.matchPhrasePrefixQuery("songName", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(1000))
//
//                .add(QueryBuilders.matchPhrasePrefixQuery("artistName", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(500))
//                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return iMusicEsRepository.search(QueryBuilders.matchPhrasePrefixQuery("songName",searchContent),pageable).getContent();
//
//        return new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
    }

}
