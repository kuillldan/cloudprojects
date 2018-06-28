package org.lyk.helloWorld.web;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 27/06/2018.
 */
@Controller
@RequestMapping("/CacheController/")
public class CacheController
{
    @ResponseBody
    @RequestMapping("hello")
//    @Cacheable(value = "helloCache")
    public String hello(String name)
    {
        System.out.println("没有走缓存");
        return "hello, " + name;
    }
}