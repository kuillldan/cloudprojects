package org.lyk.helloWorld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by yuankliu on 27/06/2018.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*30)
public class SessionConfig
{
    // session 30 分钟实效
}
