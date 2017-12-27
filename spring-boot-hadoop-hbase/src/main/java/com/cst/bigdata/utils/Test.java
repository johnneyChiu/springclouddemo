package com.cst.bigdata.utils;

import com.cst.bigdata.domain.mybatis.AppOilPrice;
import com.cst.stream.vo.AppOilVo;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Johnney.chiu
 * create on 2017/12/12 17:01
 * @Description
 */
public class Test {

    public static Map test(Map rmap)
    {
        BigDecimal mile_ll = new BigDecimal(rmap.get("mileage_l") == null ? "0" : (String)rmap.get("mileage_l"));

        double totalMile = 0.0D;

        if ((rmap.get("basicMile") != null) && (rmap.get("initMile") != null)) {
            BigDecimal basicMile = new BigDecimal((String)rmap.get("basicMile"));
            BigDecimal initMile = new BigDecimal((String)rmap.get("initMile"));
            BigDecimal baseMile_per = new BigDecimal(rmap.get("baseMile_per") == null ? "0" : (String)rmap.get("baseMile_per"));
            totalMile = basicMile.add(mile_ll).subtract(initMile).add(baseMile_per).doubleValue();
        } else if ((rmap.get("basicMile") != null) && (rmap.get("initMile") == null)) {
            totalMile = Double.parseDouble((String)rmap.get("basicMile"));
        } else if ((rmap.get("basicMile") == null) && (rmap.get("initMile") != null)) {
            BigDecimal initMile = new BigDecimal((String)rmap.get("initMile"));
            BigDecimal baseMile_per = new BigDecimal(rmap.get("baseMile_per") == null ? "0" : (String)rmap.get("baseMile_per"));
            totalMile = mile_ll.subtract(initMile).add(baseMile_per).doubleValue();
        } else {
            totalMile = 0.0D;
        }

        if ((rmap.get("motomile") != null) && (!((String)rmap.get("motomile")).equals("-1"))) {
            totalMile = Double.valueOf((String)rmap.get("motomile")).doubleValue();
        }
        Map resMap = new HashMap();
        resMap.put("totalmile", String.valueOf(totalMile));

        return resMap;

    }
    public static void main(String... args) throws ParseException {
        String str = "0000139ca0124edb90cb5a5d27ab2b43";
        int mod = Math.abs(str.hashCode()) ;
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMdd");
        Date date=myFmt.parse("20171219");
        String a=mod+""+(date.getTime());
        byte[] b = a.getBytes();

        System.out.println(String.format("mod is %d str is %s and bytes length is %d",mod, a,b.length));


        String str2 = MD5Hash.getMD5AsHex(Bytes.toBytes(str));
        String str3=str2+(date.getTime());
        b = str3.getBytes();
        System.out.println(String.format("mod is %s str is %s and bytes length is %d",str2, str3,b.length));

    }

    private static void testlamda() {
        Map map1 = new HashMap<String,String>(){{
            put("carid", "2a3bcebe1f6f49e192e0edd4b9ca57f9");
            put("mileage_l", "0.0");
            put("basicMile", "-1");
            put("initMile", "0.00");

        }};
        System.out.println(test(map1));
        map1 = new HashMap<String,String>(){{
            put("carid", "28d5643337ba49edbedbebdaf1087f6e");
            put("mileage_l", "0.0");
            put("basicMile", "0.0");
            put("initMile", "1");

        }};
        System.out.println(test(map1));
        map1 = new HashMap<String,String>(){{
            put("carid", "28d5643337ba49edbedbebdaf1087f6e");
            put("mileage_l", "-1");
            put("basicMile", "0.0");
            put("initMile", "0");

        }};
        System.out.println(test(map1));

        map1 = new HashMap<String,String>(){{
            put("carid", "28d5643337ba49edbedbebdaf1087f6e");
            put("mileage_l", "0");
            put("basicMile", "0.0");
            put("initMile", "0");
            put("motomile", "-1.0");

        }};
        System.out.println(test(map1));
    }

    public void testStram(){

        List<AppOilPrice> appOilPrices = new ArrayList<>();
        AppOilPrice appOilPrice = new AppOilPrice();
        appOilPrice.setB0(122D);
        appOilPrice.setProvince("xiaoq");
        appOilPrices.add(appOilPrice);
        appOilPrice = new AppOilPrice();
        appOilPrice.setB0(123D);
        appOilPrice.setProvince("xiaoq");
        appOilPrices.add(appOilPrice);

        List<AppOilVo> appOilVos = appOilPrices.stream()
                .map(a -> {
                    AppOilVo appOilVo = new AppOilVo();
                    BeanUtils.copyProperties(a, appOilVo);
                    return appOilVo;
                }).collect(Collectors.toList());
        appOilVos.stream().map(a->a.getProvince()).forEach(System.out::println);

        appOilVos = appOilPrices.stream()
                .collect(ArrayList::new, (list, item) -> {
                    AppOilVo appOilVo = new AppOilVo();
                    BeanUtils.copyProperties(item, appOilVo);
                    list.add(appOilVo);
                }, List::addAll);
        appOilVos.stream().map(a->a.getB0()).forEach(System.out::println);
    }


}



