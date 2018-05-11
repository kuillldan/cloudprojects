package org.lyk.bootDemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.lyk.bootDemo.realm.BasicRealm;
import org.lyk.bootDemo.service.MemberService;
import org.lyk.bootDemo.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Created by yuankliu on 03/05/2018.
 */
@Controller
@RequestMapping("/MemberController/")
public class MemberController
{
    @Autowired
    private MemberService memberService;

    @Autowired
    private BasicRealm basicRealm;

    @ResponseBody
    @RequestMapping("runAuth")
    public Object runAuth(String username, String password)
    {
        try
        {
            if(Objects.isNull(this.basicRealm))
            {
                return "null";
            }
            else
            {
                return "not null";
            }

        }
        catch (Exception e)
        {
            return e.toString();
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public Object login(String username,String password)
    {
        Member member = this.memberService.findByUsername(username);
        if(Objects.isNull(member))
            return "用户名不存在";

        if(!member.getPassword().equals(password))
            return "密码错误";

        return "登陆成功";
    }
}
