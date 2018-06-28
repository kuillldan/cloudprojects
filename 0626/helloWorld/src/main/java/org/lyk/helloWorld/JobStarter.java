package org.lyk.helloWorld;

import org.lyk.helloWorld.config.CornSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by yuankliu on 28/06/2018.
 */
@Component
public class JobStarter implements CommandLineRunner
{
    @Autowired
    private CornSchedule cornSchedule;

    @Override
    public void run(String... strings) throws Exception
    {
//        this.cornSchedule.scheduleJobs();
    }
}
