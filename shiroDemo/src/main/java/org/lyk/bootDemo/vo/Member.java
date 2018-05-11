package org.lyk.bootDemo.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuankliu on 03/05/2018.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable
{
    private static final long serialVersionUID = 6219100374816582013L;

    @Id
    private String mid;
    private String password;
    private String name;
    private Integer locked;

    public Member()
    {
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getMid()
    {
        return mid;
    }

    public void setMid(String mid)
    {
        this.mid = mid;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getLocked()
    {
        return locked;
    }

    public void setLocked(Integer locked)
    {
        this.locked = locked;
    }

    @Override
    public String toString()
    {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", locked=" + locked +
                '}';
    }
}
