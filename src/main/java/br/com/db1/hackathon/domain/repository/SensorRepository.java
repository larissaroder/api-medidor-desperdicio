package br.com.db1.hackathon.domain.repository;

import br.com.db1.hackathon.domain.model.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface SensorRepository extends CrudRepository<Sensor, Long> {

    Set<Sensor> findAll();
}
