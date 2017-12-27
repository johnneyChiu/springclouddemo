package com.cst.stream.stathour.obd;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

/**
 * @author Johnney.chiu
 * create on 2017/12/6 10:50
 * @Description obd数据源
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonTypeName("ObdHourSource")
public class ObdHourSource extends CSTData{
    private String din;

    private Integer speed;

    private Float totalDistance;

    private Float totalFuel;

    private Integer runTotalTime;

    private Float motormeterDistance;

    public ObdHourSource carId(String carId){
        this.carId = carId;
        return this;
    }

    public ObdHourSource time(Long time){
        this.time = time;
        return this;
    }
}
