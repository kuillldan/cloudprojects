package org.lyk.bootDemo;

import org.lyk.util.StringUtil;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Created by yuankliu on 11/05/2018.
 */
public class Hello
{
    public static void main(String[] args) throws Exception
    {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(0));
    }
}
