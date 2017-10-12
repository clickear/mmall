package com.mmall.service.impl.music;

import com.mmall.service.IMusicSearchService;

/**
 * Created by qtfreet00 on 2017/2/4.
 */
public class MusicService {
    public static IMusicSearchService GetMusic(String type) {
        switch (type) {
            case "wy":
                return new WyMusicSearchService();
            case "qq":
                return new TxMusicSearchService();
            case "kg":
                return new KgMusicSearchService();
            case "xm":
                return new XmMusicSearchService();
            default:
                return new TxMusicSearchService();
        }
    }
}
