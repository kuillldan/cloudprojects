package org.lyk.bootDemo.controller;

import org.lyk.bootDemo.service.DeptService;
import org.lyk.bootDemo.utils.ExceportUtil;
import org.lyk.bootDemo.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuankliu on 29/04/2018.
 */

@RequestMapping("/DeptController/")
@Controller
public class DeptController
{
    private static final Map<String, Integer> deptHeaders = new HashMap<>();

    static
    {
        Integer index = 0;
        deptHeaders.put("部门编号", index++);
        deptHeaders.put("部门名称", index++);
        deptHeaders.put("部门位置", index++);
    }


    @Autowired
    private DeptService deptService;

    @RequestMapping("showList")
    @ResponseBody
    public Object showList()
    {
        return this.deptService.findAll();
    }

    @RequestMapping("exportDeptValues")
    public void exportDeptValues(HttpServletResponse response)
    {
        List<Dept> allDepts = this.deptService.findAll();
        //导出的Excel名称
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        String sheetName = sim.format(new Date()) + "-salary";
        //导出的数据标题
        //要导出的数据
        List<Object[]> dataList = new ArrayList<>();

        Set<String> headerSet = deptHeaders.keySet();
        for (Dept dept : allDepts)
        {
            Object[] row = new Object[headerSet.size()];
            for (String header : headerSet)
            {
                switch (header)
                {
                    case "部门编号":
                    {
                        Integer index = deptHeaders.get(header);
                        row[index] = dept.getDeptno();
                        break;
                    }
                    case "部门名称":
                    {
                        Integer index = deptHeaders.get(header);
                        row[index] = dept.getDname();
                        break;
                    }
                    case "部门位置":
                    {
                        Integer index = deptHeaders.get(header);
                        row[index] = dept.getLoc();
                        break;
                    }
                    default:
                    {
                        throw new RuntimeException("未知的列:" + header);
                    }
                }
            }
            dataList.add(row);
        }


        String[] headers = new String[headerSet.size()];
        for(String header : headerSet)
        {
            Integer index = deptHeaders.get(header);
            headers[index] = header;
        }

        ExceportUtil exceportUtil = new ExceportUtil(sheetName, headers, dataList, response);
        exceportUtil.exportDataList();
    }
}
