package org.lyk.bootDemo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Created by yuankliu on 07/05/2018.
 */
public class GreenCell extends PdfPCell
{
    public GreenCell(Phrase phrase)
    {
        super(phrase);

        this.setBorder(0);
        this.setBackgroundColor(new BaseColor(61, 139, 79));
        this.setFixedHeight(30);
        this.setHorizontalAlignment(1);
        this.setUseAscender(true);
        this.setVerticalAlignment(this.ALIGN_MIDDLE);

        this.setBorderWidthTop(2);
        this.setBorderColorTop(BaseColor.WHITE);
    }
}
