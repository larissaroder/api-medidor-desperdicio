package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.ConfigurationSensorDTO;
import br.com.db1.hackathon.domain.dto.SensorDTO;
import br.com.db1.hackathon.domain.model.ConfigurationSensor;
import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.service.HistoricService;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConfigurationSensorDTOTranslator implements Translator<ConfigurationSensor, ConfigurationSensorDTO> {

    @Override
    public ConfigurationSensorDTO translate(ConfigurationSensor configurationSensor) {
        ConfigurationSensorDTO dto = new ConfigurationSensorDTO();
        dto.setId(configurationSensor.getId());
        dto.setMaxValueUnit(configurationSensor.getMaxValueUnit());

        if(Objects.nonNull(configurationSensor.getSensor())){
            dto.setSensorCode(configurationSensor.getSensor().getCode());
        }

        return dto;
    }
}
