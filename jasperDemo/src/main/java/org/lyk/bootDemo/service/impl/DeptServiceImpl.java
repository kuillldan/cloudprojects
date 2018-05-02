package org.lyk.bootDemo.service.impl;

import org.lyk.bootDemo.dao.DeptDao;
import org.lyk.bootDemo.service.DeptService;
import org.lyk.bootDemo.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuankliu on 29/04/2018.
 */
@Service
public class DeptServiceImpl implements DeptService
{
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll()
    {
        return this.deptDao.findAll();
    }
}