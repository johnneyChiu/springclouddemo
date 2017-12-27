package com.cst.stream.stathour.gps;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/27 14:54
 * @Description gps来源数据
 */
@Getter
@Setter
@JsonTypeName("GpsHourSource")
public class GpsHourSource extends CSTData {
    private String din;

    private Integer satellites=0;

    private Double longitude=0.0d;

    private Double latitude=0.0d;

    public GpsHourSource() {
    }

    public GpsHourSource(String carId, String din, Long time, Integer satellites, Double longitude, Double latitude) {
        super(carId,time);
        this.time = time;
        this.satellites = satellites;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
