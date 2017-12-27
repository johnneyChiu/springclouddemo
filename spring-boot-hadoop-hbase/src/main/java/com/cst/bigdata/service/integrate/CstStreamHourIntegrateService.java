package com.cst.bigdata.service.integrate;

import com.cst.bigdata.service.hbase.CstStreamDayStatisticsService;
import com.cst.bigdata.service.hbase.CstStreamHourStatisticsService;
import com.cst.bigdata.utils.Constants;
import com.cst.bigdata.utils.RowKeyGenerate;
import com.cst.stream.common.BaseResult;
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
 * create on 2017/12/21 15:17
 * @Description 整合的天数据整理
 */
@Service
public class CstStreamHourIntegrateService {

    @Autowired
    private CstStreamHourStatisticsService cstStreamHourStatisticsService;

    public BaseResult<AmHourTransfor> getAmHourTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.HOUR);
        AmHourTransfor amHourTransfor = cstStreamHourStatisticsService.getAmHourTransforDataByRowKey(rowKey);
        return BaseResult.success(amHourTransfor);
    }

    public BaseResult<AmHourTransfor> putAmHourTransfor(AmHourTransfor amHourTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(amHourTransfor.getCarId(),amHourTransfor.getTime(), Constants.TIME_SELECT.HOUR);
        cstStreamHourStatisticsService.putAmHourTransforData(amHourTransfor,rowKey);
        return BaseResult.success();
    }


    public BaseResult<DeHourTransfor> getDeHourTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.HOUR);
        DeHourTransfor deHourTransfor = cstStreamHourStatisticsService.getDeHourTransforDataByRowKey(rowKey);
        return BaseResult.success(deHourTransfor);
    }

    public BaseResult<DeHourTransfor> putDeHourTransfor(DeHourTransfor deHourTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(deHourTransfor.getCarId(),deHourTransfor.getTime(), Constants.TIME_SELECT.HOUR);
        cstStreamHourStatisticsService.putDeHourTransforData(deHourTransfor,rowKey);
        return BaseResult.success();
    }

    public BaseResult<GpsHourTransfor> getGpsHourTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.HOUR);
        GpsHourTransfor gpsHourTransfor = cstStreamHourStatisticsService.getGpsHourTransforDataByRowKey(rowKey);
        return BaseResult.success(gpsHourTransfor);
    }

    public BaseResult<GpsHourTransfor> putGpsHourTransfor(GpsHourTransfor gpsHourTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(gpsHourTransfor.getCarId(),gpsHourTransfor.getTime(), Constants.TIME_SELECT.HOUR);
        cstStreamHourStatisticsService.putGpsHourTransforData(gpsHourTransfor,rowKey);
        return BaseResult.success();
    }

    public BaseResult<ObdHourTransfor> getObdHourTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.HOUR);
        ObdHourTransfor obdHourTransfor = cstStreamHourStatisticsService.getObdHourTransforDataByRowKey(rowKey);
        return BaseResult.success(obdHourTransfor);
    }

    public BaseResult<ObdHourTransfor> putObdHourTransfor(ObdHourTransfor obdHourTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(obdHourTransfor.getCarId(),obdHourTransfor.getTime(), Constants.TIME_SELECT.HOUR);
        cstStreamHourStatisticsService.putObdHourTransforData(obdHourTransfor,rowKey);
        return BaseResult.success();
    }

}
