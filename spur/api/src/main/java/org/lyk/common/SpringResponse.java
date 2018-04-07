package org.lyk.common;

import java.io.Serializable;

/**
 * Created by yuankliu on 12/03/2018.
 */

public class SpringResponse<T> implements Serializable
{
    private SpringStatus status;
    private String message ;
    private String details;
    private T retVal;

    public SpringResponse()
    {
    }

    public SpringStatus getStatus()
    {
        return status;
    }

    public void setStatus(SpringStatus status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public T getRetVal()
    {
        return retVal;
    }

    public void setRetVal(T retVal)
    {
        this.retVal = retVal;
    }

    @Override
    public String toString()
    {
        return "SpringResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

