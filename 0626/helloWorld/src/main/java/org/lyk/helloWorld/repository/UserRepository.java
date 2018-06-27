package org.lyk.helloWorld.repository;

import org.lyk.helloWorld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuankliu on 27/06/2018.
 */
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName,String email);
}
