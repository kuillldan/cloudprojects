package org.lyk.controller;

import org.lyk.common.SpringResponse;
import org.lyk.common.SpringStatus;
import org.lyk.deptservice.Dept;
import org.lyk.deptservice.feign.DeptFeignClient;
import org.lyk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by yuankliu on 07/04/2018.
 */
@RestController
@RequestMapping
public class DeptController implements DeptFeignClient
{    @Autowired
    private DeptService deptService;

    @RequestMapping(value = DEPTCONTROLLER + "getDeptByDeptno",method = RequestMethod.GET)
    public SpringResponse<Dept> getDeptByDeptno(@RequestParam("deptno") Long deptno)
    {
        Dept dept = this.deptService.getDeptByDeptno(deptno);

        if(Objects.isNull(dept))
        {
            throw new RuntimeException("未查到相关记录");
        }

        SpringResponse<Dept> sr = new SpringResponse<>();
        sr.setStatus(SpringStatus.SUCCESS);
        sr.setMessage("查询成功");
        sr.setRetVal(dept);
        return sr;
    }

}