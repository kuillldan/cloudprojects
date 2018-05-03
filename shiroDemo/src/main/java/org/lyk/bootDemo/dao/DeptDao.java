package org.lyk.bootDemo.dao;

import org.lyk.bootDemo.vo.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yuankliu on 29/04/2018.
 */
public interface DeptDao extends JpaRepository<Dept,String>
{
    @Query(value=" SELECT d FROM Dept d ")
    List<Dept> findAll();
}
