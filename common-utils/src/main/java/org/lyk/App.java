package org.lyk;

import org.lyk.util.DataUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //大小数的四舍五入
        System.out.println(DataUtil.formatDouble(DataUtil.sishewuru(3453233.209D,2),"###,###.00"));
    }


    public static String convertDataToString(Double data)
    {
        DecimalFormat df = new DecimalFormat("###.00");
        if (Objects.isNull(data))
        {
            return "";
        }
        if (data.equals(0.0D))
        {
            return "0.00";
        }
        if (data.compareTo(1.0) < 0)
        {
            return "0" + String.valueOf(df.format(data));
        }

        return String.valueOf(df.format(data));
    }
}
