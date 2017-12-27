package com.cst.stream.stathour.am;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/27 18:17
 * @Description am的数据源
 */
@Getter
@Setter
public class AmHourSource extends CSTData {


    private String din;


    // 告警类型;
    private Integer alarmType=0;

    //故障码;
    private String troubleCode;

    private Integer gatherType=0;

    private Double longitude=0d;

    private Double latitude=0d;

    private Integer versionType=0;


    public AmHourSource(String carId, String din, Long time, Integer alarmType, String troubleCode, Integer gatherType,
                        Double longitude, Double latitude, Integer versionType) {
        super(carId,time);
        this.time = time;
        this.alarmType = alarmType;
        this.troubleCode = troubleCode;
        this.gatherType = gatherType;
        this.longitude = longitude;
        this.latitude = latitude;
        this.versionType = versionType;
    }

    public AmHourSource() {
    }
}
