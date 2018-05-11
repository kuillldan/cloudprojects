package org.lyk.bootDemo.service.impl;

import org.lyk.bootDemo.dao.MemberDao;
import org.lyk.bootDemo.service.MemberService;
import org.lyk.bootDemo.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuankliu on 03/05/2018.
 */
@Service
public class MemberServiceImpl implements MemberService
{
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member findByUsername(String username)
    {
         return this.memberDao.findByUsername(username);
    }
}
