package com.mmall.controller.portal;

import com.mmall.util.PropertiesUtil;
import com.mmall.util.SynThreadPool;
import com.mmall.vo.GitHubWebHook;
import org.apache.commons.lang3.StringUtils;
import org.omg.SendingContext.RunTime;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/18.
 */

@Controller
@RequestMapping(value = "/github")
public class GitHubWebHookController {

    @RequestMapping(value="webhook.do", method = RequestMethod.POST)
    @ResponseBody
    public String push(@RequestHeader("X-GitHub-Event")String events, @RequestBody GitHubWebHook gitHubWebHook){
        if("refs/heads/deployment".equals(gitHubWebHook.getRef())){
            SynThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    String absFilePath = PropertiesUtil.getProperty("githubshell","/alidata/repository/mmall/deploy.sh");
                    try {
                        System.out.println("run ssh");
                        Process exec = Runtime.getRuntime().exec("sh "+absFilePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return "hellowrod";
    }

}
