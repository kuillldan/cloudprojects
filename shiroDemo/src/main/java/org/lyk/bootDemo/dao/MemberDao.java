package org.lyk.bootDemo.dao;

import org.lyk.bootDemo.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by yuankliu on 03/05/2018.
 */
@Repository
public interface MemberDao extends JpaRepository<Member, String>
{
    @Query(" SELECT m FROM Member m WHERE m.mid = :username")
    Member findByUsername(@Param("username") String username);
}
