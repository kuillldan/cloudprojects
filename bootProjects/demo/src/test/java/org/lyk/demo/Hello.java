package org.lyk.demo;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by yuankliu on 16/05/2018.
 */
public class Hello
{
    public static void main(String[] args)
    {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }
}
