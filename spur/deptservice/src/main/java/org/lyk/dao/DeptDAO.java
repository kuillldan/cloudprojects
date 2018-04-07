package org.lyk.dao;

import org.lyk.deptservice.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Repository
public interface DeptDAO extends JpaRepository<Dept, Long>,
        PagingAndSortingRepository<Dept, Long>,
        JpaSpecificationExecutor<Dept>
{
    @Query(value = " SELECT d FROM Dept d WHERE deptno=:deptno ")
    Dept getDeptByDeptno(@Param("deptno") Long deptno);
}
