package br.com.db1.hackathon.domain.repository;

import br.com.db1.hackathon.domain.model.Historic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface HistoricRepository extends CrudRepository<Historic, Long> {

    Set<Historic> findAll();

    @Query("select h from Historic h where h.code = ?#{[0]} and h.date = (select max(h2.date) from Historic h2 where h2.code = h.code)")
    Historic findLast(String code);
}
