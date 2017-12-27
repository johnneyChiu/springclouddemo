package com.cst.bigdata.utils;

import com.cst.stream.common.DateTimeUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 18:17
 * @Description rowkey生成
 */
public class RowKeyGenerate {

    public static String getRowKeyById(String id, Long time, Constants.TIME_SELECT time_select){
        String headKey=MD5Hash.getMD5AsHex(Bytes.toBytes(id));
        long changeTime = 0;
        switch (time_select){
            case DAY:
                changeTime= DateTimeUtil.getDayBase(time);
                break;
            case HOUR:
                changeTime = DateTimeUtil.getHourBase(time);
                break;
            case MONTH:
                changeTime = DateTimeUtil.getMonthBase(time);
                break;
        }
        String result = String.format("%s_%d", headKey, Long.MAX_VALUE - changeTime);
        return result;
    }

}
