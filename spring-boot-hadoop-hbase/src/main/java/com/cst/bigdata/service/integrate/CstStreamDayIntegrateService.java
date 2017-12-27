package com.cst.bigdata.service.integrate;

import com.cst.bigdata.service.hbase.CstStreamDayStatisticsService;
import com.cst.bigdata.utils.Constants;
import com.cst.bigdata.utils.RowKeyGenerate;
import com.cst.stream.common.BaseResult;
import com.cst.stream.stathour.am.AmDayTransfor;
import com.cst.stream.stathour.de.DeDayTransfor;
import com.cst.stream.stathour.gps.GpsDayTransfor;
import com.cst.stream.stathour.obd.ObdDayTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Johnney.chiu
 * create on 2017/12/21 15:17
 * @Description 整合的天数据整理
 */
@Service
public class CstStreamDayIntegrateService {

    @Autowired
    private CstStreamDayStatisticsService cstStreamDayStatisticsService;

    public BaseResult<AmDayTransfor> getAmDayTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.DAY);
        AmDayTransfor amDayTransfor = cstStreamDayStatisticsService.getAmDayTransforDataByRowKey(rowKey);
        return BaseResult.success(amDayTransfor);
    }

    public BaseResult<AmDayTransfor> putAmDayTransfor(AmDayTransfor amDayTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(amDayTransfor.getCarId(),amDayTransfor.getTime(), Constants.TIME_SELECT.DAY);
        cstStreamDayStatisticsService.putAmDayTransforData(amDayTransfor,rowKey);
        return BaseResult.success();
    }


    public BaseResult<DeDayTransfor> getDeDayTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.DAY);
        DeDayTransfor deDayTransfor = cstStreamDayStatisticsService.getDeDayTransforDataByRowKey(rowKey);
        return BaseResult.success(deDayTransfor);
    }

    public BaseResult<DeDayTransfor> putDeDayTransfor(DeDayTransfor deDayTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(deDayTransfor.getCarId(),deDayTransfor.getTime(), Constants.TIME_SELECT.DAY);
        cstStreamDayStatisticsService.putDeDayTransforData(deDayTransfor,rowKey);
        return BaseResult.success();
    }

    public BaseResult<GpsDayTransfor> getGpsDayTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.DAY);
        GpsDayTransfor gpsDayTransfor = cstStreamDayStatisticsService.getGpsDayTransforDataByRowKey(rowKey);
        return BaseResult.success(gpsDayTransfor);
    }

    public BaseResult<GpsDayTransfor> putGpsDayTransfor(GpsDayTransfor gpsDayTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(gpsDayTransfor.getCarId(),gpsDayTransfor.getTime(), Constants.TIME_SELECT.DAY);
        cstStreamDayStatisticsService.putGpsDayTransforData(gpsDayTransfor,rowKey);
        return BaseResult.success();
    }

    public BaseResult<ObdDayTransfor> getObdDayTransfor(String carId, Long time){
        String rowKey = RowKeyGenerate.getRowKeyById(carId, time, Constants.TIME_SELECT.DAY);
        ObdDayTransfor obdDayTransfor = cstStreamDayStatisticsService.getObdDayTransforDataByRowKey(rowKey);
        return BaseResult.success(obdDayTransfor);
    }

    public BaseResult<ObdDayTransfor> putObdDayTransfor(ObdDayTransfor obdDayTransfor){
        String rowKey = RowKeyGenerate.getRowKeyById(obdDayTransfor.getCarId(),obdDayTransfor.getTime(), Constants.TIME_SELECT.DAY);
        cstStreamDayStatisticsService.putObdDayTransforData(obdDayTransfor,rowKey);
        return BaseResult.success();
    }

}
