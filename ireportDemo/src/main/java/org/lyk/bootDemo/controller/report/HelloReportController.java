package org.lyk.bootDemo.controller.report;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.lyk.bootDemo.service.DeptService;
import org.lyk.bootDemo.util.JasperUtil;
import org.lyk.bootDemo.vo.Dept;
import org.lyk.bootDemo.vo.UserBook;
import org.lyk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("userBookReport")
    public ModelAndView userBookReport(HttpServletResponse response)
    {
        try
        {
            List<UserBook> userBookList = new ArrayList<>();
            UserBook ub1 = new UserBook("刘远奎",23);
            UserBook ub2 = new UserBook("蒋攀",35);
            UserBook ub3 = new UserBook("刘杰",19);
            UserBook ub4 = new UserBook("李友益",7);
            userBookList.add(ub1);
            userBookList.add(ub2);
            userBookList.add(ub3);
            userBookList.add(ub4);

            JasperUtil.downloadAsPdf(response,"jaspertemplate/user_book.jrxml",new HashMap<>(),new JRBeanCollectionDataSource(userBookList));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
