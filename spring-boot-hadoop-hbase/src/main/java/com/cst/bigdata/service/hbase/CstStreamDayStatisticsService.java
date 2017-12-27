package com.cst.bigdata.service.hbase;

import com.cst.bigdata.repository.hbase.CstStreamDayStatisticsMapper;
import com.cst.bigdata.repository.hbase.CstStreamHourStatisticsMapper;
import com.cst.bigdata.utils.HBaseTable;
import com.cst.bigdata.utils.RowKeyGenerate;
import com.cst.stream.stathour.am.AmDayTransfor;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeDayTransfor;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsDayTransfor;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdDayTransfor;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 18:09
 * @Description 小时统计服务
 */

@Service
public class CstStreamDayStatisticsService {

    @Autowired
    private CstStreamDayStatisticsMapper cstStreamDayStatisticsMapper;

    //get put Am hour data
    public AmDayTransfor getAmDayTransforDataByRowKey(String rowKey){
        return cstStreamDayStatisticsMapper.findAmDayTransforByRowKey(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,AmDayTransfor.class);
    }
    public void putAmDayTransforData(AmDayTransfor amDayTransfor,String rowKey){
        cstStreamDayStatisticsMapper.putAmDayTransfor(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,amDayTransfor);
    }

    //get put De day data
    public DeDayTransfor getDeDayTransforDataByRowKey(String rowKey){
        return cstStreamDayStatisticsMapper.findDeDayTransforByRowKey(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,DeDayTransfor.class);
    }
    public void putDeDayTransforData(DeDayTransfor deDayTransfor,String rowKey){
        cstStreamDayStatisticsMapper.putDeDayTransfor(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,deDayTransfor);
    }

    //get put Gps Day data
    public GpsDayTransfor getGpsDayTransforDataByRowKey(String rowKey){
        return cstStreamDayStatisticsMapper.findGpsDayTransforByRowKey(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,GpsDayTransfor.class);
    }
    public void putGpsDayTransforData(GpsDayTransfor gpsDayTransfor,String rowKey){
        cstStreamDayStatisticsMapper.putGpsDayTransfor(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,gpsDayTransfor);
    }

    //get put obd day data
    public ObdDayTransfor getObdDayTransforDataByRowKey(String rowKey){
        return cstStreamDayStatisticsMapper.findObdDayTransforByRowKey(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,ObdDayTransfor.class);
    }
    public void putObdDayTransforData(ObdDayTransfor obdDayTransfor,String rowKey){
        cstStreamDayStatisticsMapper.putObdDayTransfor(HBaseTable.DAY_STATISTICS.getTableName(),
                HBaseTable.DAY_STATISTICS.getFamilyName(),rowKey,obdDayTransfor);
    }


}
