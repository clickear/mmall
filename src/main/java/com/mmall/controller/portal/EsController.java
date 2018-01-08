package com.mmall.controller.portal;

import com.mmall.pojo.MusicSong;
import com.mmall.service.IMusicEsService;
import com.mmall.service.impl.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

@Controller
@RequestMapping(value = "/es")
public class EsController {

    @Autowired
    private IMusicEsService iMusicEsService;


    @ResponseBody
    @RequestMapping(value = "serach/{songName}", method = {RequestMethod.GET})
    public List<MusicSong> searchSongByEs(@PathVariable String songName){
        List<MusicSong> musicSongs = iMusicEsService.findBySongName(songName);

        return  musicSongs;
    }
}
