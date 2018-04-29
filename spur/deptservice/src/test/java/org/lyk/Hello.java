package org.lyk;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuankliu on 26/04/2018.
 */
public class Hello
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\D\\other\\somthing.txt");
        FileChannel fc = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(20);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Integer bytesReaded = 0;
        while((bytesReaded = fc.read(buffer)) != -1)
        {
            buffer.flip();
            while(buffer.hasRemaining())
            {
                bos.write(buffer.get());
            }
            buffer.clear();
        }
        System.out.println(new String(bos.toByteArray()));
        fc.close();
    }
}
