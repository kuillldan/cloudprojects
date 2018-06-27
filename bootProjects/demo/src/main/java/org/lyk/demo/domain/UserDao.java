package org.lyk.demo.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by yuankliu on 16/05/2018.
 */
public interface UserDao extends JpaRepository<User, Long>
{
    @Query(value = " SELECT u FROM User u WHERE u.userName = :userName AND u.passWord=:passWord ")
    User findByUserNameAndPassWord(@Param("userName") String userName,
                                   @Param("passWord") String passWord);

    User findByUserNameOrEmail(String userName, String email);

    @Modifying
    @Query(value = " DELETE FROM User u WHERE u.userName = :userName ")
    void removeUserByUserName(@Param("userName") String userName);

    User findByUserName(String userName);
}
