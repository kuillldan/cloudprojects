package org.lyk.ireport.controller;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * Created by yuankliu on 10/05/2018.
 */
@Controller
@RequestMapping("ReportController")
public class ReportController
{
    @RequestMapping("show")
    public void show(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
            ServletOutputStream servletOutputSteream = response.getOutputStream();
            Resource resource = new ClassPathResource("jaspers/report3.jasper");
            File file = resource.getFile();
            InputStream reportStream = new FileInputStream(file);
            JasperRunManager.runReportToPdfStream(reportStream,servletOutputSteream,new HashMap<>(),new JREmptyDataSource());
            response.setContentType("application/pdf");
            servletOutputSteream.flush();
            servletOutputSteream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
