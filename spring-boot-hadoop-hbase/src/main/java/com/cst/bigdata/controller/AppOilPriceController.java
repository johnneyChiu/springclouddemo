package com.cst.bigdata.controller;


import com.cst.bigdata.service.integrate.AppOilIntegrateService;
import com.cst.stream.common.BaseResult;
import com.cst.stream.vo.AppOilVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Johnney.chiu
 * create on 2017/12/11 17:32
 * @Description 啊哈哈
 */
@RestController
@RequestMapping("/oilPrice")
public class AppOilPriceController {

    @Autowired
    private AppOilIntegrateService appOilService;


    @RequestMapping(value = "/get/{province}",method = RequestMethod.GET)
    public BaseResult<List<AppOilVo>> getDataFromProvince(@PathVariable  String province) {
        return appOilService.getDataFromProvince(province);
    }
    @RequestMapping(value = "/get/{province}/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public BaseResult<List<AppOilVo>> getDataFromProvinceWithPage(@PathVariable  String province,
                                                                  @PathVariable Integer pageNum,
                                                                  @PathVariable Integer pageSize) {
        return appOilService.getDataFromProvinceWithPage(province,pageNum,pageSize);
    }
    @RequestMapping(value = "/get/{province}/{date}",method = RequestMethod.GET)
    public BaseResult<AppOilVo> getProvinceLatestOilPrice(@PathVariable  String province,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return appOilService.getProvinceLatestOilPrice(province,date);
    }

}
