package org.lyk;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Double base = 40.0D;
        Double p = 1.05D;
        for(int i = 1; i <= 100; i++)
        {
            base *= p;
            System.out.println(i + ":" + base);
        }
    }
}