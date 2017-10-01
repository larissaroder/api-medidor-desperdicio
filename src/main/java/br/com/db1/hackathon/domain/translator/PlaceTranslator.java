package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.PlaceDTO;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaceTranslator implements Translator<PlaceDTO, Place> {

    @Autowired
    private SensorTranslator sensorTranslator;

    @Override
    public Place translate(PlaceDTO placeDTO) {
        return Place.builder()
                .withId(placeDTO.getId())
                .withDescription(placeDTO.getDescription())
                .withSensors(sensorTranslator.translateSet(placeDTO.getSensors()))
                .build();
    }
}
