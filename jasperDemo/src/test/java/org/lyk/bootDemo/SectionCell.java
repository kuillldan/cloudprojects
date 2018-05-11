package org.lyk.bootDemo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Created by yuankliu on 07/05/2018.
 */
public class SectionCell extends PdfPCell
{
    public SectionCell(Phrase phrase)
    {
        super(phrase);
        this.setBackgroundColor(new BaseColor(217,231,220));
        this.setBorder(0);
        this.setFixedHeight(30);
        this.setBorderWidthTop(2);
        this.setBorderColorTop(BaseColor.WHITE);
        this.setUseAscender(true);
        this.setVerticalAlignment(this.ALIGN_MIDDLE);
    }
}
