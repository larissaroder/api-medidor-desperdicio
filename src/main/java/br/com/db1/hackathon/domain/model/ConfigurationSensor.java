package br.com.db1.hackathon.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "configuration_sensor")
public class ConfigurationSensor implements Serializable {

    private static final long serialVersionUID = 7849866829276210920L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Sensor sensor;

    @Column
    private String maxValueUnit;

    public ConfigurationSensor() {
        // Serializable
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public String getMaxValueUnit() {
        return maxValueUnit;
    }
}
