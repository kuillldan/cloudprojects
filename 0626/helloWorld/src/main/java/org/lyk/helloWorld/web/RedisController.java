package org.lyk.helloWorld.web;

import org.lyk.helloWorld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuankliu on 27/06/2018.
 */
@RestController
@RequestMapping("/RedisController/")
public class RedisController
{
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("saveString")
    public void saveString(String key,String value)
    {
        this.redisTemplate.opsForValue().set(key,value);
    }

    @RequestMapping("getString")
    public Object getString(String key)
    {
        return this.redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("saveUser")
    public void saveUser(User user)
    {
        this.redisTemplate.opsForValue().set(user.getUserName(), user, 10, TimeUnit.SECONDS);
    }

    @RequestMapping("getUser")
    public Object getUser(String userName)
    {
        return this.redisTemplate.opsForValue().get(userName);
    }

    @RequestMapping("saveHashValue")
    public void saveHashValue()
    {
        this.redisTemplate.opsForHash().put("yuankui","name","liuyuankui");
        this.redisTemplate.opsForHash().put("yuankui","age",31);
    }

    @RequestMapping("getHashValue")
    public Object getHashValue()
    {
        return this.redisTemplate.opsForHash().get("yuankui","age");
    }

    @RequestMapping("saveList")
    public void saveList()
    {
        this.redisTemplate.opsForList().leftPush("contacts","yuankui");
        this.redisTemplate.opsForList().leftPush("contacts","dandan");
        this.redisTemplate.opsForList().leftPush("contacts","yutang");
    }

    @RequestMapping("getListjj")
    public Object getList()
    {
        return this.redisTemplate.opsForList().leftPop("contacts");
    }
}
