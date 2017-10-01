package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.SensorDTO;
import br.com.db1.hackathon.domain.model.ConfigurationSensor;
import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.service.ConfigurationSensorService;
import br.com.db1.hackathon.domain.service.HistoricService;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SensorDTOTranslator implements Translator<Sensor, SensorDTO> {

    @Autowired
    private HistoricService historicService;
    @Autowired
    private HistoricDTOTranslator historicDTOTranslator;


    @Override
    public SensorDTO translate(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setId(sensor.getId());
        dto.setDescription(sensor.getDescription());
        dto.setSensorType(sensor.getSensorType());
        dto.setCode(sensor.getCode());

        Historic historic = historicService.findLast(sensor.getCode());
        if(Objects.nonNull(historic)){
            dto.setHistoric(historicDTOTranslator.translate(historic));
        }

        return dto;
    }
}
