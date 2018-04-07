package org.lyk.deptservice.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value="部门服务API接口")
public interface DeptFeignClient
{
    String DEPTCONTROLLER = "/DeptController/";

    @ApiOperation(value="通过部门deptno获取部门信息",notes = "通过部门deptno获取部门信息")
    @ApiImplicitParam(name="deptno",value="部门编号",required = true,
    dataType = "Long",paramType = "query")
    @RequestMapping(value = DEPTCONTROLLER + "getDeptByDeptno",method = RequestMethod.GET)
    SpringResponse<Dept> getDeptByDeptno(@RequestParam("deptno") Long deptno);
}
