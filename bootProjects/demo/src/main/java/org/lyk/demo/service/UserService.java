package org.lyk.demo.service;

import org.lyk.demo.domain.User;

/**
 * Created by yuankliu on 16/05/2018.
 */
public interface UserService
{
    User addUser(User user);

    User findByUserName(String userName);

    void removeUserByUserName(String userName);

    User findByUserNameAndPassWord(String userName, String passWord);

    void updateUser(User user);
}
