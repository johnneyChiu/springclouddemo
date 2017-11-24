package com.cst.bigdata.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Johnney.chiu
 * create on 2017/11/23 14:15
 * @Description 连接hbase的属性
 */
@ConfigurationProperties(prefix = "hbase")
public class HbaseProperties {

    private String zkQuorum;

    private String zkPort;

    private String rootDir;

    private String zkDataDir;

    public String getZkQuorum() {
        return zkQuorum;
    }

    public void setZkQuorum(String zkQuorum) {
        this.zkQuorum = zkQuorum;
    }

    public String getZkPort() {
        return zkPort;
    }

    public void setZkPort(String zkPort) {
        this.zkPort = zkPort;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getZkDataDir() {
        return zkDataDir;
    }

    public void setZkDataDir(String zkDataDir) {
        this.zkDataDir = zkDataDir;
    }
}
