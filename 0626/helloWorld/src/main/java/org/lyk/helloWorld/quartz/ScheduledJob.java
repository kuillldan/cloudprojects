package org.lyk.helloWorld.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by yuankliu on 28/06/2018.
 */
public class ScheduledJob implements Job
{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        System.out.println("schedule job1 is running ...");
    }
}
