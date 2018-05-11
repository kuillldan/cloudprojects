package org.lyk.bootDemo;


/**
 * Created by jackliu on 09/11/2017.
 *
 * @Description 字符串工具类
 */
public class StringUtil
{

    /**
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value)
    {
        if (null == value || "".equals(value) || "null".equalsIgnoreCase(value))
            return true;
        else
            return false;
    }

    /**
     * 将多个字符串用seperator连接
     * @param seperator
     * @param fields
     * @return
     */
    public static String combineString(String seperator, String... fields)
    {
        if (StringUtil.isEmpty(seperator))
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
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(String value)
    {
        return !isEmpty(value);
    }

    /**
     * 首字母转换为大写
     *
     * @param value
     * @return
     */
    public static String initString(String value)
    {
        if (isEmpty(value))
            return null;

        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    /**
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isNullEmpty(String value)
    {
        if (null == value || "".equals(value) || "null".equals(value))
            return true;
        else
            return false;
    }

    /**
     * 去掉带.的字符串
     * 例子: 55.0 变成 55
     *
     * @param value
     */
    public static String removeDigits(String value)
    {
        if (!isNullEmpty(value))
        {
            int DigitsIndex = value.indexOf(".");
            if (DigitsIndex > 0)
            {
                return value.substring(0, DigitsIndex);
            }
        }
        return value;
    }


    public static Boolean equals(String str1,String str2)
    {
        if(isEmpty(str1) && !isEmpty(str2))
        {
            return false;
        }

        if(isEmpty(str1) && isEmpty(str2))
        {
            return true;
        }

        if(!isEmpty(str1) && !isEmpty(str2))
        {
            return str1.equals(str2);
        }

        if(!isEmpty(str1) && isEmpty(str2))
        {
            return false;
        }

        return false;
    }
    
}
