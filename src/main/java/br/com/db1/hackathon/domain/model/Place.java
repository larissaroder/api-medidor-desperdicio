package br.com.db1.hackathon.domain.model;

import com.google.common.collect.Sets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place implements Serializable {

    private static final long serialVersionUID = 5511865185349803260L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "place_sensor",
            joinColumns = {@JoinColumn(name = "place_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "sensor_id", nullable = false)}, uniqueConstraints = @UniqueConstraint(columnNames = {"place_id", "sensor_id"}))

    private Set<Sensor> sensors = Sets.newHashSet();

    public Place() {
        //Serializable
    }

    private Place(Builder builder) {
        id = builder.id;
        description = builder.description;
        sensors = builder.sensors;
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

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public static class Builder {

        private Long id;

        private String description;

        private Set<Sensor> sensors = Sets.newHashSet();

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withSensors(Set<Sensor> sensors) {
            if(Objects.nonNull(sensors)){
                this.sensors = sensors;
            }
            return this;
        }

        public Place build() {
            return new Place(this);
        }
    }
}
