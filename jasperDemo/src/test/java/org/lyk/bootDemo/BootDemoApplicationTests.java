package org.lyk.bootDemo;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemoApplicationTests
{

    @Test
    public void contextLoads()
    {
        try
        {
            //第一步，创建一个 iTextSharp.text.Document对象的实例：
            Document document = new Document();
            //第二步，为该Document创建一个Writer实例：
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\D\\HelloWorld2.pdf"));
            //第三步，打开当前Document
            document.open();
            //第四步，为当前Document添加内容：
            //document.add(new Paragraph("Hello World"));
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("C:\\E\\Received\\Wechat\\WeChat Files\\kuillldan\\Files\\portal_salary\\portal_salary\\pages\\test.html"));
            //第五步，关闭Document
            document.close();
            System.out.println( "OK!" );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
