package br.com.db1.hackathon.domain.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {

    private static final long serialVersionUID = -7355038990597840983L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private SensorType sensorType;

    protected Sensor() {
        //Serializable
    }

    private Sensor(Builder builder) {
        id = builder.id;
        description = builder.description;
        sensorType = builder.sensorType;
        code = builder.code;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public String getCode() {
        return code;
    }

    public static class Builder {

        private Long id;

        private String description;

        private String code;

        private SensorType sensorType;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withSensorType(SensorType sensorType) {
            this.sensorType = sensorType;
            return this;
        }

        public Sensor build() {
            return new Sensor(this);
        }
    }
}
