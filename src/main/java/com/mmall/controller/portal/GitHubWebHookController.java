package com.mmall.controller.portal;

import com.mmall.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.omg.SendingContext.RunTime;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String push(@RequestHeader("X-GitHub-Event")String events){
        String absFilePath = PropertiesUtil.getProperty("githubshell","/alidata/repository/mmall/deploy.sh");
        try {
            Process exec = Runtime.getRuntime().exec("sh "+absFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hellowrod";
    }

}
