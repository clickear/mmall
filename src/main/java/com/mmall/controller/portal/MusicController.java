package com.mmall.controller.portal;

import com.mmall.pojo.MusicSong;
import com.mmall.pojo.music.SearchResult;
import com.mmall.service.IMusicEsService;
import com.mmall.service.IMusicService;
import com.mmall.service.impl.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/music/")
public class MusicController {

    @Autowired
    private IMusicEsService iMusicEsService;

    @Autowired
    private IMusicService iMusicService;

    @ResponseBody
    @RequestMapping(value = "serach.do", method = {RequestMethod.GET,RequestMethod.POST})
    public List<MusicSong> searchSong(String musciType, String songName){

        List<MusicSong> wy = MusicService.GetMusic(musciType).SongSearch(songName, 1, 15);

        for(MusicSong musicSong : wy){
            MusicSong result = iMusicService.selectByTypeAndExtractId(musicSong.getType(), musicSong.getSongExtraId());
            if(result ==null){
                long songId = iMusicService.insert(musicSong);
                if(songId >0){
                    iMusicEsService.save(musicSong);
                }
            }
        }
        return wy;
    }
}
