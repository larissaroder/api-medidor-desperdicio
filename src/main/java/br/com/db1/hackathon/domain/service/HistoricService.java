package br.com.db1.hackathon.domain.service;

import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.domain.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HistoricService {

    @Autowired
    private HistoricRepository historicRepository;

    public void save(List<Historic> historic) {
        historicRepository.save(historic);
    }

    public Set<Historic> findAll() {
        return historicRepository.findAll();
    }

    public Historic findLast(String code) {
        return historicRepository.findLast(code);
    }
}
