package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.DashboardDTO;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardDTOTranslator implements Translator<Place, DashboardDTO> {

    @Autowired
    private PlaceDTOTranslator placeDTOTranslator;

    @Override
    public DashboardDTO translate(Place place) {
        DashboardDTO dto = new DashboardDTO();
        dto.setPlace(placeDTOTranslator.translate(place));
        return dto;
    }
}
