package com.mmall.controller.portal;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.ScheduleJob;
import com.mmall.service.IJobTaskService;
import com.mmall.support.spring.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2017/9/2.
 */
@Controller
@RequestMapping("/task")
public class JobTaskController {

    @Autowired
    private IJobTaskService iJobTaskService;

    @RequestMapping("taskList")
    public String taskList(HttpServletRequest request) {
        List<ScheduleJob> taskList = iJobTaskService.getAllTask();
        request.setAttribute("taskList", taskList);
        return "taskList";
    }


    @RequestMapping("add")
    @ResponseBody
    public ServerResponse taskList(HttpServletRequest request, ScheduleJob scheduleJob) {
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("cron表达式有误，不能被解析！");
        }
        Object obj = null;
        try {
            if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
                obj = SpringUtils.getBean(scheduleJob.getSpringId());
            } else {
                Class clazz = Class.forName(scheduleJob.getBeanClass());
                obj = clazz.newInstance();
            }
        } catch (Exception e) {
            // do nothing.........
        }
        if (obj == null) {
            return ServerResponse.createByErrorMessage("未找到目标类！");
        } else {
            Class clazz = obj.getClass();
            Method method = null;
            try {
                method = clazz.getMethod(scheduleJob.getMethodName(), null);
            } catch (Exception e) {
                // do nothing.....
            }
            if (method == null) {
                return ServerResponse.createByErrorMessage("未找到目标方法！");
            }
        }
        try {
            iJobTaskService.addTask(scheduleJob);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("保存失败，检查 name group 组合是否有重复！");
        }
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("changeJobStatus")
    @ResponseBody
    public ServerResponse changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
        try {
            iJobTaskService.changeStatus(jobId, cmd);
        } catch (SchedulerException e) {
            return ServerResponse.createByErrorMessage("任务状态改变失败！");
        }
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("updateCron")
    @ResponseBody
    public ServerResponse updateCron(HttpServletRequest request, Long jobId, String cron) {
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("cron表达式有误，不能被解析！");
        }
        try {
            iJobTaskService.updateCron(jobId, cron);
        } catch (SchedulerException e) {
            return ServerResponse.createByErrorMessage("cron更新失败！");
        }
        return ServerResponse.createBySuccess();
    }

}
