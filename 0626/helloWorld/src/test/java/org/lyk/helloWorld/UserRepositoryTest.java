package org.lyk.helloWorld;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lyk.helloWorld.domain.User;
import org.lyk.helloWorld.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by yuankliu on 27/06/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest
{
    @Resource
    private UserRepository userRepository;

    @Test
    public void test()
    {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa", "aa@126.com", "aa", "aa123456",formattedDate));
//        userRepository.save(new User("bb", "bb@126.com", "bb", "bb123456",formattedDate));
//        userRepository.save(new User("cc", "cc@126.com", "cc", "cc123456", formattedDate));

        System.out.println(userRepository.findAll().size());
        System.out.println(userRepository.findByUserName("aa"));
    }
}
