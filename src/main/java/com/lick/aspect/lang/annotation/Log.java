package com.lick.aspect.lang.annotation;

import com.lick.aspect.lang.enums.BusinessType;

import java.lang.annotation.*;

/**
 * 自定义操作记录注解
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

}
