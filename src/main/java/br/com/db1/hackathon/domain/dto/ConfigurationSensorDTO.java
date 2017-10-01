package br.com.db1.hackathon.domain.dto;

import java.io.Serializable;

public class ConfigurationSensorDTO implements Serializable {


    private static final long serialVersionUID = 962060811871003471L;
    private Long id;

    private String sensorCode;

    private String maxValueUnit;

    public ConfigurationSensorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public String getMaxValueUnit() {
        return maxValueUnit;
    }

    public void setMaxValueUnit(String maxValueUnit) {
        this.maxValueUnit = maxValueUnit;
    }
}
