package br.com.db1.hackathon.domain.dto;

import java.io.Serializable;
import java.util.Set;

public class PlaceDTO implements Serializable{

    private static final long serialVersionUID = 9013129221193411006L;

    private Long id;

    private String description;

    private Set<SensorDTO> sensors;

    public PlaceDTO() {
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

    public Set<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(Set<SensorDTO> sensors) {
        this.sensors = sensors;
    }
}
