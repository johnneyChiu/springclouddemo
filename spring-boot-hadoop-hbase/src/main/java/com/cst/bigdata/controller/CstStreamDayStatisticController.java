package com.cst.bigdata.controller;

import com.cst.bigdata.service.integrate.CstStreamDayIntegrateService;
import com.cst.stream.common.BaseResult;
import com.cst.stream.stathour.am.AmDayTransfor;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeDayTransfor;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsDayTransfor;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdDayTransfor;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 16:31
 * @Description 天数据统计
 */

@RestController
@RequestMapping("/stream/day")
public class CstStreamDayStatisticController {

    @Autowired
    private CstStreamDayIntegrateService cstStreamDayIntegrateService;

    //通过carId 时间戳获取 am day data
    @RequestMapping(value="/am/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<AmDayTransfor> getCstStreamAmDayTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamDayIntegrateService.getAmDayTransfor(carId, time);
    }
    //entity put am day data
    @RequestMapping(value="/am/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<AmDayTransfor> putCstStreamAmDayTransfor(@RequestBody AmDayTransfor amDayTransfor){
        return cstStreamDayIntegrateService.putAmDayTransfor(amDayTransfor);
    }

    //通过carId 时间戳获取 de day data
    @RequestMapping(value="/de/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<DeDayTransfor> getCstStreamDeDayTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamDayIntegrateService.getDeDayTransfor(carId, time);
    }
    //entity put de day data
    @RequestMapping(value="/de/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<DeDayTransfor> putCstStreamDeDayTransfor(@RequestBody DeDayTransfor deDayTransfor){
        return cstStreamDayIntegrateService.putDeDayTransfor(deDayTransfor);
    }


    //通过carId 时间戳获取 gps day data
    @RequestMapping(value="/gps/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<GpsDayTransfor> getCstStreamGpsDayTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamDayIntegrateService.getGpsDayTransfor(carId, time);
    }
    //entity put gps day data
    @RequestMapping(value="/gps/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<GpsDayTransfor> putCstStreamGpsDayTransfor(@RequestBody GpsDayTransfor gpsDayTransfor){
        return cstStreamDayIntegrateService.putGpsDayTransfor(gpsDayTransfor);
    }

    //通过carId 时间戳获取 obd day data
    @RequestMapping(value="/obd/find/{carId}/{time}", method= RequestMethod.GET)
    @ResponseBody
    public BaseResult<ObdDayTransfor> getCstStreamObdDayTransfor(@PathVariable String carId, @PathVariable Long time){
        return cstStreamDayIntegrateService.getObdDayTransfor(carId, time);
    }
    //entity put obd day data
    @RequestMapping(value="/obd/save", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResult<ObdDayTransfor> putCstStreamGpsHourTransfor(@RequestBody ObdDayTransfor obdDayTransfor){
        return cstStreamDayIntegrateService.putObdDayTransfor(obdDayTransfor);
    }

}
