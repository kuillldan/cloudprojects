package org.lyk.controller;

import org.lyk.deptservice.Dept;
import org.lyk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuankliu on 07/04/2018.
 */
@RestController
@RequestMapping("/DeptController/")
public class DeptController
{
    @Autowired
    private DeptService deptService;

    @RequestMapping("sayHello")
    @ResponseBody
    public Object sayHello(String msg)
    {
        return "ehcho:" + msg.toUpperCase();
    }

    @RequestMapping("getDeptByDeptno")
    public Object getDeptByDeptno(@RequestParam("deptno") Long deptno)
    {
        Dept dept = this.deptService.getDeptByDeptno(deptno);
        return dept;
    }
}