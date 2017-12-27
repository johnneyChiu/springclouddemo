package com.cst.stream.common;



/**
 * @author Johnney.chiu
 * create on 2017/11/30 17:30
 * @Description 定义最后一次上传的数据
 */
public class LastTimeData<T> {
    private Long lastTime=0l;

    private T data;

    public T getData() {
        return data;
    }

    public LastTimeData(Long lastTime, T data) {
        this.lastTime = lastTime;
        this.data = data;
    }

    public LastTimeData() {
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }
}
