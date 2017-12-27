package com.cst.bigdata.repository.hbase;

import com.cst.bigdata.domain.hbase.UserInfo;
import com.cst.bigdata.utils.HbaseFindBuilder;
import com.cst.bigdata.utils.HbasePutBuilder;
import com.cst.stream.stathour.am.AmHourTransfor;
import com.cst.stream.stathour.de.DeHourTransfor;
import com.cst.stream.stathour.gps.GpsHourTransfor;
import com.cst.stream.stathour.obd.ObdHourTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 18:11
 * @Description 小时数据查询统计mapper
 */
@Repository
public class CstStreamHourStatisticsMapper {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public AmHourTransfor findAmHourTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (AmHourTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time","ignition", "flameOut", "insertNum","collision"
                        ,"overSpeed","isMissing","pulloutTimes","isFatigue")).fetch();
    }

    public void putAmHourTransfor(String tableName,String family,String rowKey, AmHourTransfor amHourTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<AmHourTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),amHourTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public DeHourTransfor findDeHourTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (DeHourTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time",
                        "rapidAccelerationCount","rapidDecelerationCount","sharpTurnCount")).fetch();
    }

    public void putDeHourTransfor(String tableName,String family,String rowKey, DeHourTransfor deHourTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<DeHourTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),deHourTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public GpsHourTransfor findGpsHourTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (GpsHourTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time"
                        ,"maxSatelliteNum","gpsCount","din","dinChange","isNonLocal")).fetch();
    }

    public void putGpsHourTransfor(String tableName,String family,String rowKey, GpsHourTransfor gpsHourTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<GpsHourTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),gpsHourTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public ObdHourTransfor findObdHourTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (ObdHourTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time"
                        ,"din","speed","totalDistance","totalFuel","runTotalTime","motormeterDistance","maxSpeed","isHighSpeed","isNightDrive","isDrive","mileage","fuel","duration","fee")).fetch();
    }

    public void putObdHourTransfor(String tableName,String family,String rowKey, ObdHourTransfor obdHourTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<ObdHourTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),obdHourTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }
}
