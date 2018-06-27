package org.lyk.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by yuankliu on 15/05/2018.
 */
//@Configuration
public class WebConfiguration
{
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.addInitParameter("paramName", "SpringBoot Filter Demo");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    public class MyFilter implements Filter
    {
        private String paramName = null;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException
        {
            this.paramName = filterConfig.getInitParameter("paramName");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
        {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is MyFilter,url:" + request.getRequestURI());
            System.out.println("参数:" + this.paramName);
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy()
        {

        }
    }
}
