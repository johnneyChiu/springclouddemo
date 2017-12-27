package com.cst.stream.stathour.gps;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Johnney.chiu
 * create on 2017/12/5 15:25
 * @Description gps day data transfor
 */
@Getter
@Setter
@JsonTypeName("GpsDayTransfor")
public class GpsDayTransfor extends CSTData {

    //最大搜星数
    private Integer maxSatelliteNum=0;

    //gps上报数
    private Integer gpsCount=0;

    private String din;

    private Integer dinChange=0;


    private Integer isNonLocal;


    public GpsDayTransfor(String carId, Long time, Integer maxSatelliteNum, Integer gpsCount, String din, Integer dinChange, Integer isNonLocal) {
        this.carId = carId;
        this.time = time;
        this.maxSatelliteNum = maxSatelliteNum;
        this.gpsCount = gpsCount;
        this.din = din;
        this.dinChange = dinChange;
        this.isNonLocal = isNonLocal;
    }


    public GpsDayTransfor calcData(GpsHourTransfor gpsHourTransfor,Map other) {
        this.carId = gpsHourTransfor.getCarId();
        this.time = gpsHourTransfor.getTime();
        this.din = gpsHourTransfor.getDin();
        if(gpsHourTransfor.getDinChange()==1)
            this.dinChange = 1;
        else this.dinChange = 0;
        this.gpsCount = this.gpsCount == null ? gpsHourTransfor.getGpsCount()
                : this.gpsCount + gpsHourTransfor.getGpsCount();
        if(gpsHourTransfor.getIsNonLocal()==1)
            this.isNonLocal = 1;
        else this.isNonLocal = 0;
        this.maxSatelliteNum = this.maxSatelliteNum == null ? gpsHourTransfor.getMaxSatelliteNum()
                : this.getMaxSatelliteNum() + gpsHourTransfor.getMaxSatelliteNum();
        return this;
    }

}
