package com.dhc.logRecord;

import java.lang.annotation.*;

/**
 * Created by DuHongcai on 2016/11/15.
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServliceLog {
    String description() default "";
}
