package org.lyk.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jackliu on 09/11/2017.
 *
 * @Description 时间与日期的工具类
 */

public class DateUtil
{

    // ** yyyyMMddHHmmssSSS
    public static final String fm_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    // ** yyyy-MM-dd HH:mm:ss.SSS
    public static final String fm_yyyy_MM_dd_HHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";

    // ** yyyyMMddHHmmss
    public static final String fm_yyyyMMddHHmmss = "yyyyMMddHHmmss";

    // ** yyyy-MM-dd HH:mm:ss
    public static final String fm_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";

    // ** yyyyMMdd
    public static final String fm_yyyyMMdd = "yyyyMMdd";

    //** yyyy-MM
    public static final String fm_yyyy_MM = "yyyy-MM";

    // ** yyyy-MM-dd
    public static final String fm_yyyy_MM_dd = "yyyy-MM-dd";

    // ** yyyy/MM/dd
    public static final String fmx_yyyy_MM_dd = "yyyy/MM/dd";

    // ** yyyy-MM.dd
    public static final String fmp_yyyy_MM_dd = "yyyy-MM.dd";

    // ** MM.dd
    public static final String fm_MM_dd = "MM.dd";

    // ** yyyy年MM月dd日
    public static final String cn_yyyyMMdd = "yyyy年MM月dd日";

    // ** MM月dd日
    public static final String cn_MMdd = "MM月dd日";

    /**
     * 去除时分秒
     *
     * @param cur 待处理日期
     * @return 只包含年月日的日期
     */
    public static Date parse(Date cur)
    {
        if (cur == null)
        {
            return cur;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(cur);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 字符串转成日期
     *
     * @param cur 日期字符串
     * @param fm  format格式
     * @return
     */
    public static Date stringToDate(String cur, String fm)
    {
        if (StringUtil.isEmptyOrBlank(cur))
            return null;

        if (StringUtil.isEmptyOrBlank(fm))
            fm = fm_yyyyMMdd;

        try
        {
            return new SimpleDateFormat(fm).parse(cur);
        } catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期转字符串
     *
     * @param cur 日期
     * @param fm  格式(DateTimeUtil.fmx_yyyy_MM_dd ...)
     * @return 日期字符
     */
    public static String dateToString(Date cur, String fm)
    {
        if (cur == null)
            cur = Calendar.getInstance().getTime();

        if (StringUtil.isEmptyOrBlank(fm))
            fm = fm_yyyyMMdd;

        return new SimpleDateFormat(fm).format(cur);
    }

    /**
     * 得到前面某一天的日期
     *
     * @param cur 当前日期
     * @param num 前天多少天
     * @return 前面某一天的日期
     */
    public static Date getBeginDate(Date cur, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.DATE, -num);
        return c.getTime();
    }

    /**
     * 得到后面某一天的日期
     *
     * @param cur 当前日期
     * @param num 后面多少天
     * @return 后面某一天的日期
     */
    public static Date getAfterDate(Date cur, int num)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.DATE, num);
        return getBeginDate(cur, 1);
    }

    /**
     * 当前日期时间  + 后面多少天
     *
     * @param date 当前日期
     * @param num  后面多少天
     * @return 后面某一天的日期
     */
    public static Date getNextDay(Date date, int num)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        date = calendar.getTime();
        return date;
    }

    /**
     * 得到前一天的日期
     *
     * @param cur 当前日期
     * @return 前一天日期（昨天）
     */
    public static Date yesterday(Date cur)
    {
        return getBeginDate(cur, 1);
    }

    /**
     * 得到明天的日期
     *
     * @param cur 当前日期
     * @return 明天日期
     */
    public static Date tomorrow(Date cur)
    {
        return getAfterDate(cur, 1);
    }

    /**
     * 根据某日期得到当月第一天日期
     *
     * @param cur 日期
     * @return 当月第一天
     */
    public static Date firstDayOfMonth(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 根据某日期得到上月第一天日期
     *
     * @param cur 日期
     * @return 上月第一天
     */
    public static Date firstDayOfLastMonth(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 根据某日期得到当周第一天日期
     *
     * @param cur 日期
     * @return 当周第一天(星期一)
     */
    public static Date firstDayOfWeek(Date cur)
    {
        Calendar cd = Calendar.getInstance();
        cd.setFirstDayOfWeek(Calendar.MONDAY);// 中国周一为一周内的第一天
        cd.setTime(cur);
        cd.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cd.getTime();
    }

    /**
     * 获取某日期上周第一天日期
     *
     * @param cur 日期
     * @return 上周第一天日期（周一）
     */
    public static Date firstDayOfLastWeek(Date cur)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 中国周一为一周内的第一天
        calendar.setTime(cur);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取某日期上周最后一天日期
     *
     * @param cur 日期
     * @return 上周最后一天日期（周日）
     */
    public static Date lastDayOfLastWeek(Date cur)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 中国周一为一周内的第一天
        calendar.setTime(cur);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 根据某日期得到上周同一天日期
     *
     * @param cur 日期
     * @return 上周同一天
     */
    public static Date curDayOfLastWeek(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.WEEK_OF_YEAR, -1);
        return c.getTime();
    }

    /**
     * 根据某日期得到两周前的同一天日期
     *
     * @param cur 日期
     * @return 两周前的同一天
     */
    public static Date curDayOflastTwoWeek(Date cur)
    {
        return curDayOfLastWeek(curDayOfLastWeek(cur));
    }

    /**
     * 根据某日期得到上个月同一天日期
     *
     * @param cur 日期
     * @return 上个月同一天
     */
    public static Date curDayOfLastMonth(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 根据某日期得到上两个月同一天日期
     *
     * @param cur 日期
     * @return 上两个月同一天
     */
    public static Date curDayOfLastTwoMonth(Date cur)
    {
        return curDayOfLastMonth(curDayOfLastMonth(cur));
    }

    /**
     * 根据某日期得到去年同一天
     *
     * @param cur 日期
     * @return 去年同一天对应的日期
     */
    public static Date curDayOfLastYear(Date cur)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cur);
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }

    /**
     * 根据某日期得到上一年同一天对应的周一日期
     *
     * @param cur 日期
     * @return 上一年同一天对应的周一日期
     */
    public static Date firstDayOfWeekByLastYear(Date cur)
    {
        return firstDayOfWeek(curDayOfLastYear(cur));
    }

    /**
     * 判断某日期是不是周一
     *
     * @param cur 当前日期
     * @return true为周一，默认false
     */
    public static boolean curDateIsMonday(Date cur)
    {
        Calendar cd = Calendar.getInstance();
        cd.setTime(cur);
        if (cd.get(Calendar.DAY_OF_WEEK) == 2)
            return true;
        return false;
    }

    /**
     * 根据某日期得到年份
     *
     * @param cur 日期
     * @return 年份
     */
    public static int getOfYear(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        return c.get(Calendar.YEAR);
    }

    /**
     * 根据某日期得到月份
     *
     * @param cur 日期
     * @return 月份
     */
    public static int getOfMonth(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        return c.get(Calendar.MONTH) + 1;// 月份下标从0开始
    }

    /**
     * 根据某日期得到日期是当月的哪一号（哪一天）
     *
     * @param cur 日期
     * @return 当月第几天
     */
    public static int getDayOfMonth(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据某日期得到星期
     *
     * @param cur 日期
     * @return 星期几(1, 2, 3, 4, 5, 6, 7)
     */
    public static int getDayOfWeek(Date cur)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 自定义创建一个日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return 日期
     */
    public static Date createCustomDate(int year, int month, int day)
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 根据开始时间、结束时间得到两个时间段内所有的日期(包含开始日期与结束日期)
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 两个日期之间的日期
     */
    public static List<Date> getDateRangeList(Date start, Date end)
    {
        ArrayList<Date> ret = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();
        long endTime = end.getTime();
        while (tmpDate.before(end) || tmpDate.getTime() == endTime)
        {
            ret.add(parse(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            tmpDate = calendar.getTime();
        }
        return ret;
    }

    /**
     * @param cur 英文日期字符,如：{Mar 1, 2013}
     * @return 日期
     * @throws ParseException
     */
    public static Date englishStringToDate(String cur) throws ParseException
    {
        try
        {
            // cur = "Sun Nov 13 21:56:41 +0800 2011";
            if (StringUtil.isEmptyOrBlank(cur))
                return null;
            return new SimpleDateFormat("MMM dd, yyyy", Locale.US).parse(cur);
        } catch (ParseException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 判断是不是在时间区间内：
     *
     * @param cur  要判断的时间
     * @param from 开始时间
     * @param to   结束时间
     * @return true=[from <= cur < to]，false=反之则返回false
     */
    public static boolean isBetween(Date cur, Date from, Date to)
    {
        if (null == cur || null == from || null == to)
        {
            return false;
        }
        Calendar _cur = Calendar.getInstance();
        _cur.setTime(cur);

        Calendar c = Calendar.getInstance();
        c.setTime(from);

        int result = _cur.compareTo(c);
        if (result > 0)
        {
            // 大于开始时间
            c.setTime(to);
            result = _cur.compareTo(c);
            if (result < 0)
            {
                return true;
            }
        }
        return false;
    }

    // public static void main(String[] args) {
    // Date currentTime = Calendar.getInstance().getTime();
    // Date temp = firstDayOfMonth(currentTime);
    // Date date = parse(temp);
    // System.out.println(dateToString(date, fm_yyyy_MM_dd_HHmmssSSS));
    // }


    /**
     * 获取明天0时0分的时间
     * 如现在是2018年01月30日
     * 返回值就是2018年01月31日00时00分00秒000毫秒的时间
     *
     * @return
     */
    public static Date getTomorrowStart()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date = calendar.getTime();
        String dateInString = DateUtil.dateToString(date, "yyyy-MM-dd");
        Date dateOfTomorrow = DateUtil.stringToDate(dateInString + " 00:00:00.000", "yyyy-MM-dd HH:mm:ss.SSS");
        return dateOfTomorrow;
    }

    /**
     * 获取今天0时0分的时间
     * 如现在是2018年01月30日
     * 返回值就是2018年01月30日00时00分00秒000毫秒的时间
     *
     * @return
     */
    public static Date getTodayStart()
    {
        String dateInString = DateUtil.dateToString(new Date(), "yyyy-MM-dd");
        Date todayStart = DateUtil.stringToDate(dateInString + " 00:00:00.000", "yyyy-MM-dd HH:mm:ss.SSS");
        return todayStart;
    }

    public static Date getTodayEnd()
    {
        String dateInString = DateUtil.dateToString(new Date(), "yyyy-MM-dd");
        Date todayStart = DateUtil.stringToDate(dateInString + " 23:59:59.000", "yyyy-MM-dd HH:mm:ss.SSS");
        return todayStart;
    }

    public static Date convertFirstSecondOfDate(Date date)
    {
        if (date == null)
        {
            return null;
        }
        String dateInString = DateUtil.dateToString(date, "yyyy-MM-dd");
        Date todayStart = DateUtil.stringToDate(dateInString + " 00:00:00.000", "yyyy-MM-dd HH:mm:ss.SSS");
        return todayStart;
    }

    public static Date convertLastSecondOfDate(Date date)
    {
        if (date == null)
        {
            return null;
        }
        String dateInString = DateUtil.dateToString(date, "yyyy-MM-dd");
        Date todayEnd = DateUtil.stringToDate(dateInString + " 23:59:59.000", "yyyy-MM-dd HH:mm:ss.SSS");
        return todayEnd;
    }

    /**
     * 获取输入日期当天的凌晨0点0分0秒的日期
     *
     * @param date
     * @return
     */
    public static Date getDateStart(Date date)
    {
        if (date == null)
        {
            System.out.println("指定日期为空!");
            return null;
        }

        String dateInString = DateUtil.dateToString(date, "yyyy-MM-dd");
        dateInString += " 00:00:00.000";
        Date dateStart = DateUtil.stringToDate(dateInString, "yyyy-MM-dd HH:mm:ss.SSS");
        return dateStart;
    }

    /**
     * 获取输入日期当天晚上23点59分59秒999毫秒的日期
     *
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date)
    {
        if (null == date)
        {
            System.out.println("指定日期为空!");
            return null;
        }

        String dateInString = DateUtil.dateToString(date, "yyyy-MM-dd");
        dateInString += " 23:59:59.999";
        Date dateStart = DateUtil.stringToDate(dateInString, "yyyy-MM-dd HH:mm:ss.SSS");
        return dateStart;

    }

    /**
     * 计算两个日期之间相差几天
     *
     * @param begin 开始
     * @param end   结束
     * @return 相差天数
     */
    public static int getDifferentDays(Date begin, Date end)
    {
        int days = (int) ((end.getTime() - begin.getTime()) / (1000 * 3600 * 24));
        return days;
    }
}
