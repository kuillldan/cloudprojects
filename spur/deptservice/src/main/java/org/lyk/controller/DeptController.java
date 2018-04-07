package org.lyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Controller
@RequestMapping("/DeptController/")
public class DeptController
{
    @RequestMapping("sayHello")
    @ResponseBody
    public Object sayHello(String msg)
    {
        return "ehcho:" + msg.toUpperCase();
    }
}
