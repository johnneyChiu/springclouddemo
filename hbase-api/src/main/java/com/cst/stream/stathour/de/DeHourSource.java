package com.cst.stream.stathour.de;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/27 14:55
 * @Description de data source
 */
@Getter
@Setter
@JsonTypeName("DeHourSource")
public class DeHourSource extends CSTData {

    private String din;

    private Float speed=0f;

    // 驾驶行为类别;
    private Integer actType=0;

    private Integer gatherType=0;

    public DeHourSource() {
    }

    public DeHourSource(String carId, String din, Long time, Float speed, Integer actType, Integer gatherType) {
        super(carId,time);
        this.time = time;
        this.speed = speed;
        this.actType = actType;
        this.gatherType = gatherType;
    }
}
