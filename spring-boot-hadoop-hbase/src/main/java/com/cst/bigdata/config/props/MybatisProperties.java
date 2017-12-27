package com.cst.bigdata.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Johnney.chiu
 * create on 2017/12/11 16:30
 * @Description test
 */
@ConfigurationProperties(prefix = "mybatis")
public class MybatisProperties {

    private String mapperLocations;

    private String typeAliasesPackage;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
