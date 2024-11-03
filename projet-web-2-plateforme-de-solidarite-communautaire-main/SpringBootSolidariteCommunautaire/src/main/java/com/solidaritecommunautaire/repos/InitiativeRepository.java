package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Ressources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitiativeRepository extends CrudRepository<InitiativeCaritative,Integer> {

    @Query("SELECT u FROM InitiativeCaritative u JOIN u.individu r WHERE r.id=?1")
    public List<InitiativeCaritative> findAllByIdIndividu(Integer id);

    public Long countById(Integer id);
}
