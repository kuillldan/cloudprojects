package org.lyk.helloWorld.web;

import org.lyk.helloWorld.domain.User;
import org.lyk.helloWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 27/06/2018.
 */
@Controller
@RequestMapping("/UserController/")
public class UserController
{

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("getUser")
    @ResponseBody
    @Cacheable(value = "usersCache")
    public User getUser(String userName)
    {
        System.out.println("查询数据库,userName=" + userName);
        return this.userRepository.findByUserName(userName);
    }

    @RequestMapping("saveUser")
    @ResponseBody
    @CachePut(value = "usersCache",key = "#user.userName")
    public User saveUser(User user)
    {
        System.out.println("执行数据库更新操作");
        this.userRepository.save(user);
        return user;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    @CacheEvict(value = "usersCache")
    public void deleteUser(String userName)
    {
        System.out.println("执行数据库删除操作,userName=" + userName);
        this.userRepository.delete(5L);
    }
}
