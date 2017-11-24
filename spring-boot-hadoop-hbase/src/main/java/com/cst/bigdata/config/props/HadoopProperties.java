package com.cst.bigdata.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author Johnney.chiu
 * create on 2017/11/24 11:16
 * @Description hadoop的属性设置
 */

@ConfigurationProperties(prefix = "hadoop")
public class HadoopProperties {

    private String hadoopHomeDir;

    private List<String> hadoopCoreFile;

    private String crossPlatform;

    private String ubertask;


    public String getHadoopHomeDir() {
        return hadoopHomeDir;
    }

    public void setHadoopHomeDir(String hadoopHomeDir) {
        this.hadoopHomeDir = hadoopHomeDir;
    }

    public List<String> getHadoopCoreFile() {
        return hadoopCoreFile;
    }

    public void setHadoopCoreFile(List<String> hadoopCoreFile) {
        this.hadoopCoreFile = hadoopCoreFile;
    }

    public String getCrossPlatform() {
        return crossPlatform;
    }

    public void setCrossPlatform(String crossPlatform) {
        this.crossPlatform = crossPlatform;
    }

    public String getUbertask() {
        return ubertask;
    }

    public void setUbertask(String ubertask) {
        this.ubertask = ubertask;
    }
}
