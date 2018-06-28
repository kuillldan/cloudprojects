package org.lyk.helloWorld.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by yuankliu on 28/06/2018.
 */
public class SimpleJob extends QuartzJobBean
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        System.out.println(String.format("Hello %s!", this.name));
    }
}
