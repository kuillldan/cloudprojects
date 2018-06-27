package org.lyk.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Created by yuankliu on 15/05/2018.
 */
public class DataUtil
{
    /**
     * 对传入的参数以及制定的精度四舍五入
     * @param value
     * @param precession
     * @return
     */
    public static Double sishewuru(Double value, Integer precession)
    {
        //大小数的四舍五入
        BigDecimal bd = new BigDecimal(String.valueOf(value));
        return bd.divide(new BigDecimal("1"), precession, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * "###.00","###,###.00"
     * @param data
     * @param format
     * @return
     */
    public static String formatDouble(Double data,String format)
    {
        DecimalFormat df = new DecimalFormat(format);
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
