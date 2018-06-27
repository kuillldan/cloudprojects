package org.lyk.demo.service;

import org.lyk.demo.domain.User;
import org.lyk.demo.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by yuankliu on 16/05/2018.
 */

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    @CachePut(value = "user", key = "#root.targetClass + #userName", unless = "#result eq null")
    public User addUser(User user)
    {
        return this.userDao.save(user);
    }

    @Override
    @CacheEvict(value = "user", key = "#root.targetClass + #userName")
    public void removeUserByUserName(String userName)
    {
        this.userDao.removeUserByUserName(userName);
    }

    @Override
//    @Cacheable(value="user",key="#root.targetClass + #userName",unless = "#result eq null")
    @Cacheable(value = "user")
    public User findByUserNameAndPassWord(String userName, String passWord)
    {
        return this.userDao.findByUserNameAndPassWord(userName, passWord);
    }

    @Override
    @Cacheable(value="user")
    public User findByUserName(String userName)
    {
        return this.userDao.findByUserName(userName);
    }

    @Override
//    @CachePut(value="user",key="#root.targetClass + #userName",unless = "#result eq null")
    public void updateUser(User user)
    {
//        this.userDao.updateUser(user);
    }
}
