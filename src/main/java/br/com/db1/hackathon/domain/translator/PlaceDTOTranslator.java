package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.PlaceDTO;
import br.com.db1.hackathon.domain.model.ConfigurationSensor;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.service.ConfigurationSensorService;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PlaceDTOTranslator implements Translator<Place, PlaceDTO> {

    @Autowired
    private SensorDTOTranslator sensorDTOTranslator;
    @Autowired
    private SensorTranslator sensorTranslator;
    @Autowired
    private ConfigurationSensorService configurationSensorService;
    @Autowired
    private ConfigurationSensorDTOTranslator configurationSensorDTOTranslator;

    @Override
    public PlaceDTO translate(Place place) {
        PlaceDTO dto = new PlaceDTO();
        dto.setId(place.getId());
        dto.setDescription(place.getDescription());

        if(Objects.nonNull(place.getSensors()) && !place.getSensors().isEmpty()){
            dto.setSensors(sensorDTOTranslator.translateSet(place.getSensors()));
        }

        dto.getSensors().forEach( sensorDTO -> {
            Sensor sensor = sensorTranslator.translate(sensorDTO);
            ConfigurationSensor configuration = configurationSensorService.findBySensor(sensor);
            sensorDTO.setConfiguration(configurationSensorDTOTranslator.translate(configuration));


        });

        return dto;
    }
}
