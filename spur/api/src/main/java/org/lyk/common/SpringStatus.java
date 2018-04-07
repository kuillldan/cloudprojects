package org.lyk.common;

import java.io.Serializable;

/**
 * Created by yuankliu on 12/03/2018.
 */
public enum SpringStatus implements Serializable
{
    /**
     * 系统内部异常
     */
    EXCEPTION,
    /**
     * 操作成功
     */
    SUCCESS,
    /**
     * 系统没有异常,但是执行失败
     */
    FAILED,
    /**
     * 参数验证错误
     */
    PARAMETER_VALIDATION_FAILED,
    /**
     * 熔断异常
     */
    HYSTRIX
}
