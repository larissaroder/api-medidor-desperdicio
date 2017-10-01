package br.com.db1.hackathon.application.controller;

import br.com.db1.hackathon.domain.dto.SensorDTO;
import br.com.db1.hackathon.domain.model.Sensor;
import br.com.db1.hackathon.domain.service.SensorService;
import br.com.db1.hackathon.domain.translator.SensorDTOTranslator;
import br.com.db1.hackathon.domain.translator.SensorTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorTranslator sensorTranslator;

    @Autowired
    private SensorDTOTranslator sensorDTOTranslator;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public SensorDTO save(@RequestBody final SensorDTO sensorDTO) {
        Sensor sensor = sensorTranslator.translate(sensorDTO);
        Sensor sensorSaved = sensorService.save(sensor);
        return sensorDTOTranslator.translate(sensorSaved);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Long id) {
        Sensor sensor = sensorService.findById(id);
        sensorService.delete(sensor);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            Set<Sensor> sensors = sensorService.findAll();
            return new ResponseEntity<>(sensorDTOTranslator.translateSet(sensors), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SensorDTO findById(@PathVariable final Long id) {
        Sensor sensor = sensorService.findById(id);
        return sensorDTOTranslator.translate(sensor);
    }
}
