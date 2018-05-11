package org.lyk.bootDemo.controller;

import org.lyk.bootDemo.utils.RedisObjectSerializer;
import org.lyk.bootDemo.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 06/05/2018.
 */
@Controller
@RequestMapping("RedisController")
public class RedisController
{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("setDeptToRedis")
    @ResponseBody
    public Object setDeptToRedis(Dept dept)
    {
        try
        {
            this.redisTemplate.opsForValue().set(dept.getDeptno(),dept);
            return true;
        }
        catch (Exception e)
        {
            return "exception";
        }
    }

    @RequestMapping("getDeptFromRedis")
    @ResponseBody
    public Object getDeptFromRedis(String deptno)
    {
        try
        {
            return this.redisTemplate.opsForValue().get(deptno);
        }
        catch (Exception e)
        {
            return "exception";
        }
    }

    @RequestMapping("set")
    @ResponseBody
    public Object set(String key,String value)
    {
        try
        {
            this.redisTemplate.opsForValue().set(key,value);
            return true;
        }
        catch (Exception e)
        {
            return "exception";
        }
    }

    @RequestMapping("get")
    @ResponseBody
    public Object get(String key)
    {
        try
        {
            return this.redisTemplate.opsForValue().get(key);
        }
        catch (Exception e)
        {
            return "exception";
        }
    }
}
