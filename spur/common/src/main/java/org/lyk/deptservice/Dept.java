package org.lyk.deptservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Entity
public class Dept implements Serializable
{
    @Id
    private Long deptno;

    private String dname;

    private String loc;

    public Long getDeptno()
    {
        return deptno;
    }

    public void setDeptno(Long deptno)
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
        return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
                + "]";
    }
}
