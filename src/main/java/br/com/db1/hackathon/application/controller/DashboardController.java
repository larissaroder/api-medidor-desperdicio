package br.com.db1.hackathon.application.controller;

import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.service.PlaceService;
import br.com.db1.hackathon.domain.translator.DashboardDTOTranslator;
import br.com.db1.hackathon.domain.translator.PlaceTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/dashboards")
public class DashboardController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceTranslator placeTranslator;

    @Autowired
    private DashboardDTOTranslator dashboardDTOTranslator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {

        try {
            Set<Place> places = placeService.findAll();
            return new ResponseEntity<>(dashboardDTOTranslator.translateSet(places), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
