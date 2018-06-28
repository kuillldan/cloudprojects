package org.lyk.helloWorld.config;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yuankliu on 28/06/2018.
 */
@Component
@EnableScheduling
@Configuration
public class ScheduleListener
{
    @Autowired
    public CornSchedule cornSchedule;

    @Scheduled(cron = "0 30 11 25 11 ?")
    public void schedule() throws SchedulerException
    {
        this.cornSchedule.scheduleJobs();
    }
}
