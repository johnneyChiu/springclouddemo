package com.cst.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Johnney.chiu
 * create on 2017/11/21 17:01
 * @Description 用于大数据计算的hbase读写服务
 */

@SpringBootApplication
public class BigdataHbaseApplication {

    public static void main(String... args){

            SpringApplication.run(BigdataHbaseApplication.class, args);
    }
}
