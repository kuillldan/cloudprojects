package org.lyk.bootDemo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;

/**
 * Created by yuankliu on 07/05/2018.
 */
public class ChinaFontProvide implements FontProvider
{

    @Override
    public Font getFont(String arg0, String arg1, boolean arg2, float arg3, int arg4, BaseColor arg5)
    {
        BaseFont bfChinese = null;
        try
        {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //也可以使用Windows系统字体(TrueType)
            //bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMYOU.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        Font FontChinese = new Font(bfChinese, 20, Font.NORMAL);
        return FontChinese;
    }

    @Override
    public boolean isRegistered(String arg0)
    {
        return false;
    }
}
