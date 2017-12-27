package com.cst.stream.stathour.am;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Johnney.chiu
 * create on 2017/12/5 10:47
 * @Description 天处理
 */


@Setter
@Getter
@JsonTypeName("AmDayTransfor")
public class AmDayTransfor extends CSTData {

    //点火次数
    private Integer ignition=0;

    //熄火次数
    private Integer flameOut=0;

    //插入次数
    private Integer insertNum=0;

    //碰撞告警次数
    private Integer collision=0;

    //超速告警次数
    private Integer overSpeed=0;

    //是否失联(0表示没有失联，1表示失联)
    private Integer isMissing=0;

    //拔出时长
    private Float pulloutTimes=0.0f;

    //疲劳驾驶 是否疲劳驾驶(0表示没有疲劳驾驶，1表示有疲劳驾驶室)
    private Integer isFatigue=0;


    public AmDayTransfor(String carId, Long time, Integer ignition, Integer flameOut, Integer insertNum,
                         Integer collision, Integer overSpeed, Integer isMissing, Float pulloutTimes, Integer isFatigue) {
        super(carId,time);
        this.ignition = ignition;
        this.flameOut = flameOut;
        this.insertNum = insertNum;
        this.collision = collision;
        this.overSpeed = overSpeed;
        this.isMissing = isMissing;
        this.pulloutTimes = pulloutTimes;
        this.isFatigue = isFatigue;
    }
    public AmDayTransfor calcAmData(AmHourTransfor amHourTransfor,Map other) {
        this.collision = (collision==null?0:collision)+amHourTransfor.getCollision();
        this.flameOut = (flameOut == null ? 0 : flameOut) + amHourTransfor.getFlameOut();
        this.time = amHourTransfor.getTime();
        this.carId = amHourTransfor.getCarId();
        this.ignition = (ignition==null?0:ignition)+amHourTransfor.getIgnition();
        this.insertNum = (insertNum==null?0:insertNum)+amHourTransfor.getInsertNum();
        this.isFatigue = (isFatigue==null?0:isFatigue)+amHourTransfor.getIsFatigue();
        this.isMissing = (isMissing==null?0:isMissing)+amHourTransfor.getIsMissing();
        this.overSpeed = (overSpeed==null?0:overSpeed)+amHourTransfor.getOverSpeed();
        this.pulloutTimes = (pulloutTimes==null?0:pulloutTimes)+amHourTransfor.getPulloutTimes();
        return this;
    }

}
