package org.lyk.demo.controller;

import org.lyk.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuankliu on 16/05/2018.
 */

@RequestMapping("/UserController/")
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("findByUserName")
    @ResponseBody
    public Object findByUserName(String userName)
    {
        return this.userService.findByUserName(userName);
    }

    @GetMapping("findByUserNameAndPassWord")
    @ResponseBody
    public Object findByUserNameAndPassWord(String userName, String passWord)
    {
        System.out.println("*****1111");
        Object retVal = this.userService.findByUserNameAndPassWord(userName, passWord);
        System.out.println("*****222");
        return retVal;
    }
}
