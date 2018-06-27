package org.lyk.helloWorld.web;

import org.lyk.helloWorld.domain.User;
import org.lyk.helloWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuankliu on 27/06/2018.
 */
@RestController
@RequestMapping("/UserController/")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("saveUser")
    public Object saveUser(User user)
    {
        user.setRegTime("2018年6月27日16:06:45");
        this.userRepository.save(user);
        return "true";
    }
}
