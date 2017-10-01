package br.com.db1.hackathon.domain.service;

import br.com.db1.hackathon.domain.model.ConfigurationSensor;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.repository.ConfigurationSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationSensorService {

    @Autowired
    private ConfigurationSensorRepository configurationSensorRepository;

    public ConfigurationSensor findBySensor(Sensor sensor) {
        return configurationSensorRepository.findBySensor(sensor);
    }
}
