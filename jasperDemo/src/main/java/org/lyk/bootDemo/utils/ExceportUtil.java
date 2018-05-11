package org.lyk.bootDemo.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


//import org.junit.Test;

/**
 * 使用demo
 * String[] title = new String[]{"ID","名字","性别","爱好","成绩","时间"};//表头
 * <p>
 * List<Object[]>  dataList = new ArrayList<Object[]>();
 * Object[] objs = null;
 * <p>
 * for(int i=0;i<list.size();i++){
 * StuPoiEntity sp= list.get(i);
 * objs = new Object[title.length];//长度为表头数组长度
 * <p>
 * objs[0]=sp.getStuId();
 * objs[1]=sp.getStuName();
 * objs[2]=sp.getStuSexImp();
 * objs[3]=sp.getStuHobbyImp();
 * objs[4]=sp.getStuCj();
 * objs[5]=sp.getStuDateImp();
 * <p>
 * dataList.add(objs);
 * }
 * <p>
 * <pre>项目名称：mjj_poi_two
 * 类名称：ExportExcelUtils
 * 类描述：
 * 创建ExportExcelUtils类，放入以下参数 调用exportData方法，可以直接响应前台实现下载，
 * private String title; // 导出表格的表名
 * private String[] rowName;// 导出表格的列名
 * private List<Object[]>  dataList = new ArrayList<Object[]>(); // 对象数组的List集合  写入的数据
 * private HttpServletResponse  response;  //响应前台 用来下载
 * <p>
 * 样式修改需要修改工具类内的方法
 * getColumnTopStyle为表头样式
 * getStyle为内容样式
 * <p>
 * 创建人：毛健健
 * 创建时间：2017年8月18日 下午8:38:00
 * 修改人：毛健健
 * 修改时间：2017年8月18日 下午8:38:00
 * 修改备注：
 *
 * @version </pre>
 */
public class ExceportUtil
{

    private String title; // 导出表格的表名

    private String[] rowName;// 导出表格的列名

    private List<Object[]> dataList = new ArrayList<Object[]>(); // 对象数组的List集合

    private HttpServletResponse response;  //响应前台 用来下载


    public ExceportUtil()
    {
        super();
    }


    public ExceportUtil(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response)
    {
        super();
        this.title = title;
        this.rowName = rowName;
        this.dataList = dataList;
        this.response = response;
    }


    // 导出数据
    public void exportData()
    {
        try
        {
            HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel对象  HSSFWorkbook
            HSSFSheet sheet = workbook.createSheet(title); // 创建表格  createSheet 并放入sheet页的名字 这里放入的表头的名字

            // 产生表格标题行
            HSSFRow rowm = sheet.createRow(0);  // 行
            HSSFCell cellTiltle = rowm.createCell(0);  // 单元格

            // sheet样式定义
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook); // 头样式
            HSSFCellStyle style = this.getStyle(workbook);  // 单元格样式
            /**
             * 参数说明
             * 从0开始   第一行 第一列 都是从角标0开始
             * 行 列 行列    (0,0,0,5)  合并第一行 第一列  到第一行 第六列
             * 起始行，起始列，结束行，结束列
             *   列的类型为short
             * new Region()  这个方法使过时的
             */
            // 合并第一行的所有列  而且放入表头标题
            sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) (rowName.length - 1)));
            cellTiltle.setCellStyle(columnTopStyle);  //放入表头样式
            cellTiltle.setCellValue(title);   //表头名字
            int columnNum = rowName.length;  // 表格列的长度
            HSSFRow rowRowName = sheet.createRow(1);  // 在第二行创建行
            HSSFCellStyle cells = workbook.createCellStyle();
            cells.setBottomBorderColor(HSSFColor.BLACK.index);
            rowRowName.setRowStyle(cells);

            // 循环 将列名放进去
            for (int i = 0; i < columnNum; i++)
            {
                HSSFCell cellRowName = rowRowName.createCell((int) i);
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 单元格类型

                HSSFRichTextString text = new HSSFRichTextString(rowName[i]);  // 得到列的值
                cellRowName.setCellValue(text); // 设置列的值
                cellRowName.setCellStyle(columnTopStyle); // 样式
            }
            /**
             * POI中的所有type参数都是POI规定的，只要应用就可以了
             * 表格参数 大概
             * CellType 	类型 	值
             CELL_TYPE_NUMERIC 	数值型 	0
             CELL_TYPE_STRING 	字符串型 	1
             CELL_TYPE_FORMULA 	公式型 	2
             CELL_TYPE_BLANK 	空值 	3
             CELL_TYPE_BOOLEAN 	布尔型 	4
             CELL_TYPE_ERROR 	错误 	5
             */

            // 将查询到的数据设置到对应的单元格中
            for (int i = 0; i < dataList.size(); i++)
            {
                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i + 2);//创建所需的行数  +2是为了跳过表头和标题
                for (int j = 0; j < obj.length; j++)
                {
                    HSSFCell cell = null;   //设置单元格的数据类型
                    if (j == 0)
                    {
                        // 第一列设置为序号
                        cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);  //数值类型
                        cell.setCellValue(i + 1);
                    } else
                    {
                        cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);  //字符串
                        if (!"".equals(obj[j]) && obj[j] != null)
                        {
                            cell.setCellValue(obj[j].toString());                       //设置单元格的值
                        } else
                        {
                            cell.setCellValue("  ");
                        }
                    }
                    cell.setCellStyle(style); // 样式
                }
            }


            if (workbook != null)
            {
                try
                {
                    // excel 表文件名  System.currentTimeMillis()获取系统时间的毫秒值做一个时间戳 防止名字重复
                    String fileName = title + ".xls";
                    String fileName11 = URLEncoder.encode(fileName, "UTF-8");  //设置编码格式 防止乱码
                    String headStr = "attachment; filename=\"" + fileName11 + "\"";   //filename为全文件名
                    System.out.println(headStr + "文件名");
                    /**
                     * response.setContentType(MIME)的作用是使客户端浏览器，
                     * 区分不同种类的数据，
                     * 并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
                     * 设置MIME的类型为APPLICATION/OCTET-STREAM
                     * response.setHeader()解决下载中文文件名乱码问题
                     *
                     */
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition", headStr);    //返回 文件全名

                    OutputStream out = response.getOutputStream();
                    workbook.write(out);  //写入文档
                    out.flush();
                    out.close();

                } catch (IOException e)
                {
                    e.printStackTrace();
                }

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    // 导出数据
    public void exportDataList()
    {

        try
        {
            HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel对象  HSSFWorkbook
            HSSFSheet sheet = workbook.createSheet(title); // 创建表格  createSheet 并放入sheet页的名字 这里放入的表头的名字

            // sheet样式定义
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook); // 头样式
            HSSFCellStyle style = this.getStyle(workbook);  // 单元格样式
            int columnNum = rowName.length;  // 表格列的长度
            HSSFRow rowRowName = sheet.createRow(0);  // 在第一行创建行
            HSSFCellStyle cells = workbook.createCellStyle();
            cells.setBottomBorderColor(HSSFColor.BLACK.index);
            rowRowName.setRowStyle(cells);
            // 循环 将列名放进去
            for (int i = 0; i < columnNum; i++)
            {
                HSSFCell cellRowName = rowRowName.createCell((int) i);
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 单元格类型

                HSSFRichTextString text = new HSSFRichTextString(rowName[i]);  // 得到列的值
                cellRowName.setCellValue(text); // 设置列的值
                cellRowName.setCellStyle(columnTopStyle); // 样式
            }
            // 将查询到的数据设置到对应的单元格中
            for (int i = 0; i < dataList.size(); i++)
            {
                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i + 1);//创建所需的行数  +1是为了跳过表头和标题
                for (int j = 0; j < obj.length; j++)
                {
                    HSSFCell cell = null;   //设置单元格的数据类型
                    cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);  //字符串
                    if (!"".equals(obj[j]) && obj[j] != null)
                    {
                        cell.setCellValue(obj[j].toString()); //设置单元格的值

                    } else
                    {
                        cell.setCellValue("");
                    }
                    cell.setCellStyle(style); // 样式
                    sheet.autoSizeColumn((short) j); //调整每列宽度自适应标题
                }
            }

            if (workbook != null)
            {
                try
                {
                    // excel 表文件名  System.currentTimeMillis()获取系统时间的毫秒值做一个时间戳 防止名字重复
                    String fileName = title + ".xls";
                    String fileName11 = URLEncoder.encode(fileName, "UTF-8");  //设置编码格式 防止乱码
                    String headStr = "attachment; filename=\"" + fileName11 + "\"";   //filename为全文件名
                    System.out.println(headStr + "文件名");
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition", headStr);    //返回 文件全名
                    OutputStream out = response.getOutputStream();
                    workbook.write(out);  //写入文档
                    out.flush();
                    out.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //表头样式
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook)
    {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字     Courier New 黑体
        font.setFontName("楷体");

        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    //内容样式的style
    public HSSFCellStyle getStyle(HSSFWorkbook workbook)
    {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }


}
