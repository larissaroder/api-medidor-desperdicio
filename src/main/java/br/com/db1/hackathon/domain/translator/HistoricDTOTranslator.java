package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.HistoricDTO;
import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.stereotype.Component;

@Component
public class HistoricDTOTranslator implements Translator<Historic, HistoricDTO> {

    @Override
    public HistoricDTO translate(Historic historic) {
        HistoricDTO dto = new HistoricDTO();
        dto.setId(historic.getId());
        dto.setCode(historic.getCode());
        dto.setDate(historic.getDate());
        dto.setValue(historic.getValue());
        return dto;
    }
}
