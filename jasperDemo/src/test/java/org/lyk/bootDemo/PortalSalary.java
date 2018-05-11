package org.lyk.bootDemo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * @author pengdh
 * @date 2018/04/27
 */
@Entity
@Table(name = "PORTAL_SALARY", schema = "PORTAL")
public class PortalSalary implements Serializable
{

    private static final long serialVersionUID = -7949154344596053987L;

    private String emailAddr;
    private String monthName;
    private Long secSeq;
    private Long itemSeq;
    private String cGpSecType;
    private String secZhsDescr;
    private String secEngDescr;
    private String itemZhsDescr;
    private String itemEngDescr;
    private String dispalyZero;
    private Long amount;
    private Time lastUpdateDate;

    @Id
    @Column(name = "EMAIL_ADDR", nullable = true, length = 70)
    public String getEmailAddr()
    {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr)
    {
        this.emailAddr = emailAddr;
    }

    @Basic
    @Column(name = "MONTH_NAME", nullable = true, length = 30)
    public String getMonthName()
    {
        return monthName;
    }

    public void setMonthName(String monthName)
    {
        this.monthName = monthName;
    }

    @Basic
    @Column(name = "SEC_SEQ", nullable = true, precision = 0)
    public Long getSecSeq()
    {
        return secSeq;
    }

    public void setSecSeq(Long secSeq)
    {
        this.secSeq = secSeq;
    }

    @Basic
    @Column(name = "ITEM_SEQ", nullable = true, precision = 0)
    public Long getItemSeq()
    {
        return itemSeq;
    }

    public void setItemSeq(Long itemSeq)
    {
        this.itemSeq = itemSeq;
    }

    @Basic
    @Column(name = "C_GP_SEC_TYPE", nullable = true, length = 20)
    public String getcGpSecType()
    {
        return cGpSecType;
    }

    public void setcGpSecType(String cGpSecType)
    {
        this.cGpSecType = cGpSecType;
    }

    @Basic
    @Column(name = "SEC_ZHS_DESCR", nullable = true, length = 254)
    public String getSecZhsDescr()
    {
        return secZhsDescr;
    }

    public void setSecZhsDescr(String secZhsDescr)
    {
        this.secZhsDescr = secZhsDescr;
    }

    @Basic
    @Column(name = "SEC_ENG_DESCR", nullable = true, length = 254)
    public String getSecEngDescr()
    {
        return secEngDescr;
    }

    public void setSecEngDescr(String secEngDescr)
    {
        this.secEngDescr = secEngDescr;
    }

    @Basic
    @Column(name = "ITEM_ZHS_DESCR", nullable = true, length = 254)
    public String getItemZhsDescr()
    {
        return itemZhsDescr;
    }

    public void setItemZhsDescr(String itemZhsDescr)
    {
        this.itemZhsDescr = itemZhsDescr;
    }

    @Basic
    @Column(name = "ITEM_ENG_DESCR", nullable = true, length = 254)
    public String getItemEngDescr()
    {
        return itemEngDescr;
    }

    public void setItemEngDescr(String itemEngDescr)
    {
        this.itemEngDescr = itemEngDescr;
    }

    @Basic
    @Column(name = "DISPALY_ZERO", nullable = true, length = 3)
    public String getDispalyZero()
    {
        return dispalyZero;
    }

    public void setDispalyZero(String dispalyZero)
    {
        this.dispalyZero = dispalyZero;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = true, precision = 6)
    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE", nullable = true)
    public Time getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Time lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        PortalSalary that = (PortalSalary) o;

        if (emailAddr != null ? !emailAddr.equals(that.emailAddr) : that.emailAddr != null)
        {
            return false;
        }
        if (monthName != null ? !monthName.equals(that.monthName) : that.monthName != null)
        {
            return false;
        }
        if (secSeq != null ? !secSeq.equals(that.secSeq) : that.secSeq != null)
        {
            return false;
        }
        if (itemSeq != null ? !itemSeq.equals(that.itemSeq) : that.itemSeq != null)
        {
            return false;
        }
        if (cGpSecType != null ? !cGpSecType.equals(that.cGpSecType) : that.cGpSecType != null)
        {
            return false;
        }
        if (secZhsDescr != null ? !secZhsDescr.equals(that.secZhsDescr) : that.secZhsDescr != null)
        {
            return false;
        }
        if (secEngDescr != null ? !secEngDescr.equals(that.secEngDescr) : that.secEngDescr != null)
        {
            return false;
        }
        if (itemZhsDescr != null ? !itemZhsDescr.equals(that.itemZhsDescr)
                : that.itemZhsDescr != null)
        {
            return false;
        }
        if (itemEngDescr != null ? !itemEngDescr.equals(that.itemEngDescr)
                : that.itemEngDescr != null)
        {
            return false;
        }
        if (dispalyZero != null ? !dispalyZero.equals(that.dispalyZero) : that.dispalyZero != null)
        {
            return false;
        }
        if (amount != null ? !amount.equals(that.amount) : that.amount != null)
        {
            return false;
        }
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate)
                : that.lastUpdateDate != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = emailAddr != null ? emailAddr.hashCode() : 0;
        result = 31 * result + (monthName != null ? monthName.hashCode() : 0);
        result = 31 * result + (secSeq != null ? secSeq.hashCode() : 0);
        result = 31 * result + (itemSeq != null ? itemSeq.hashCode() : 0);
        result = 31 * result + (cGpSecType != null ? cGpSecType.hashCode() : 0);
        result = 31 * result + (secZhsDescr != null ? secZhsDescr.hashCode() : 0);
        result = 31 * result + (secEngDescr != null ? secEngDescr.hashCode() : 0);
        result = 31 * result + (itemZhsDescr != null ? itemZhsDescr.hashCode() : 0);
        result = 31 * result + (itemEngDescr != null ? itemEngDescr.hashCode() : 0);
        result = 31 * result + (dispalyZero != null ? dispalyZero.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        return result;
    }


    @Override
    public String toString()
    {
        return "PortalSalary{" +
                "emailAddr='" + emailAddr + '\'' +
                ", monthName='" + monthName + '\'' +
                ", secSeq=" + secSeq +
                ", itemSeq=" + itemSeq +
                ", cGpSecType='" + cGpSecType + '\'' +
                ", secZhsDescr='" + secZhsDescr + '\'' +
                ", secEngDescr='" + secEngDescr + '\'' +
                ", itemZhsDescr='" + itemZhsDescr + '\'' +
                ", itemEngDescr='" + itemEngDescr + '\'' +
                ", dispalyZero='" + dispalyZero + '\'' +
                ", amount=" + amount +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}

