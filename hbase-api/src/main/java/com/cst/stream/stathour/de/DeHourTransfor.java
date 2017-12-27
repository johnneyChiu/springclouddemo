package com.cst.stream.stathour.de;

import com.cst.stream.stathour.CSTData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnney.chiu
 * create on 2017/11/27 16:55
 * @Description driver event data transfor
 */
@Setter
@Getter
@JsonTypeName("DeHourTransfor")
public class DeHourTransfor extends CSTData  {

    //急加速
    private Integer rapidAccelerationCount=0;
    //急减速
    private Integer rapidDecelerationCount=0 ;
    //急转弯
    private Integer sharpTurnCount=0 ;


    public DeHourTransfor(String carId, Long time, Integer rapidAccelerationCount, Integer rapidDecelerationCount, Integer sharpTurnCount) {
        this.carId = carId;
        this.time = time;
        this.rapidAccelerationCount = rapidAccelerationCount;
        this.rapidDecelerationCount = rapidDecelerationCount;
        this.sharpTurnCount = sharpTurnCount;
    }

    public DeHourTransfor addRapidAccelerationCount(Integer gatherType, Integer actType){
        if(3!=gatherType&&1==actType)//这样写是可以的哦~
            this.rapidAccelerationCount++;
        return this;
    }

    public DeHourTransfor addRapidDecelerationCount(Integer gatherType, Integer actType) {
        if(3!=gatherType&&2==actType)
        this.rapidDecelerationCount++;
        return this;
    }
    public DeHourTransfor addSharpTurnCount(Integer gatherType, Integer actType){
        if(3!=gatherType&&3==actType)
            this.sharpTurnCount++;
        return this;
    }


}
