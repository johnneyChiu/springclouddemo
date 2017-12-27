package com.cst.stream.stathour.gps;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/27 14:45
 * @Description 存储于缓存和hbase中的数据
 */
@Getter
@Setter
@JsonTypeName("GpsHourTransfor")
public class GpsHourTransfor extends CSTData {


    //最大搜星数
    private Integer maxSatelliteNum=0;

    //gps上报数
    private Integer gpsCount=0;

    private String din;

    private Integer dinChange=0;


    private Integer isNonLocal;

    public GpsHourTransfor() {
    }

    public GpsHourTransfor(String carId, Integer maxSatelliteNum, Integer gpsCount, String din, Integer dinChange,
                           Long time, Integer isNonLocal) {
        this.carId = carId;
        this.maxSatelliteNum = maxSatelliteNum;
        this.gpsCount = gpsCount;
        this.din = din;
        this.dinChange = dinChange;
        this.time = time;
        this.isNonLocal = isNonLocal;
    }


    public GpsHourTransfor addGpsCount() {
        this.gpsCount++;
        return this;
    }

    public GpsHourTransfor gpsChangeJudge(String din) {
        if(!this.din.equals(din))
            dinChange = 1;
        return this;
    }

    public GpsHourTransfor maxSatellitesCalc(Integer satellites) {
        if(satellites>this.maxSatelliteNum)
            this.maxSatelliteNum = satellites;
        return this;
    }

    public GpsHourTransfor timeSetting(Long time) {
        this.time = time;
        return this;
    }



}
