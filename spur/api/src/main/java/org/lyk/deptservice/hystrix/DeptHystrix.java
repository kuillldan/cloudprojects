package org.lyk.deptservice.hystrix;

import feign.hystrix.FallbackFactory;
import org.lyk.common.ExceptionUtil;
import org.lyk.common.SpringResponse;
import org.lyk.common.SpringStatus;
import org.lyk.deptservice.Dept;
import org.lyk.deptservice.feign.DeptFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Component
public class DeptHystrix implements FallbackFactory<DeptFeignClient>
{
    @Override
    public DeptFeignClient create(Throwable cause)
    {
        return new DeptFeignClient()
        {
            @Override
            public SpringResponse<Dept> getDeptByDeptno(@RequestParam("deptno") Long deptno)
            {
                SpringResponse sr = new SpringResponse();
                sr.setStatus(SpringStatus.HYSTRIX);
                sr.setDetails(ExceptionUtil.getStackTraceAsString(cause));
                return sr;
            }
        };
    }
}
