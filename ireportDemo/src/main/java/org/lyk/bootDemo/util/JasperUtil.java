package org.lyk.bootDemo.util;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by yuankliu on 11/05/2018.
 */
public class JasperUtil
{
    public static void downloadAsPdf(HttpServletResponse response,
                                     String jrxmlPath, HashMap<String, Object> parameters,
                                     JRRewindableDataSource dataSource) throws Exception
    {
        Resource jrxmlResource = new ClassPathResource(jrxmlPath);
        InputStream jrxmlResourceInputStream = jrxmlResource.getInputStream();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        JasperCompileManager.compileReportToStream(jrxmlResourceInputStream, bos);
        InputStream jasperInputStream = new ByteArrayInputStream(bos.toByteArray());
        ServletOutputStream servletOutputStream = response.getOutputStream();
        response.setContentType("application/pdf");
        // 添加下面一行，将作为附件下载
        // 不添加下面一行，将页面作为pdf输出
//            response.setHeader("Content-disposition", "attachment;filename=report.pdf");
        JasperRunManager.runReportToPdfStream(jasperInputStream,
                servletOutputStream, parameters, dataSource);
        servletOutputStream.flush();
        servletOutputStream.close();

        jrxmlResourceInputStream.close();
        bos.close();
        jasperInputStream.close();
    }
}
