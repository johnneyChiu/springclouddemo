package com.cst.bigdata.service.hbase;

import com.cst.bigdata.repository.hbase.CstStreamHourStatisticsMapper;
import com.cst.bigdata.utils.HBaseTable;
import com.cst.bigdata.utils.RowKeyGenerate;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 18:09
 * @Description 小时统计服务
 */

@Service
public class CstStreamHourStatisticsService {

    @Autowired
    private CstStreamHourStatisticsMapper cstStreamHourStatisticsMapper;

    //get put Am hour data
    public AmHourTransfor getAmHourTransforDataByRowKey(String rowKey){
        return cstStreamHourStatisticsMapper.findAmHourTransforByRowKey(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,AmHourTransfor.class);
    }
    public void putAmHourTransforData(AmHourTransfor amHourTransfor,String rowKey){
        cstStreamHourStatisticsMapper.putAmHourTransfor(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,amHourTransfor);
    }

    //get put De hour data
    public DeHourTransfor getDeHourTransforDataByRowKey(String rowKey){
        return cstStreamHourStatisticsMapper.findDeHourTransforByRowKey(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,DeHourTransfor.class);
    }
    public void putDeHourTransforData(DeHourTransfor deHourTransfor,String rowKey){
        cstStreamHourStatisticsMapper.putDeHourTransfor(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,deHourTransfor);
    }

    //get put Gps Hour data
    public GpsHourTransfor getGpsHourTransforDataByRowKey(String rowKey){
        return cstStreamHourStatisticsMapper.findGpsHourTransforByRowKey(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,GpsHourTransfor.class);
    }
    public void putGpsHourTransforData(GpsHourTransfor gpsHourTransfor,String rowKey){
        cstStreamHourStatisticsMapper.putGpsHourTransfor(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,gpsHourTransfor);
    }

    //get put obd Hour data
    public ObdHourTransfor getObdHourTransforDataByRowKey(String rowKey){
        return cstStreamHourStatisticsMapper.findObdHourTransforByRowKey(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,ObdHourTransfor.class);
    }
    public void putObdHourTransforData(ObdHourTransfor obdHourTransfor,String rowKey){
        cstStreamHourStatisticsMapper.putObdHourTransfor(HBaseTable.HOUR_STATISTICS.getTableName(),
                HBaseTable.HOUR_STATISTICS.getFamilyName(),rowKey,obdHourTransfor);
    }


}
