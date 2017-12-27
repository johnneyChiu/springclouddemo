package com.cst.bigdata.controller;

import com.cst.bigdata.service.integrate.CstStreamHourIntegrateService;
import com.cst.stream.common.BaseResult;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 16:30
 * @Description 小时统计数据存储
 */
@RestController
@RequestMapping("/stream/hour")
public class CstStreamHourStatisticController {

    @Autowired
    private CstStreamHourIntegrateService cstStreamHourIntegrateService;

    //通过carId 时间戳获取 am hour data
    @RequestMapping(value="/am/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<AmHourTransfor> getCstStreamAmHourTransfor(@PathVariable("carId") @NotNull String carId, @PathVariable("time") @NotNull Long time){
        return cstStreamHourIntegrateService.getAmHourTransfor(carId, time);
    }
    //entity put am hour data
    @RequestMapping(value="/am/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<AmHourTransfor> putCstStreamAmHourTransfor(@RequestBody AmHourTransfor amHourTransfor){
        return cstStreamHourIntegrateService.putAmHourTransfor(amHourTransfor);
    }

    //通过carId 时间戳获取 de hour data
    @RequestMapping(value="/de/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<DeHourTransfor> getCstStreamDeHourTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamHourIntegrateService.getDeHourTransfor(carId, time);
    }
    //entity put de hour data
    @RequestMapping(value="/de/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<DeHourTransfor> putCstStreamDeHourTransfor(@RequestBody DeHourTransfor deHourTransfor){
        return cstStreamHourIntegrateService.putDeHourTransfor(deHourTransfor);
    }


    //通过carId 时间戳获取 gps hour data
    @RequestMapping(value="/gps/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<GpsHourTransfor> getCstStreamGpsHourTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamHourIntegrateService.getGpsHourTransfor(carId, time);
    }
    //entity put gps hour data
    @RequestMapping(value="/gps/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<GpsHourTransfor> putCstStreamGpsHourTransfor(@RequestBody GpsHourTransfor gpsHourTransfor){
        return cstStreamHourIntegrateService.putGpsHourTransfor(gpsHourTransfor);
    }

    //通过carId 时间戳获取 obd hour data
    @RequestMapping(value="/obd/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<ObdHourTransfor> getCstStreamObdHourTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamHourIntegrateService.getObdHourTransfor(carId, time);
    }
    //entity put obd hour data
    @RequestMapping(value="/obd/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<ObdHourTransfor> putCstStreamGpsHourTransfor(@RequestBody ObdHourTransfor obdHourTransfor){
        return cstStreamHourIntegrateService.putObdHourTransfor(obdHourTransfor);
    }
}
