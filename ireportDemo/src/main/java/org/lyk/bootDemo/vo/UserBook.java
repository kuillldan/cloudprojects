package org.lyk.bootDemo.vo;

import java.io.Serializable;

/**
 * Created by yuankliu on 14/05/2018.
 */
public class UserBook implements Serializable
{
    private static final long serialVersionUID = -7937868498145621596L;

    private String userName;
    private Integer amount;

    public UserBook()
    {
    }

    public UserBook(String userName, Integer amount)
    {
        this.userName = userName;
        this.amount = amount;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}
