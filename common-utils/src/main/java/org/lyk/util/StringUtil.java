package org.lyk.util;


import java.util.Random;

/**
 * Created by jackliu on 09/11/2017.
 *
 * @Description 字符串工具类
 */
public class StringUtil
{

    private static final Random random = new Random();
    /**
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmptyOrBlank(String value)
    {

        if (null == value || "".equals(value) || "null".equalsIgnoreCase(value))
            return true;

        String newValue = value.replaceAll(" ","").replaceAll("\t","").replaceAll("\r","").replaceAll("\n","");
        if("".equals(newValue))
            return true;
        else
            return false;
    }

    /**
     * 将多个字符串用seperator连接
     *
     * @param seperator
     * @param fields
     * @return
     */
    public static String combineString(String seperator, String... fields)
    {
        if (StringUtil.isEmptyOrBlank(seperator))
            return null;

        if (fields == null || fields.length == 0)
            return null;
        StringBuffer retVal = new StringBuffer();
        for (String field : fields)
        {
            retVal.append(field).append(seperator);
        }
        return retVal.delete(retVal.length() - 1, retVal.length()).toString();
    }

    /**
     * 首字母转换为大写
     *
     * @param value
     * @return
     */
    public static String initString(String value)
    {
        if (isEmptyOrBlank(value))
            return null;

        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    /**
     * 去掉带.的字符串
     * 例子: 55.0 变成 55
     *
     * @param value
     */
    public static String removeDigits(String value)
    {
        if (!isEmptyOrBlank(value))
        {
            int DigitsIndex = value.indexOf(".");
            if (DigitsIndex > 0)
            {
                return value.substring(0, DigitsIndex);
            }
        }
        return value;
    }


    /**
     * 生成指定长度的随之字符串
     * 该字符串由随机的字符或数字组成
     * @param length 指定要生成的随机字符串的长度
     * @return
     */
    public static String getRandomCharAndNumr(Integer length)
    {
        String str = "";
        for (int i = 0; i < length; i++)
        {
            boolean b = random.nextBoolean();
            if (b)
            { // 字符串
                // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
                str += (char) (65 + random.nextInt(26));// 取得大写字母
            } else
            { // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }


}
