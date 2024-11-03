package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Dons;
import com.solidaritecommunautaire.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonRepository extends CrudRepository<Dons,Integer> {

    @Query("SELECT u FROM Dons u JOIN u.individu r WHERE r.id=?1")
    public List<Dons> findAllByIdIndividu(Integer id);
}
