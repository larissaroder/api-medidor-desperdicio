package br.com.db1.hackathon.domain.service;

import br.com.db1.hackathon.domain.model.Place;
import br.com.db1.hackathon.domain.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public void delete(Place place) {
        placeRepository.delete(place);
    }

    public Set<Place> findAll() {
        return placeRepository.findAll();
    }

    public Place findById(Long id) {
        return placeRepository.findOne(id);
    }
}
