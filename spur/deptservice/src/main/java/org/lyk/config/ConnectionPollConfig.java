package org.lyk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by yuankliu on 30/03/2018.
 */
@Configuration
public class ConnectionPollConfig
{
    @Bean
    public DataSource dataSource(DataSourceProperties properties)
    {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());//用户名
        dataSource.setPassword(properties.getPassword());//密码
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(15);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(5000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);

        return dataSource;
    }
}
