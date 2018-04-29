package org.lyk.bootDemo.controller;

import org.lyk.bootDemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 29/04/2018.
 */

@RequestMapping("/DeptController/")
@Controller
public class DeptController
{
    @Autowired
    private DeptService deptService;

    @RequestMapping("showList")
    @ResponseBody
    public Object showList()
    {
        System.out.println("******showList*****");
        return this.deptService.findAll();
    }
}
