package org.lyk.bootDemo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuankliu on 29/04/2018.
 */
@Entity
@Table(name = "dept")
public class Dept implements Serializable
{
    private static final long serialVersionUID = -6436054154962886546L;

    @Id
    @Column(name = "deptno")
    private String deptno;

    @Column(name = "dname")
    private String dname;

    @Column(name = "loc")
    private String loc;

    public Dept()
    {
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getDeptno()
    {
        return deptno;
    }

    public void setDeptno(String deptno)
    {
        this.deptno = deptno;
    }

    public String getDname()
    {
        return dname;
    }

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    public String getLoc()
    {
        return loc;
    }

    public void setLoc(String loc)
    {
        this.loc = loc;
    }

    @Override
    public String toString()
    {
        return "Dept{" +
                "deptno='" + deptno + '\'' +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
