package com.example.common.datasource.mysql;

import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }

}
