package br.com.db1.hackathon.domain.translator;

import br.com.db1.hackathon.domain.dto.HistoricDTO;
import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.infrastructure.Translator;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class HistoricTranslator implements Translator<HistoricDTO, Historic> {

    @Override
    public Historic translate(HistoricDTO historicDTO) {
        return Historic.builder()
                .withId(historicDTO.getId())
                .withCode(historicDTO.getCode())
                .withDate(Objects.isNull(historicDTO.getDate()) ? new Date() : historicDTO.getDate())
                .withValue(historicDTO.getValue())
                .build();
    }
}
