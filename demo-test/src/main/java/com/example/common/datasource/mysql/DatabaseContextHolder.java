package com.example.common.datasource.mysql;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }
}
