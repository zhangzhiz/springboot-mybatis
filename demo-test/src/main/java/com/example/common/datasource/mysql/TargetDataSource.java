package com.example.common.datasource.mysql;

import java.lang.annotation.*;

/**
 * Created by zhangzhizhong on 2017/4/20.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
