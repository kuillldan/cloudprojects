package org.lyk.helloWorld.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.lyk.helloWorld.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuankliu on 27/06/2018.
 */
@Configuration
public class WebConfiguration
{
    @Bean
    public RemoteIpFilter remoteIpFilter()
    {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean setFilterRegistration()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        Map<String,String> map = new HashMap<>();
        map.put("paramName","ABCDE");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
