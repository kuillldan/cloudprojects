package org.lyk.bootDemo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Created by yuankliu on 07/05/2018.
 */
public class ItemCell extends PdfPCell
{

    public ItemCell(Paragraph paragraph)
    {
        super(paragraph);
        this.setBackgroundColor(new BaseColor(243, 248, 245));
        this.setBorder(0);
        this.setFixedHeight(25);
        this.setHorizontalAlignment(1);
        this.setUseAscender(true);
        this.setVerticalAlignment(this.ALIGN_MIDDLE);

        this.setBorderWidthTop(2);
        this.setBorderColorTop(BaseColor.WHITE);
    }
}
