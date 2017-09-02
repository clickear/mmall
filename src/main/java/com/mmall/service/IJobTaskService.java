package com.mmall.service;

import com.mmall.pojo.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * Created by Administrator on 2017/9/2.
 */
public interface IJobTaskService {
    List<ScheduleJob> getAllTask();
    void addTask(ScheduleJob job);
    ScheduleJob getTaskById(Long jobId);
    void changeStatus(Long jobId, String cmd) throws SchedulerException;
    void updateCron(Long jobId, String cron) throws SchedulerException;
    void addJob(ScheduleJob job) throws SchedulerException;
    List<ScheduleJob> getAllJob() throws SchedulerException;
    List<ScheduleJob> getRunningJob() throws SchedulerException;
    void pauseJob(ScheduleJob scheduleJob) throws SchedulerException;
    void resumeJob(ScheduleJob scheduleJob) throws SchedulerException;
    void deleteJob(ScheduleJob scheduleJob) throws SchedulerException;
    void runAJobNow(ScheduleJob scheduleJob) throws SchedulerException;
    void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException;
}
