package org.lyk.demo.controller;

import org.lyk.demo.domain.User;
import org.lyk.demo.domain.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by yuankliu on 15/05/2018.
 */
@RestController
@Cacheable(value = "user")
public class HelloWorldController
{
    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;

    @Value("${org.lyk.title}")
    private String title;

    @Value("${org.lyk.description}")
    private String description;

    @RequestMapping("/hello")
    public Object index()
    {
        return "Hello world";
    }

    @RequestMapping("/getUser")
    public Object getUser(String userName)
    {
        Object retVal = this.userDao.findByUserNameAndPassWord(userName, "");
        System.out.println(retVal);
        return retVal;
    }

    @RequestMapping("/setUserToRedis")
    public Object setUserToRedis(User user)
    {
        this.redisTemplate.opsForValue().set(user.getUserName(), user);
        return "true";
    }

    @RequestMapping("/uid")
    String uid(HttpSession session)
    {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null)
        {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }


    @RequestMapping("getUserFromRedis")
    public Object getUserFromRedis(String userName)
    {
        return this.redisTemplate.opsForValue().get(userName);
    }
}
