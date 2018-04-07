package org.lyk.service;

import org.lyk.deptservice.Dept;
import org.springframework.stereotype.Service;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Service
public interface DeptService
{
    Dept getDeptByDeptno(Long deptno);
}
