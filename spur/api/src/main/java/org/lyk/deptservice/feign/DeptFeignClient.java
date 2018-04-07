package org.lyk.deptservice.feign;

import org.lyk.common.SpringResponse;
import org.lyk.deptservice.Dept;
import org.lyk.deptservice.hystrix.DeptHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yuankliu on 07/04/2018.
 */
@FeignClient(name="DEPTSERVICE",fallbackFactory = DeptHystrix.class)
public interface DeptFeignClient
{
    String DEPTCONTROLLER = "/DeptController/";

    @RequestMapping(value = DEPTCONTROLLER + "getDeptByDeptno",method = RequestMethod.GET)
    SpringResponse<Dept> getDeptByDeptno(@RequestParam("deptno") Long deptno);
}
