package com.cst.stream.stathour.de;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Johnney.chiu
 * create on 2017/12/5 15:07
 * @Description De day
 */
@Getter
@Setter
@JsonTypeName("DeDayTransfor")
public class DeDayTransfor extends CSTData {

    //急加速
    private Integer rapidAccelerationCount=0;
    //急减速
    private Integer rapidDecelerationCount=0 ;
    //急转弯
    private Integer sharpTurnCount=0 ;


    public Long getTime() {
        return time;
    }

    public DeDayTransfor(String carId, Long time, Integer rapidAccelerationCount, Integer rapidDecelerationCount, Integer sharpTurnCount) {
        this.carId = carId;
        this.time = time;
        this.rapidAccelerationCount = rapidAccelerationCount;
        this.rapidDecelerationCount = rapidDecelerationCount;
        this.sharpTurnCount = sharpTurnCount;
    }

    public DeDayTransfor calcData(DeHourTransfor deHourTransfor,Map other) {
        this.carId = deHourTransfor.getCarId();
        this.time = deHourTransfor.getTime();
        this.rapidAccelerationCount = this.rapidAccelerationCount == null ? deHourTransfor.getRapidAccelerationCount()
                : this.rapidAccelerationCount + deHourTransfor.getRapidAccelerationCount();
        this.rapidDecelerationCount = this.rapidDecelerationCount == null ? deHourTransfor.getRapidDecelerationCount()
                : this.rapidDecelerationCount + deHourTransfor.getRapidDecelerationCount();
        this.sharpTurnCount = this.sharpTurnCount == null ? deHourTransfor.getSharpTurnCount()
                : this.getSharpTurnCount() + deHourTransfor.getSharpTurnCount();
        return this;
    }

}
