package org.lyk.service.impl;

import org.lyk.dao.DeptDAO;
import org.lyk.deptservice.Dept;
import org.lyk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Service
public class DeptServiceImpl implements DeptService
{
    @Autowired
    private DeptDAO deptDAO;

    @Override
    public Dept getDeptByDeptno(Long deptno)
    {
        return this.deptDAO.getDeptByDeptno(deptno);
    }
}
