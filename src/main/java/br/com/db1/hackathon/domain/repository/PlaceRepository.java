package br.com.db1.hackathon.domain.repository;

import br.com.db1.hackathon.domain.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    Set<Place> findAll();
}
