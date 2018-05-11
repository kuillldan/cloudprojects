package org.lyk.bootDemo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import redis.clients.jedis.Jedis;

/**
 * Created by yuankliu on 03/05/2018.
 */
public class Hello
{
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("192.168.91.128",6379);
        jedis.auth("123");
        System.out.println(jedis.ping());
        jedis.close();
    }
}
