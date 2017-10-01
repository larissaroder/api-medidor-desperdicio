package br.com.db1.hackathon.application.controller;

import br.com.db1.hackathon.domain.dto.PlaceDTO;
import br.com.db1.hackathon.domain.email.MailUtil;
import br.com.db1.hackathon.domain.email.SimpleMail;
import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.service.PlaceService;
import br.com.db1.hackathon.domain.translator.PlaceDTOTranslator;
import br.com.db1.hackathon.domain.translator.PlaceTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceTranslator placeTranslator;

    @Autowired
    private PlaceDTOTranslator placeDTOTranslator;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public PlaceDTO save(@RequestBody final PlaceDTO placeDTO) {
        Place place = placeTranslator.translate(placeDTO);
        Place placeSaved = placeService.save(place);
        return placeDTOTranslator.translate(placeSaved);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Long id) {
        Place place = placeService.findById(id);
        placeService.delete(place);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<PlaceDTO> findAll() {
        SimpleMail.sendMail();
        Set<Place> places = placeService.findAll();
        return placeDTOTranslator.translateSet(places);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PlaceDTO findById(@PathVariable final Long id) {
        Place place = placeService.findById(id);
        return placeDTOTranslator.translate(place);
    }
}
