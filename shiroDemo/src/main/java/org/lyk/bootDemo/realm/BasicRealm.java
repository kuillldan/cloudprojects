package org.lyk.bootDemo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lyk.bootDemo.service.MemberService;
import org.lyk.bootDemo.service.impl.MemberServiceImpl;
import org.lyk.bootDemo.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by yuankliu on 03/05/2018.
 */
@Component
public class BasicRealm extends AuthorizingRealm
{
    @Autowired
    private MemberService memberService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        Member member = this.memberService.findByUsername(username);
        if(Objects.isNull(member))
        {
            throw new UnknownAccountException(username + "账户不存在");
        }

        if(!member.getPassword().equals(password))
        {
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(username,password,"basicRealm");
    }
}