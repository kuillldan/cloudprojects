package org.lyk.controller;

import org.lyk.common.SpringResponse;
import org.lyk.deptservice.Dept;
import org.lyk.deptservice.feign.DeptFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 07/04/2018.
 */
@RequestMapping("/DeptController/")
@Controller
public class DeptController
{
    @Autowired
    private DeptFeignClient deptFeignClient;

    @ResponseBody
    @RequestMapping("getDeptByDeptno")
    public Object getDeptByDeptno(Long deptno)
    {
        SpringResponse<Dept> sr = this.deptFeignClient.getDeptByDeptno(deptno);
        System.out.println(sr);
        return sr;
    }
}
