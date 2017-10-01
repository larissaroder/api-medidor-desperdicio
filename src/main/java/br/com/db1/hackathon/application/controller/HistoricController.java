package br.com.db1.hackathon.application.controller;

import br.com.db1.hackathon.domain.dto.HistoricDTO;
import br.com.db1.hackathon.domain.model.Historic;
import br.com.db1.hackathon.domain.service.HistoricService;
import br.com.db1.hackathon.domain.translator.HistoricDTOTranslator;
import br.com.db1.hackathon.domain.translator.HistoricTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/historic")

public class HistoricController {

    @Autowired
    private HistoricService historicService;

    @Autowired
    private HistoricTranslator historicTranslator;

    @Autowired
    private HistoricDTOTranslator historicDTOTranslator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody final List<HistoricDTO> historicDTO) {
        try {
            List<Historic> historic = historicTranslator.translateList(historicDTO);
            historicService.save(historic);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            Set<Historic> historics = historicService.findAll();
            return new ResponseEntity<>(historicDTOTranslator.translateSet(historics), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public HistoricDTO findLast(@PathVariable final String code) {
        Historic historic = historicService.findLast(code);
        return historicDTOTranslator.translate(historic);
    }
}
