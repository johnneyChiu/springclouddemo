package com.cst.stream.stathour.am;


import com.cst.stream.common.AlarmTypeConst;
import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/28 10:00
 * @Description Am 告警数据
 */
@Getter
@Setter
public class AmHourTransfor extends CSTData  {


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
    private Float pulloutTimes=0f;

    //疲劳驾驶 是否疲劳驾驶(0表示没有疲劳驾驶，1表示有疲劳驾驶室)
    private Integer isFatigue=0;

    public AmHourTransfor() {
    }
    public AmHourTransfor(String carId, Long time, Integer ignition, Integer flameOut, Integer insertNum, Integer collision,
                          Integer overSpeed, Integer isMissing, Float pulloutTimes, Integer isFatigue) {
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

    //点火告警
    public AmHourTransfor changeIgnition(Integer type) {
        if(AlarmTypeConst.ALARM_CAR_IGNITION==type.intValue())
            this.ignition++;
        return this;
    }
    //熄火告警
    public AmHourTransfor changeFlameout(Integer type) {
        if(AlarmTypeConst.ALARM_CAR_FLAMEOUT==type.intValue())
            this.flameOut++;
        return this;
    }
    //插入告警
    public AmHourTransfor changeInesert(Integer type) {
        if(AlarmTypeConst.ALARM_TERMINAL_INSERT==type.intValue())
            this.insertNum++;
        return this;
    }
    //疲劳驾驶告警
    public AmHourTransfor changeIsfatigue(Integer type) {
        if(this.isFatigue==1) return this;
        if(AlarmTypeConst.ALARM_FATIGUE_DRIVING_PARA==type.intValue())
            this.isFatigue=1;
        return this;
    }

    //碰撞告警
    public AmHourTransfor changeCollision(Integer type, Integer gatherType) {
        if(gatherType==3) return this;
        if(AlarmTypeConst.ALARM_FATIGUE_DRIVING_PARA==type.intValue())
            this.collision++;
        return this;
    }
    //超速告警
    public AmHourTransfor changeOverspeed(Integer type) {
        if(AlarmTypeConst.ALARM_OVERSPEED==type.intValue())
            this.overSpeed++;
        return this;
    }
    //失联告警
    public AmHourTransfor changeDisappear(Integer type) {
        if(this.isMissing==1) return this;
        if(AlarmTypeConst.ALARM_DISAPPEAR_STATE==type.intValue())
            this.isMissing = 1;
        return this;
    }

    //拔出时长告警
    public AmHourTransfor changePullout(Integer type, Float times){
        if(AlarmTypeConst.ALARM_LONG_NOGPSINF_TIME==type)
            this.pulloutTimes += times;
        return this;
    }

}
