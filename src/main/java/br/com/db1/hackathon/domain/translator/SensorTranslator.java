package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.SensorDTO;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.stereotype.Component;

@Component
public class SensorTranslator implements Translator<SensorDTO, Sensor> {

    @Override
    public Sensor translate(SensorDTO sensorDTO) {

        return Sensor.builder()
                .withId(sensorDTO.getId())
                .withDescription(sensorDTO.getDescription())
                .withSensorType(sensorDTO.getSensorType())
                .withCode(sensorDTO.getCode())
                .build();
    }
}
