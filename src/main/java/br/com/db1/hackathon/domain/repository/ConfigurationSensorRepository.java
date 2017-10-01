package br.com.db1.hackathon.domain.repository;

import br.com.db1.hackathon.domain.model.ConfigurationSensor;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.model.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ConfigurationSensorRepository extends CrudRepository<ConfigurationSensor, Long> {

    ConfigurationSensor findBySensor(Sensor sensor);
}
