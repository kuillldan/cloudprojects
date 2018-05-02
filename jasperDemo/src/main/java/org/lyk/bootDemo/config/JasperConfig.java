package org.lyk.bootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class JasperConfig extends WebMvcConfigurerAdapter
{
  
  private final static String REPORT_DATA_KEY = "datasource";  
  private final static String PATH_KEY = "classpath:jaspertemplate/";  
  private final static String TYPE_KEY = ".jrxml";  
  private final static String VIEW_KEY = "report";  
  
  @Override  
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();  
  }  
  
  @Bean
  public JasperReportsViewResolver getJasperReportsViewResolver() {  
    JasperReportsViewResolver resolver = new JasperReportsViewResolver();  
    resolver.setPrefix(PATH_KEY); 
    resolver.setSuffix(TYPE_KEY); 
    resolver.setReportDataKey(REPORT_DATA_KEY);  
    resolver.setViewNames("*" + VIEW_KEY + "*"); 
    resolver.setViewClass(JasperReportsMultiFormatView.class); 
    resolver.setOrder(0);
    return resolver;  
  }  
}  
