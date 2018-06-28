package org.lyk.helloWorld.config;

import org.lyk.helloWorld.quartz.SimpleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuankliu on 28/06/2018.
 */

@Configuration
public class SimpleScheduler
{
    @Bean
    public JobDetail getJobDetail()
    {
        return JobBuilder.newJob(SimpleJob.class)
                .withIdentity("SimpleJob")
                .usingJobData("name", "world")
                .storeDurably()
                .build();
    }


    @Bean
    public Trigger sampleJobTrigger()
    {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(getJobDetail())
                .withIdentity("simpleTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
