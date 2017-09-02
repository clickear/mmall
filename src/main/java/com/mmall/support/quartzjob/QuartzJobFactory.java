package com.mmall.support.quartzjob;

import org.quartz.JobExecutionContext;

/**
 * Created by Administrator on 2017/9/2.
 */

import com.mmall.pojo.ScheduleJob;
import com.mmall.util.JobTaskUtils;
import org.quartz.Job;
import org.quartz.JobExecutionException;


/**
 *
 * @Description: 计划任务执行处 无状态
 * @author chenjianlin
 * @date 2014年4月24日 下午5:05:47
 */
public class QuartzJobFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        JobTaskUtils.invokMethod(scheduleJob);
    }
}