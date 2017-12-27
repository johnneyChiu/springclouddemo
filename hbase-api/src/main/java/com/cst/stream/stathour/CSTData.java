package com.cst.stream.stathour;

import com.cst.stream.stathour.am.AmDayTransfor;
import com.cst.stream.stathour.am.AmHourSource;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeDayTransfor;
import com.cst.stream.stathour.de.DeHourSource;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsDayTransfor;
import com.cst.stream.stathour.gps.GpsHourSource;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdDayTransfor;
import com.cst.stream.stathour.obd.ObdHourSource;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/12/1 11:09
 * @Description 数据源的父类
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = GpsHourSource.class, name = "GpsHourSource"),
        @JsonSubTypes.Type(value = GpsDayTransfor.class, name = "GpsDayTransfor"),
        @JsonSubTypes.Type(value = GpsHourTransfor.class, name = "GpsHourTransfor"),

        @JsonSubTypes.Type(value = AmHourSource.class, name = "AmHourSource"),
        @JsonSubTypes.Type(value = AmDayTransfor.class, name = "AmDayTransfor"),
        @JsonSubTypes.Type(value = AmHourTransfor.class, name = "AmHourTransfor"),


        @JsonSubTypes.Type(value = DeHourSource.class, name = "DeHourSource"),
        @JsonSubTypes.Type(value = DeHourTransfor.class, name = "DeHourTransfor"),
        @JsonSubTypes.Type(value = DeDayTransfor.class, name = "DeDayTransfor"),

        @JsonSubTypes.Type(value = ObdHourSource.class, name = "ObdHourSource"),
        @JsonSubTypes.Type(value = ObdHourTransfor.class, name = "ObdHourTransfor"),
        @JsonSubTypes.Type(value = ObdDayTransfor.class, name = "ObdDayTransfor"),


})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CSTData {
    protected String carId="";

    protected Long time = 0l;

}
