package org.lyk.bootDemo.service;

import org.lyk.bootDemo.vo.Member;

/**
 * Created by yuankliu on 03/05/2018.
 */
public interface MemberService
{
    Member findByUsername(String username);
}
