package com.cst.bigdata;

import com.cst.bigdata.utils.ProfileUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Johnney.chiu
 * create on 2017/11/21 17:01
 * @Description 用于大数据计算的hbase读写服务
 */

@SpringBootApplication
@EnableTransactionManagement()
@EnableWebMvc
@MapperScan(basePackages = "com.cst.bigdata.repository.mybatis")
public class BigdataHbaseApplication {

    public static void main(String... args){

       //ConfigurableApplicationContext context= SpringApplication.run(BigdataHbaseApplication.class, args);

        SpringApplication springApplication = new SpringApplication(BigdataHbaseApplication.class);

        ProfileUtil.addDefaultProfile(springApplication);
        springApplication.addListeners(new ApplicationListener<ApplicationEvent>(){

            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println("------------------haha---------");
            }
        });
        springApplication.addListeners(new ApplicationListener<ApplicationStartingEvent>(){

            @Override
            public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
                System.out.println("-----------starting-------------");
            }
        });

        ConfigurableApplicationContext context = springApplication.run(args);
        Environment env = context.getEnvironment();
        System.out.println(
        env.getProperty("spring.application.name")+"================"+
        env.getProperty("server.port"));

        System.out.println(context.getBean("sqlSessionFactory"));
        System.out.println(context.getBean("appOilPriceMapper"));
    }
}
