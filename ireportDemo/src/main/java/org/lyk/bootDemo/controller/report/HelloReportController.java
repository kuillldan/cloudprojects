package org.lyk.bootDemo.controller.report;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.lyk.bootDemo.service.DeptService;
import org.lyk.bootDemo.util.JasperUtil;
import org.lyk.bootDemo.vo.Dept;
import org.lyk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuankliu on 11/05/2018.
 */
@Controller
@RequestMapping("/HelloReportController/")
public class HelloReportController
{
    @Autowired
    private DeptService deptService;

    @RequestMapping("demo")
    public ModelAndView demo(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            List<Dept> deptList = this.deptService.findAll();

            HashMap<String,Object> params = new HashMap<>();
            params.put("user_name","柳岩");
            JasperUtil.downloadAsPdf(response,
                    "jaspertemplate/report3.jrxml",
                    params,
                    new JRBeanCollectionDataSource(deptList));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
