package org.lyk.bootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 29/04/2018.
 */
@Controller
@RequestMapping("/HelloController/")
public class HelloController
{
    @RequestMapping("echo")
    @ResponseBody
    public Object echo(String msg)
    {
        return "echo:" + msg;
    }

    @RequestMapping("display")
    public String display(String msg,ModelMap modelMap)
    {
        modelMap.addAttribute("msg",msg) ;
        return "pages/hello/display";
    }
}
