package com.mmall.util;

import com.mmall.pojo.SignLog;
import com.mmall.pojo.TemplateWithBLOBs;
import com.mmall.service.ISignService;
import de.sstoehr.harreader.HarReaderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

@Component("taskJob")
public class JobSchelder {

    @Autowired
    private ISignService iSignService;

    @Scheduled(cron = "0 0 0,6,12,18 * * ? ")
    public void job1() {

        List<TemplateWithBLOBs> tempList = iSignService.selectByUserId(1);

        for(TemplateWithBLOBs tempObject:tempList){
            try {
                String result = HarUtil.request(new String(tempObject.getHar(),"UTF-8"));

                SignLog signLog = new SignLog();
                signLog.setContent(result);
                signLog.setSitename(tempObject.getSitename());
                signLog.setTplid(tempObject.getId());
                signLog.setCreatetime(new Date());
                iSignService.insertSignLog(signLog);
//                System.out.printf("result:"+result);
            } catch (IOException e) {
                e.printStackTrace();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println("任务进行中。。。");
    }
}
