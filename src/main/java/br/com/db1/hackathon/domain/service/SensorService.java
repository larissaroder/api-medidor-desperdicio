package br.com.db1.hackathon.domain.service;

import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public void delete(Sensor sensor) {
        sensorRepository.delete(sensor);
    }

    public Set<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findById(Long id) {
        return sensorRepository.findOne(id);
    }
}
