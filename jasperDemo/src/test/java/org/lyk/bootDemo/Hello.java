package org.lyk.bootDemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import javafx.scene.control.Cell;


import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by yuankliu on 07/05/2018.
 */
class Employee
{
    private String ename;
    private String salaryAccountNumber;
    private String empno;
    private String bankName;
    private String salaryYear;

    public Employee()
    {
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getSalaryAccountNumber()
    {
        return salaryAccountNumber;
    }

    public void setSalaryAccountNumber(String salaryAccountNumber)
    {
        this.salaryAccountNumber = salaryAccountNumber;
    }

    public String getEmpno()
    {
        return empno;
    }

    public void setEmpno(String empno)
    {
        this.empno = empno;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getSalaryYear()
    {
        return salaryYear;
    }

    public void setSalaryYear(String salaryYear)
    {
        this.salaryYear = salaryYear;
    }
}

public class Hello
{
    public static Map<String, Object> getSalaryInfo()
    {
        Map<String, Object> map = new HashMap<>();
        Employee employee = new Employee();
        employee.setEname("高虎");
        employee.setSalaryAccountNumber("622308654892874");
        employee.setEmpno("21591923");
        employee.setBankName("招商银行");
        employee.setSalaryYear("2018-04");
        map.put("employee", employee);
        return map;
    }

    public static void main(String[] args)
    {
        try
        {
//            Document document = new Document();
//            PdfWriter mPdfWriter = PdfWriter.getInstance(document, new FileOutputStream("C:\\D\\test.pdf"));
//            document.open();
////            String s = getHtml();
//            String s = readToString("C:\\E\\Received\\Wechat\\WeChat Files\\kuillldan\\Files\\portal_salary\\portal_salary\\pages\\test.html");
//            ByteArrayInputStream bin = new ByteArrayInputStream(s.getBytes());
//            XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, null, new ChinaFontProvide());
//            System.out.println("OK");
//            document.close();

//            Map<String, Object> map = new HashMap<>();
//            map.put("pb", new JSONObject());
//            map.put("approval", new com.alibaba.fastjson.JSONArray());
//            byte[] bytes = salaryPdfFile(getSalaryInfo());
//            OutputStream os = new FileOutputStream("c:\\d\\fapiao.pdf");
//            os.write(bytes);
//            os.close();

            Map<String,String> map = new LinkedHashMap<>();
            map.put("888","AAAA");
            map.put("111","BBBB");
            map.put("999","CCCC");
            map.put("222", "DDDD");

            Set<String> keys = map.keySet();
            for(String key : keys)
                System.out.println(map.get(key));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getHtml()
    {
        StringBuffer html = new StringBuffer();
        html.append("<div>咆哮的黄河</div>");
        html.append("<div><img src='http://www.photo0086.com/member/5758/pic/2013081217201520156.JPG'/></div>");

        return html.toString();
    }

    public static String readToString(String fileName)
    {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try
        {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e)
        {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static String getKeyByJson(JSONObject jo, String key)
    {
        return key;
    }

    public static byte[] salaryPdfFile(Map<String, Object> map) throws Exception
    {
        final String NEW_LINE = "\r\n";
        final String KOUJIAN_CODE = "DD";
        final String SHOURU_CODE = "ER";
        Employee employee = (Employee) map.get("employee");
        java.util.List<PortalSalary> portalSalaryList = (java.util.List<PortalSalary>) map.get("portalSalaryList");
        List<Map<String, Map<String, Double>>> incomeList = new ArrayList<>();
        for (PortalSalary portalSalary : portalSalaryList)
        {
            //循环每条记录取出收入大类 并且根据收入项目组成List
            if (SHOURU_CODE.equals(portalSalary.getcGpSecType()))
            {
                String shouruItem = portalSalary.getSecZhsDescr() + NEW_LINE + portalSalary.getSecEngDescr();
                if(!incomeList.contains(shouruItem))
                {
                    incomeList.add(null);
                }
            }
        }

        Document document = new Document(new RectangleReadOnly(842F, 595F));
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();

        Font titleFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
        titleFont.setSize(20f);
        titleFont.setStyle(Font.BOLD);

        Font employeeFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
        employeeFont.setSize(10f);

        Font normalFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
        normalFont.setSize(9);

        Font keyFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);

        Paragraph paragraph = new Paragraph("月度工资单", titleFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(10f);
        document.add(paragraph);

        String space = "                                                                     ";
        StringBuilder line1 = new StringBuilder("员工姓名:  ").append(employee.getEname());
        line1.append(space).append("    ");
        line1.append("工资银行账号:  ").append(employee.getSalaryAccountNumber());
        document.add(new Paragraph(line1.toString(), employeeFont));

        StringBuilder line2 = new StringBuilder("员工号:  ").append(employee.getEmpno());
        line2.append(space).append("银行名称:  ").append(employee.getBankName());
        document.add(new Paragraph(line2.toString(), employeeFont));

        StringBuilder line3 = new StringBuilder("发薪年度:  ").append(employee.getSalaryYear());
        document.add(new Paragraph(line3.toString(), employeeFont));

        PdfPTable table = new PdfPTable(14); // 3 columns.
        table.setWidthPercentage(100); // Width 100%
        table.setSpacingBefore(10f); // Space before table
        table.setSpacingAfter(10f); // Space after table

        int with1 = 60;
        int with2 = 40;
        int with3 = 40;
        table.setWidths(new int[]{with1, with2, with2, with2, with2, with2, with2, with2, with2, with2, with2, with2, with2, with1});

        GreenCell yuefenCell = new GreenCell(new Paragraph("月份", normalFont));
//        yuefenCell.setColspan(1);
        table.addCell(yuefenCell);
        table.addCell(new GreenCell(new Paragraph("一月\r\nJanuary", normalFont)));
        table.addCell(new GreenCell(new Paragraph("二月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("三月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("四月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("五月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("六月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("七月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("八月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("九月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("十月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("十一月", normalFont)));
        table.addCell(new GreenCell(new Paragraph("十二月", normalFont)));
        GreenCell nianhuizhongCell = new GreenCell(new Paragraph("年汇总", normalFont));
        table.addCell(nianhuizhongCell);


        PdfPCell colSpanCell = new SectionCell(new Paragraph("收入项目 Income Item", normalFont));
        colSpanCell.setColspan(14);
        table.addCell(colSpanCell);


        for (int i = 0; i < 10; i++)
        {
            table.addCell(new ItemCell(new Paragraph("基本工资\r\nBasic Salary", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("13723.89", normalFont)));
            table.addCell(new ItemCell(new Paragraph("999999.89", normalFont)));
        }


        document.add(table);

        document.close();

        byte[] b = baos.toByteArray();// 流转字节数据
        baos.close();// 关闭内存流

        return b;
    }

    /**
     * 根据发票信息生成发票信息pdf
     *
     * @param data
     * @return
     * @throws Exception
     */
    /**
     * 根据支付信息生成pdf
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] payPdfFile(Map<String, Object> data) throws Exception
    {
        JSONObject pb = (JSONObject) data.get("pb");// 获取发票普通信息
        JSONArray ja = (JSONArray) data.get("approval");// 获取审批历史信息

        Document document = new Document();
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();

//        BaseFont baseFont = BaseFont.createFont(ttfFilePath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
//                new Font(baseFont);
        font.setSize(10f);
        Font keyFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
//                new Font(baseFont);
        keyFont.setSize(10f);
        keyFont.setStyle(Font.BOLD);

        Font titleFont = new ChinaFontProvide().getFont(null, null, false, 0.2f, 2, null);
//                new Font(baseFont);
        titleFont.setSize(20f);
        titleFont.setStyle(Font.BOLD);
        Paragraph paragraph = new Paragraph("付款申请单", titleFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(10f);
        document.add(paragraph);

        // 提交时间
        String strDate = DateUtil.dateToString(new Date(), DateUtil.fm_yyyy_MM_dd_HHmmssSSS);
//                DateUtil.date2String("YYYY-MM-dd", new Date(pb.getJSONObject("payment").getLong("CREATEDTIME")));
        strDate = strDate == null ? "" : strDate;

        StringBuffer sb = new StringBuffer("付款单号： 	" + "FDSALFJDKSA");
        sb.append("   申请人： 	" + "高虎");
        sb.append("   提交时间：" + strDate);
        document.add(new Paragraph(sb.toString(), font));

        PdfPTable table = new PdfPTable(6); // 3 columns.
        table.setWidthPercentage(100); // Width 100%
        table.setSpacingBefore(10f); // Space before table
        table.setSpacingAfter(10f); // Space after table

        // getKeyByJson(pb.getJSONObject("payment"),"");
        table.addCell(new PdfPCell(new Paragraph("付款组织：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYORGNAME"), font)));
        table.addCell(new PdfPCell(new Paragraph("合作方名称：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PARNAME"), font)));
        table.addCell(new PdfPCell(new Paragraph("结算模式:", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "SETMAINBOENNAME"), font)));

//		table.addCell(new PdfPCell(new Paragraph("付款日期：", font)));
        table.addCell(new PdfPCell(new Paragraph("创建日期：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(strDate, font)));
        table.addCell(new PdfPCell(new Paragraph("合作方编号：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PARCODE"), font)));
        table.addCell(new PdfPCell(new Paragraph("付款方式：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYMETNAME"), font)));


        table.addCell(new PdfPCell(new Paragraph("付款币种：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYCURENNAME"), font)));
        table.addCell(new PdfPCell(new Paragraph("供应商地点：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "VENDORSITECODE"), font)));
        table.addCell(new PdfPCell(new Paragraph("票据到期日：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "BILLDUEDATE"), font)));

//		table.addCell(new PdfPCell(new Paragraph("支付银行账户：", font)));
//		table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYBANKACNAME"), font)));
//		table.addCell(new PdfPCell(new Paragraph("支付银行账号：", font)));
//		table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYBANKACNO"), font)));

        table.addCell(new PdfPCell(new Paragraph("付款金额：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYAMOUNT"), font)));
        table.addCell(new PdfPCell(new Paragraph("核算业务类型：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "ACBIZTYPEENNAME"), font)));
        table.addCell(new PdfPCell(new Paragraph("费用类型：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "CHARGENAME"), font)));

        table.addCell(new PdfPCell(new Paragraph("原币金额：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "ORICURAMOUNT"), font)));
        table.addCell(new PdfPCell(new Paragraph("合同编号：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "CONNUM"), font)));
        table.addCell(new PdfPCell(new Paragraph("商城结算单号：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "EMSTRANSNUM"), font)));

        table.addCell(new PdfPCell(new Paragraph("付款汇率：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(round(getKeyByJson(pb.getJSONObject("payment"), "PAYEXCHRATE")), font)));
        table.addCell(new PdfPCell(new Paragraph("结算单号：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "STTLEACCCODE"), font)));
        table.addCell(new PdfPCell(new Paragraph("结算单金额：", keyFont)));
        table.addCell(new PdfPCell(new Paragraph(round(getKeyByJson(pb.getJSONObject("payment"), "SETACCTOTAMT")), font)));

        table.addCell(new PdfPCell(new Paragraph("付款说明：", keyFont)));
        PdfPCell fksmcell = new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONObject("payment"), "PAYDESC"), font));
        fksmcell.setColspan(5);
        table.addCell(fksmcell);
        document.add(table);

        document.add(new Paragraph("清单信息", font));
        PdfPTable qdxx = new PdfPTable(9); // 3 columns.
        qdxx.setWidthPercentage(100); // Width 100%
        qdxx.setSpacingBefore(10f); // Space before table
        qdxx.setSpacingAfter(10f); // Space after table
        qdxx.addCell(new PdfPCell(new Paragraph("序号", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("收款方户名", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("收款方开户行名称", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("收款方账号", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("本次付款金额", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("原币金额", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("附件张数", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("ERP凭证号", keyFont)));
        qdxx.addCell(new PdfPCell(new Paragraph("红冲凭证号", keyFont)));
//        for (int i = 0; i < pb.getJSONArray("paymentList").size(); i++)
//        {
//            qdxx.addCell(new PdfPCell(new Paragraph((i + 1) + "", font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "RECACNAME"), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "RECBANKOFDE"), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "RECACNO"), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(round(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "THISPAOFFAMOUNT")), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(round(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "ORICURAMOUNT")), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "ATTSHEETS"), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "ERPVOUNUM"), font)));
//            qdxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentList").getJSONObject(i), "REVERSEDVOUNUM"), font)));
//        }
        document.add(qdxx);

        document.add(new Paragraph("审批历史", font));
        PdfPTable spls = new PdfPTable(4); // 3 columns.
        spls.setWidthPercentage(100); // Width 100%
        spls.setSpacingBefore(10f); // Space before table
        spls.setSpacingAfter(10f); // Space after table
        spls.addCell(new PdfPCell(new Paragraph("环节名称", keyFont)));
        spls.addCell(new PdfPCell(new Paragraph("审批人", keyFont)));
        spls.addCell(new PdfPCell(new Paragraph("审批时间", keyFont)));
        spls.addCell(new PdfPCell(new Paragraph("审批意见", keyFont)));
        for (int i = 0; i < ja.size(); i++)
        {
            // getKeyByJson(ja.getJSONObject(i),"checkTime") 提交时间
            spls.addCell(new PdfPCell(new Paragraph(getKeyByJson(ja.getJSONObject(i), "currentActivityInstName"), font)));
            spls.addCell(new PdfPCell(new Paragraph(getKeyByJson(ja.getJSONObject(i), "currentTaskHandManName"), font)));
            spls.addCell(new PdfPCell(new Paragraph(getKeyByJson(ja.getJSONObject(i), "checkTime"), font)));
            spls.addCell(new PdfPCell(new Paragraph(getKeyByJson(ja.getJSONObject(i), "approvalOpinion"), font)));
        }
        document.add(spls);

        document.add(new Paragraph("开票信息", font));
        PdfPTable kpxx = new PdfPTable(9); // 3 columns.
        kpxx.setWidthPercentage(100); // Width 100%
        kpxx.setSpacingBefore(10f); // Space before table
        kpxx.setSpacingAfter(10f); // Space after table
        kpxx.addCell(new PdfPCell(new Paragraph("开票编号", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("合同编号", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("合同名称", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("项目编号", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("结算单编号", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("订单编号", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("付款阶段", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("本次付款金额", keyFont)));
        kpxx.addCell(new PdfPCell(new Paragraph("开票日期", keyFont)));
//        for (int i = 0; i < pb.getJSONArray("paymentRelInvoiceMap").size(); i++)
//        {
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "BILLINGCODE"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "CONNUM"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "CONNAME"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "PRONUM"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "SETTLEACCCODE"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "PONUMBER"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "PAYSTAGENAME"), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(round(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "THISPAYAMOUNT")), font)));
//            kpxx.addCell(new PdfPCell(new Paragraph(getKeyByJson(pb.getJSONArray("paymentRelInvoiceMap").getJSONObject(i), "BILLINGDATETYPE"), font)));
//        }
        document.add(kpxx);

        document.close();

        byte[] b = baos.toByteArray();// 流转字节数据
        baos.close();// 关闭内存流

        return b;
    }

    private static String round(String keyByJson)
    {
        return "666.666";
    }

}
