package com.cst.bigdata.repository.hbase;

import com.cst.bigdata.utils.HbaseFindBuilder;
import com.cst.bigdata.utils.HbasePutBuilder;
import com.cst.stream.stathour.am.AmDayTransfor;
import com.cst.stream.stathour.de.DeDayTransfor;
import com.cst.stream.stathour.gps.GpsDayTransfor;
import com.cst.stream.stathour.obd.ObdDayTransfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Johnney.chiu
 * create on 2017/12/19 18:11
 * @Description 小时数据查询统计mapper
 */
@Repository
public class CstStreamDayStatisticsMapper {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public AmDayTransfor findAmDayTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (AmDayTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time"
                        ,"ignition","flameOut","insertNum","collision","overSpeed","isMissing","pulloutTimes","isFatigue")).fetch();
    }

    public void putAmDayTransfor(String tableName,String family,String rowKey, AmDayTransfor amDayTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<AmDayTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),amDayTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public DeDayTransfor findDeDayTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (DeDayTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time",
                        "rapidAccelerationCount","rapidDecelerationCount","sharpTurnCount")).fetch();
    }

    public void putDeDayTransfor(String tableName,String family,String rowKey, DeDayTransfor deDayTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<AmDayTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),deDayTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public GpsDayTransfor findGpsDayTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (GpsDayTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time"
                        ,"maxSatelliteNum","gpsCount","din","dinChange","isNonLocal")).fetch();
    }

    public void putGpsDayTransfor(String tableName,String family,String rowKey, GpsDayTransfor gpsDayTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<GpsDayTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),gpsDayTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

    public ObdDayTransfor findObdDayTransforByRowKey(String tableName, String familyName, String rowKey, Class<?> clazz) {
        return (ObdDayTransfor) hbaseTemplate.get(tableName, rowKey, familyName, (result, rowNum) ->
                new HbaseFindBuilder(familyName, result, clazz).build("carId","time"
                        ,"din","totalDistance","totalFuel","maxSpeed","isHighSpeed","isNightDrive","isDrive","mileage","fuel","duration","fee")).fetch();
    }

    public void putObdDayTransfor(String tableName,String family,String rowKey, ObdDayTransfor obdDayTransfor) {
        hbaseTemplate.execute(tableName, (table) -> {
            HbasePutBuilder<ObdDayTransfor> hbasePutBuilder = new HbasePutBuilder(family,rowKey.getBytes(),obdDayTransfor);
            table.put(hbasePutBuilder);
            return true;
        });
    }

}
