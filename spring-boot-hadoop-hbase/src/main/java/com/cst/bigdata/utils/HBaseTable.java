package com.cst.bigdata.utils;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 16:38
 * @Description Hbase的表配置
 */
public enum HBaseTable {



    HOUR_STATISTICS("cst_stream_hour_statistics", "info"),
    DAY_STATISTICS("cst_stream_day_statistics", "info");

    private String tableName;
    private String familyName;

    HBaseTable(String tableName, String familyName) {
        this.tableName = tableName;
        this.familyName = familyName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFamilyName() {
        return familyName;
    }
}
