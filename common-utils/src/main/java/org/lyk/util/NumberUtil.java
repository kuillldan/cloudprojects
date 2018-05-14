package org.lyk.util;

import java.math.BigDecimal;

/**
 * 保留俩位小数
 *
 * @author Administrator
 */
public class NumberUtil
{

    public static double KeepTwo(double f)
    {

        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
    public static float KeepTwo(float f)
    {

        BigDecimal b = new BigDecimal(f);
        float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return f1;
    }

    /**
     * 四舍五入取整数
     *
     * @return
     */
    public static Integer KeepRoundNumber(double f1)
    {

        Integer setScale = new BigDecimal(f1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

        return setScale;
    }

    public static double KeepTree(double f)
    {

        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    public static float KeepTree(float f)
    {
        BigDecimal b = new BigDecimal(f);
        float f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        return f1;
    }

}
