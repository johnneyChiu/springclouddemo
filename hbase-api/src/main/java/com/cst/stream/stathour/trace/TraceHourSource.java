package com.cst.stream.stathour.trace;

/**
 * @author Johnney.chiu
 * create on 2017/11/28 14:33
 * @Description 轨迹源数据
 */
public class TraceHourSource {

    private String carId;
    // 轨迹ID
    private String travelUuid;

    private Long startTime;

    private Long stopTime;

    // 一个驾驶循环总里程"KM";
    private Float tripDistance;

    //轨迹类型  0：临时轨迹 ； 1：完整轨迹； 2：熄火后轨迹
    private Integer travelType;

    //轨迹行驶时间
    private Integer tripDriveTime;

    public TraceHourSource(String carId, String travelUuid, Long startTime, Long stopTime, Float tripDistance, Integer travelType, Integer tripDriveTime) {
        this.carId = carId;
        this.travelUuid = travelUuid;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.tripDistance = tripDistance;
        this.travelType = travelType;
        this.tripDriveTime = tripDriveTime;
    }

    public TraceHourSource() {
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getTravelUuid() {
        return travelUuid;
    }

    public void setTravelUuid(String travelUuid) {
        this.travelUuid = travelUuid;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getStopTime() {
        return stopTime;
    }

    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }

    public Float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Float tripDistance) {
        this.tripDistance = tripDistance;
    }

    public Integer getTravelType() {
        return travelType;
    }

    public void setTravelType(Integer travelType) {
        this.travelType = travelType;
    }

    public Integer getTripDriveTime() {
        return tripDriveTime;
    }

    public void setTripDriveTime(Integer tripDriveTime) {
        this.tripDriveTime = tripDriveTime;
    }
}
