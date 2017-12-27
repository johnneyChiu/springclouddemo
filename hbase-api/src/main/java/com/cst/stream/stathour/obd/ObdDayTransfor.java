package com.cst.stream.stathour.obd;

import com.cst.stream.stathour.CSTData;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Johnney.chiu
 * create on 2017/12/7 17:30
 * @Description obd 天数据计算
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObdDayTransfor extends CSTData
         {

    private String din;

    private Float totalDistance;

    private Float totalFuel;

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

    public ObdDayTransfor carId(String carId){
        this.carId = carId;
        return this;
    }

    public ObdDayTransfor time(Long time){
        this.time = time;
        return this;
    }


    public ObdDayTransfor buildInit(Float maxSpeed, Integer isHighSpeed, Integer isNightDrive, Integer isDrive,
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

    public ObdDayTransfor addMileage(Float mileage){
        this.mileage = BigDecimal.valueOf(this.mileage).add(BigDecimal.valueOf(mileage)).floatValue();
        return this;
    }
    public ObdDayTransfor addFuel(Float fuel){
        this.fuel = BigDecimal.valueOf(this.fuel).add(BigDecimal.valueOf(fuel)).floatValue();
        return this;
    }
    public ObdDayTransfor addDuration(Integer duration){
        this.duration += duration;
        return this;
    }
    public ObdDayTransfor chargeMaxSpeed(Float maxSpeed){
        if(maxSpeed>this.maxSpeed)
            this.maxSpeed =  maxSpeed;
        return this;
    }

    public ObdDayTransfor chargeIsHightSpeed(Integer isHighSpeed){
        if(isHighSpeed==1)
            this.isHighSpeed = 1;
        return this;
    }

    public ObdDayTransfor chargeIsNightDrive(Integer isNightDrive){
       if(isNightDrive==1)
            this.isNightDrive = 1;
        return this;
    }


    public ObdDayTransfor chargeIsDrive(Integer isDrive){
        if(isDrive==1)
            this.isDrive = 1;
        return this;
    }

    public ObdDayTransfor clacFee(Float mileage,Map<String,Object> map){
        this.fee=BigDecimal.valueOf(this.fee).add(BigDecimal.valueOf(mileage).
                multiply(BigDecimal.valueOf((Float)map.get("fuelPrice")))).floatValue();
        return this;
    }

    public ObdDayTransfor initMyTransfor(ObdHourTransfor obdHourTransfor){
        this.carId = obdHourTransfor.getCarId();
        this.time = obdHourTransfor.getTime();
        this.din = obdHourTransfor.getDin();
        this.totalDistance = obdHourTransfor.getTotalDistance();
        this.totalFuel = obdHourTransfor.getTotalFuel();
        return this;
    }
    public ObdDayTransfor dataJumped(ObdHourTransfor obdHourTransfor,Map map){
        return this;
    }
    public ObdDayTransfor initTime(long uploadTime) {
        this.time = uploadTime;
        return this;
    }
    public ObdDayTransfor clacData(ObdHourTransfor obdHourTransfor, Map<String, Object> other) {
     //如果车机变了,那么先初始为本次的结果源，计算得到结果将不会发生变化
     if(!this.din.equals(obdHourTransfor.getDin()))
         this.initMyTransfor(obdHourTransfor);
     this.addDuration(obdHourTransfor.getDuration())
             .addFuel(obdHourTransfor.getFuel())
             .addMileage(obdHourTransfor.getMileage())
             .chargeIsDrive(obdHourTransfor.getIsDrive())
             .chargeIsHightSpeed(obdHourTransfor.getIsHighSpeed())
             .chargeIsNightDrive(obdHourTransfor.getIsNightDrive())
             .chargeMaxSpeed(obdHourTransfor.getMaxSpeed())
             .clacFee(obdHourTransfor.getFuel(),other)
             //最后在初始化一遍数据
             .initMyTransfor(obdHourTransfor);
        return this;
    }


}
