package br.com.db1.hackathon.domain.dto;

import br.com.db1.hackathon.domain.model.SensorType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SensorDTO implements Serializable{

    private static final long serialVersionUID = -8933177813872177416L;

    private Long id;

    private String description;

    private String code;

    private SensorType sensorType;

    private HistoricDTO historic;

    private ConfigurationSensorDTO configuration;

    private String icon;

    private String critical;

    private String unit;

    public SensorDTO() {
        critical = "normal";
        icon = "fa fa-check";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public HistoricDTO getHistoric() {
        return historic;
    }

    public void setHistoric(HistoricDTO historic) {
        this.historic = historic;
    }

    public ConfigurationSensorDTO getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConfigurationSensorDTO configuration) {
        this.configuration = configuration;
    }

    public String getIcon() {
        if (Objects.isNull(historic) || Objects.isNull(configuration)){
            return icon;
        }

        if (SensorType.DISTANCE.equals(sensorType)) {
            if (new BigDecimal(historic.getValue()).compareTo(new BigDecimal(configuration.getMaxValueUnit())) < 0) {
                return "fa fa-bomb";
            }
        }

        if (SensorType.ELETRIC_CURRENT.equals(sensorType)) {
            if (new BigDecimal(historic.getValue()).compareTo(new BigDecimal(configuration.getMaxValueUnit())) > 0) {
                return "fa fa-bomb";
            }
        }

        if (SensorType.PLUVIOMETER.equals(sensorType)) {
            if (historic.getValue().equals(configuration.getMaxValueUnit())) {
                return "fa fa-umbrella";
            }
            return "fa fa-sun-o";
        }
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCritical() {
        if (Objects.isNull(historic) || Objects.isNull(configuration)){
            return critical;
        }

        if (SensorType.DISTANCE.equals(sensorType)) {
            if (new BigDecimal(historic.getValue()).compareTo(new BigDecimal(configuration.getMaxValueUnit())) < 0) {
                return "critical";
            }
        }

        if (SensorType.ELETRIC_CURRENT.equals(sensorType)) {
            if (new BigDecimal(historic.getValue()).compareTo(new BigDecimal(configuration.getMaxValueUnit())) > 0) {
                return "critical";
            }
        }

        if (SensorType.PLUVIOMETER.equals(sensorType)) {
            if (historic.getValue().equals(configuration.getMaxValueUnit())) {
                return "rain";
            }
            return "sun";
        }
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getUnit() {
        if (Objects.nonNull(sensorType)) {
            return sensorType.getUnit();
        }
        return "";
    }

}
