package org.lyk.bootDemo.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.lyk.bootDemo.service.DeptService;
import org.lyk.bootDemo.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yuankliu on 02/05/2018.
 */
@Controller
@RequestMapping("/DeptReportController/")
public class DeptReportController
{
    private static final String FILE_FORMAT = "format";
    private static final String DATASOURCE = "datasource";

    @Autowired
    private DeptService deptService;

    @RequestMapping("deptReport")
    public ModelAndView deptReport(final ModelMap modelMap, @RequestParam(FILE_FORMAT) final String format,ModelAndView modelAndView)
    {
        String reportName = "dept_report";
        List<Dept> seedCustomerList = this.deptService.findAll();

        System.out.println(seedCustomerList);
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(seedCustomerList);
        modelMap.put(DATASOURCE, jrDataSource);
        modelMap.put(FILE_FORMAT, format);
        modelAndView = new ModelAndView(reportName, modelMap);
        return modelAndView;
    }
}
