package com.cst.stream.stathour.obd;

import com.cst.stream.common.DateTimeUtil;
import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;


/**
 * @author Johnney.chiu
 * create on 2017/12/6 11:30
 * @Description obd 的数据处理
 */
@NoArgsConstructor
@AllArgsConstructor()
@Getter
@Setter
@JsonTypeName("ObdHourTransfor")
public class ObdHourTransfor extends CSTData
        {

    private String din;

    private Integer speed;

    private Float totalDistance;

    private Float totalFuel;


    private Integer runTotalTime;

    private Float motormeterDistance;

    private Float maxSpeed=0f;

    //0未上，1 上高速
    private Integer isHighSpeed = 0;

    //0表示没有，1表示有夜间开车
    private Integer isNightDrive = 0;

    //0表示没有开车，1表示开车
    private Integer isDrive = 0;

    //行程里程
    private Float mileage = 0f;

    //耗油量
    private Float fuel = 0f;

    //行驶时间
    private Integer duration = 0;

    //油费
    private Float fee = 0f;


    public ObdHourTransfor buildInit(Float maxSpeed, Integer isHighSpeed, Integer isNightDrive, Integer isDrive,
                           Float mileage, Float fuel, Integer duration,Float fee) {
        this.maxSpeed = maxSpeed;
        this.isHighSpeed = isHighSpeed;
        this.isNightDrive = isNightDrive;
        this.isDrive = isDrive;
        this.mileage = mileage;
        this.fuel = fuel;
        this.duration = duration;
        this.fee = fee;
        return this;
    }

    public ObdHourTransfor addMileage(Float totalDistance){
        BigDecimal total =BigDecimal.valueOf(totalDistance);
        BigDecimal oldTotal =BigDecimal.valueOf(this.totalDistance);
        this.mileage = BigDecimal.valueOf(this.mileage).add(total.subtract(oldTotal)).floatValue();
        return this;
    }
    public ObdHourTransfor addFuel(Float totalFuel){
        BigDecimal total =BigDecimal.valueOf(totalFuel);
        BigDecimal oldTotal =BigDecimal.valueOf(this.totalFuel);
        this.fuel = BigDecimal.valueOf(this.fuel).add(total.subtract(oldTotal)).floatValue();
        return this;
    }
    public ObdHourTransfor addDuration(Integer runTotalTime){
        this.duration += runTotalTime - this.runTotalTime;
        return this;
    }
    public ObdHourTransfor chargeMaxSpeed(Integer speed){
        if(speed>this.maxSpeed)
            this.maxSpeed = (float) speed;
        return this;
    }

    public ObdHourTransfor chargeIsHightSpeed(Integer speed,Map map){
        if(speed>(Integer)map.get("highSpeedStandard"))
            this.isHighSpeed = 1;
        return this;
    }

    public ObdHourTransfor chargeIsNightDrive(long time,Integer runTotalTime,Map map){
        if(runTotalTime<0)
            return this;
        if(this.isNightDrive==1)
            return this;
        String str = DateTimeUtil.toLongTimeString(time, DateTimeUtil.DEFAULT_DATE_DEFULT);
        int hour=Integer.parseInt(str.substring(8,10));
        if(hour>=(Integer)map.get("high")||hour<(Integer)map.get("low")){
            this.isNightDrive = 1;
        }
        return this;
    }


    public ObdHourTransfor chargeIsDrive(Integer runTotalTime){
        if(runTotalTime>0)
            this.isDrive = 1;
        return this;
    }

    public ObdHourTransfor clacFee(Float totalDistance,Map<String,Object> map){
        BigDecimal total =BigDecimal.valueOf(totalDistance);
        BigDecimal oldTotal =BigDecimal.valueOf(this.totalDistance);
        this.fee=BigDecimal.valueOf(this.fee).add(total.subtract(oldTotal).
                multiply(BigDecimal.valueOf((Float)map.get("fuelPrice")))).floatValue();
        return this;
    }


    public ObdHourTransfor initMyTransfor(ObdHourSource obdHourSource){
        this.carId = obdHourSource.getCarId();
        this.time = obdHourSource.getTime();
        this.din = obdHourSource.getDin();
        this.speed = obdHourSource.getSpeed();
        this.totalDistance = obdHourSource.getTotalDistance();
        this.totalFuel = obdHourSource.getTotalFuel();
        this.runTotalTime = obdHourSource.getRunTotalTime();
        this.motormeterDistance = obdHourSource.getMotormeterDistance();
        return this;
    }

    public ObdHourTransfor dataJumped(ObdHourSource obdHourSource,Map map){
        return this;
    }
    public ObdHourTransfor initTime(long uploadTime) {
        this.time = uploadTime;
        return this;
    }


    public ObdHourTransfor calcData(ObdHourSource obdHourSource, Map<String, Object> other) {
        if(!this.din.equals(obdHourSource.getDin()))
            this.initMyTransfor(obdHourSource);
        this.addDuration(obdHourSource.getRunTotalTime())
                .addFuel(obdHourSource.getTotalFuel())
                .addMileage(obdHourSource.getTotalDistance())
                .chargeIsDrive(obdHourSource.getRunTotalTime())
                .chargeIsHightSpeed(obdHourSource.getSpeed(), other)
                .chargeIsNightDrive(obdHourSource.getTime(), obdHourSource.getRunTotalTime(), other)
                .chargeMaxSpeed(obdHourSource.getSpeed())
                .clacFee(obdHourSource.getTotalDistance(),other)
                //最后在初始化一遍数据
                .initMyTransfor(obdHourSource);
        return this;
    }

}
